package ru.burn.AuthorizationService.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.burn.AuthorizationService.model.User;

import java.util.List;

@Configuration
public class AuthorizServiceWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new CustomParamResolverImplHandlerMethodArgumentResolver());
    }


    private class CustomParamResolverImplHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
        @Override
        public boolean supportsParameter(MethodParameter parameter) {
            return parameter.getParameterType().equals(User.class);
        }

        @Override
        public Object resolveArgument(MethodParameter parameter,
                                      ModelAndViewContainer mavContainer,
                                      NativeWebRequest webRequest,
                                      WebDataBinderFactory binderFactory) {
            String name = webRequest.getParameter("user");
            String password = webRequest.getParameter("password");
            return new User(name, password);
        }
    }
}
