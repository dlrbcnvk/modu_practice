package com.modu.ResourceServer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class ResourceServerConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(request -> request
                        .anyRequest().permitAll());

        http.httpBasic().disable();
        http.formLogin().disable();


        http.cors().configurationSource(corsConfigurationSource());
        http.csrf().disable();

        return http.build();
    }

    // 현재는 모든 서버들이 localhost이므로 포트로 나뉠 수밖에 없어서 cors 적용 불가할 듯...?
    // 배포될 때 서버가 도메인별로 나뉘어지면 그때 게이트웨이 서버만 허용할 수 있도록 cors origin 설정을 해주어야 함
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://127.0.0.1");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        configuration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
