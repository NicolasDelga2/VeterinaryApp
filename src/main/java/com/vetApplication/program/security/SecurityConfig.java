package com.vetApplication.program.security;

import com.vetApplication.program.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.concurrent.TimeUnit;

import static com.vetApplication.program.security.ApplicationUserRole.*;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // Para trabajar con anotaciones de seguridad en los endpoints
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder,
                          UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //   .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                //   .and()
                .csrf().disable()
                .authorizeRequests() // Autorizas las request
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(ADMIN.name())
                .anyRequest() // todas las request tienen que ser autenticadas passs user
                .authenticated()
                .and()
                //.httpBasic(); // autenticacion basica
                .formLogin() // Form log in authentication
                        .loginPage("/login")
                        .permitAll()
                        .defaultSuccessUrl("/users", true)
                        .passwordParameter("password")
                        .usernameParameter("username")
                .and()  // La sesion es por 30 minutos con remember me extendes el tiempo.
                .rememberMe().tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21))
                .key("somethingverysecured")// dos semanas
                .rememberMeParameter("remember-me")
                .and()
                    .logout()
                    .logoutUrl("/logout")
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                    .clearAuthentication(true)
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID", "remember-me", "PHPSESSID")
                    .logoutSuccessUrl("/login");
    }

    /*
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
    }    */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }
}
