package com.ayush.spring_security.config;
import com.ayush.spring_security.security.CustomUserDetailsService;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class security_config {

    private final CustomUserDetailsService userdetailsservice;

    public security_config(CustomUserDetailsService userdetailsservice){
        this.userdetailsservice=userdetailsservice;
    }
    @Bean
    public SecurityFilterChain securityfilterchain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/register").permitAll()
                        .requestMatchers("/admin/**").hasAuthority("ADMIN")
                        .requestMatchers("/user/**").hasAnyAuthority("USER", "ADMIN")
                        .anyRequest().authenticated()
                )
                .userDetailsService(userdetailsservice)
                .formLogin(form -> form.defaultSuccessUrl("/", true));

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordencoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationmanager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }

}
