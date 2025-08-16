package com.ko.playground.basic.config;

import com.ko.playground.basic.auth.AuthenticatedParentArgumentResolver;
import com.ko.playground.basic.auth.AuthenticatedSantaArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final AuthenticatedParentArgumentResolver authenticatedParentArgumentResolver;
    private final AuthenticatedSantaArgumentResolver authenticatedSantaArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(authenticatedParentArgumentResolver);
        resolvers.add(authenticatedSantaArgumentResolver);
    }
}
