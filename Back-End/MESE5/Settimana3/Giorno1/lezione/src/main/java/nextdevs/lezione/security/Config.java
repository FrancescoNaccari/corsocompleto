package nextdevs.lezione.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Config {

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity)throws Exception {
        httpSecurity.formLogin(http->http.disable());
        httpSecurity.csrf(http->http.disable());
        httpSecurity.sessionManagement(http->http.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // httpSecurity.authorizeHttpRequests(http->http.requestMatchers("/**").permitAll());
        httpSecurity.authorizeHttpRequests(http->http.requestMatchers(HttpMethod.GET,"/apa/users").permitAll());
       httpSecurity.authorizeHttpRequests(http->http.requestMatchers("/**").denyAll());
        return httpSecurity.build();


    }
}
