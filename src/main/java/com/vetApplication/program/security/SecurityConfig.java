package com.vetApplication.program.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.vetApplication.program.security.ApplicationUserRole.*;
import static com.vetApplication.program.security.ApplicationUserRole.EMPLEADO;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests() // Autorizas las request
                .antMatchers("/","index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(ADMIN.name())
                .anyRequest() // todas las request tienen que ser autenticadas passs user
                .authenticated()
                .and()
                .httpBasic(); // autenticacion basica

    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
      UserDetails nicoUser = User.builder()
                .username("nico")
                .password(passwordEncoder.encode("password"))
               // .roles(ADMIN.name()) // ROLE_ADMIN
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

      UserDetails empleadoUser = User.builder()
              .username("empleado")
              .password(passwordEncoder.encode("password123"))
              //.roles(EMPLEADO.name()) // ROLE_EMPLEADO
              .authorities(EMPLEADO.getGrantedAuthorities())
              .build();

      UserDetails tomUser = User.builder()
              .username("tom")
              .password(passwordEncoder.encode("password"))
              //.roles(ADMINTRAINEE.name()) // ROLE_ADMINTRAINEE
              .authorities(ADMINTRAINEE.getGrantedAuthorities())
              .build();

      return new InMemoryUserDetailsManager(
              nicoUser,
              empleadoUser,
              tomUser
      );

    }
}
