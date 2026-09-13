package io.github.celitech.celitechsdk.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Tolerant Jackson deserializer for {@link LocalDate}. Accepts, in order:
 * <ul>
 *   <li>an epoch as a JSON number (or a numeric string) — milliseconds when the
 *       magnitude is at least 1e12, otherwise seconds — as the calendar date at UTC;</li>
 *   <li>ISO-8601 date (e.g. {@code 2024-01-01});</li>
 *   <li>ISO-8601 date-time with an offset (e.g. {@code 2024-01-01T00:00:00Z}), keeping the date;</li>
 *   <li>ISO-8601 date-time without an offset (e.g. {@code 2024-01-01T00:00:00}), keeping the date;</li>
 *   <li>RFC-1123 / RFC-2822 (e.g. {@code Tue, 15 Aug 2023 12:34:56 GMT}), keeping the date.</li>
 * </ul>
 * Blank values deserialize to {@code null}; a value matching none of these formats
 * is rejected with a {@link DateTimeParseException}.
 */
public class DateDeserializer extends JsonDeserializer<LocalDate> {

  // Epoch values at or above this magnitude are treated as milliseconds, otherwise seconds.
  private static final long EPOCH_MILLIS_THRESHOLD = 1_000_000_000_000L;

  @Override
  public LocalDate deserialize(JsonParser parser, DeserializationContext context)
    throws IOException {
    if (parser.currentToken() == JsonToken.VALUE_NUMBER_INT) {
      return fromEpoch(parser.getLongValue());
    }

    String value = parser.getValueAsString();
    if (value == null || value.trim().isEmpty()) {
      return null;
    }
    return parseString(value.trim());
  }

  private LocalDate parseString(String value) {
    LocalDate epoch = tryParseEpoch(value);
    if (epoch != null) {
      return epoch;
    }
    try {
      return LocalDate.parse(value, DateTimeFormatter.ISO_LOCAL_DATE);
    } catch (DateTimeParseException notLocalDate) {
      // Not a bare ISO date; try the next tolerated format.
    }
    try {
      return OffsetDateTime.parse(value, DateTimeFormatter.ISO_OFFSET_DATE_TIME).toLocalDate();
    } catch (DateTimeParseException notOffsetDateTime) {
      // Not an offset date-time; try the next tolerated format.
    }
    try {
      return LocalDateTime.parse(value, DateTimeFormatter.ISO_LOCAL_DATE_TIME).toLocalDate();
    } catch (DateTimeParseException notLocalDateTime) {
      // Not an offset-less ISO date-time; fall back to RFC-1123 / RFC-2822.
    }
    return OffsetDateTime.parse(value, DateTimeFormatter.RFC_1123_DATE_TIME).toLocalDate();
  }

  /**
   * Parses a bare numeric string as an epoch. Returns {@code null} when the value
   * is not all-digits (optionally sign-prefixed) or is too large to fit a
   * {@code long}, so the caller falls through to the date string formats.
   */
  private static LocalDate tryParseEpoch(String value) {
    int start = value.charAt(0) == '-' ? 1 : 0;
    if (start == value.length()) {
      return null;
    }
    for (int i = start; i < value.length(); i++) {
      if (!Character.isDigit(value.charAt(i))) {
        return null;
      }
    }
    try {
      return fromEpoch(Long.parseLong(value));
    } catch (NumberFormatException tooLargeForEpoch) {
      return null;
    }
  }

  private static LocalDate fromEpoch(long epoch) {
    Instant instant = Math.abs(epoch) >= EPOCH_MILLIS_THRESHOLD
      ? Instant.ofEpochMilli(epoch)
      : Instant.ofEpochSecond(epoch);
    return instant.atOffset(ZoneOffset.UTC).toLocalDate();
  }
}
