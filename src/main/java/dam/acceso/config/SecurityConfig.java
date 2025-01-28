package dam.acceso.config;

import dam.acceso.filter.JwtRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .authorizeHttpRequests(authorizeRequestsCustomizer -> authorizeRequestsCustomizer
                        .requestMatchers(HttpMethod.POST, "/authenticate").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/hoteles/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/habitaciones/**").permitAll()
                        .requestMatchers("/doc/**", "/v3/api-docs/**").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(sessionManagementConfigurer -> sessionManagementConfigurer
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .exceptionHandling(exceptionHandlingConfigurer -> exceptionHandlingConfigurer
                        .authenticationEntryPoint((request, response, authException) -> {
                            response.setStatus(HttpStatus.UNAUTHORIZED.value());
                            response.setContentType("application/json");
                            response.getWriter().write("{\"status\": 401, \"message\": \"Acceso denegado. Revisa la solicitud.\"}");
                        })
                        .accessDeniedHandler((request, response, accessDeniedException) -> {
                            response.setStatus(HttpStatus.FORBIDDEN.value());
                            response.setContentType("application/json");
                            response.getWriter().write("{\"status\": 403, \"message\": \"Acceso denegado. No tienes permiso para acceder a este recurso.\"}");
                        })
//                        .defaultAuthenticationEntryPointFor(
//                        (request, response, authException) -> {
//                            response.setStatus(HttpStatus.NOT_FOUND.value());
//                            response.setContentType("application/json");
//                            response.getWriter().write("{\"status\": 404, \"message\": \"Recurso no encontrado.\"}");
//                        }, new AntPathRequestMatcher("/**"))
//                        .defaultAuthenticationEntryPointFor(
//                        (request, response, authException) -> {
//                            response.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
//                            response.setContentType("application/json");
//                            response.getWriter().write("{\"status\": 405, \"message\": \"Metodo no permitido. Por favor, revisa el metodo HTTP utilizado.\"}");
//                        }, new AntPathRequestMatcher("/**"))
//                        .defaultAuthenticationEntryPointFor(
//                        (request, response, authException) -> {
//                            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
//                            response.setContentType("application/json");
//                            response.getWriter().write("{\"status\": 500, \"message\": \"Error interno del servidor. Por favor, inténtalo de nuevo más tarde.\"}");
//                            }, new AntPathRequestMatcher("/**"))
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}