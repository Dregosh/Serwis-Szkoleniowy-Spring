package pl.sda.bootcamp.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/admin/**").authenticated()
            .antMatchers("/panel-klienta/**").authenticated()
            .antMatchers("/panel-trenera/**").authenticated()
            .anyRequest().permitAll()
            .and().formLogin()
            .and().logout().logoutSuccessUrl("/");
    }
}
