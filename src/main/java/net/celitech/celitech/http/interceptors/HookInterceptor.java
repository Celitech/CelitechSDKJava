package net.celitech.celitech.http.interceptors;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.celitech.celitech.config.CelitechConfig;
import net.celitech.celitech.hook.Hook;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HookInterceptor implements Interceptor {

  private final Hook hook;

  private final Map<String, String> additionalParameters = new HashMap<>();

  public HookInterceptor(Hook hook, CelitechConfig config) {
    super();
    this.hook = hook;

    setClientId(config.getClientId());
    setClientSecret(config.getClientSecret());
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = hook.beforeRequest(chain.request(), additionalParameters);

    Response response;
    try {
      response = chain.proceed(request);
    } catch (Exception e) {
      hook.onError(chain.request(), e, additionalParameters);
      throw e;
    }

    response = hook.afterResponse(request, response, additionalParameters);
    return response;
  }

  public void setClientId(String clientId) {
    this.additionalParameters.put("clientId", clientId);
  }

  public void setClientSecret(String clientSecret) {
    this.additionalParameters.put("clientSecret", clientSecret);
  }
}
