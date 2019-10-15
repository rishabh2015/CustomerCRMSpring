package crm;

import crm.service.SpringDataUserDetailsService;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	logger.debug("checking the security of this req");
    	auth.userDetailsService(customUserDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	logger.debug("checking the security of this req");
    	http.csrf().ignoringAntMatchers("/registerUser").and()
        .authorizeRequests()
                .antMatchers("/admin/**", "/user/delete/**").hasRole("ADMIN")
                .antMatchers("/pdf-generator", "/search/**", "/customer/**", "/user/edit/**", "/user/list", "/contract/**").hasAnyRole( "ADMIN", "USER", "MANAGER", "OWNER")
                .anyRequest().permitAll()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().logoutSuccessUrl("/").permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403");
    }

}
