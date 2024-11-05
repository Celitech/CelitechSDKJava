package io.github.celitech.celitechsdk.http.interceptors;

import io.github.celitech.celitechsdk.hook.Hook;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HookInterceptor implements Interceptor {

  private final Hook hook;

  private final Map<String, String> additionalParameters = new HashMap<>();

  public HookInterceptor(Hook hook) {
    super();
    this.hook = hook;
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
}
