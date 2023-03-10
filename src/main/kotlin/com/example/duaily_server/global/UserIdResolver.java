package com.example.duaily_server.global;

import java.util.Objects;
import javax.validation.constraints.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class UserIdResolver implements HandlerMethodArgumentResolver {

  private final TokenUtils tokenUtils;

  public UserIdResolver(TokenUtils tokenUtils) {
    this.tokenUtils = tokenUtils;
  }

  @Override
  public boolean supportsParameter(MethodParameter parameter)
  {
    return parameter.hasParameterAnnotation(UserId.class) && String.class.equals(parameter.getParameterType());
  }

  @Nullable
  @Override
  public Object resolveArgument(@NotNull MethodParameter parameter,
      ModelAndViewContainer mavContainer,
      @NotNull NativeWebRequest webRequest,
      WebDataBinderFactory binderFactory) throws Exception
  {
    Auth auth = parameter.getMethodAnnotation(Auth.class);
    if (auth == null) {
      throw new Exception("토큰을 통해 userId를 추출하는 메서드에는 @Auth 어노테이션을 붙여주세요.");
    }
    String userId = tokenUtils.getUserIdFromToken(
        Objects.requireNonNull(webRequest.getHeader("ACCESS-TOKEN")));

    if (!auth.optional() && userId == null) {
      throw new Exception(("토큰으로 부터 추출한 userId가 Null입니다."));
    }
    return userId;
  }

}