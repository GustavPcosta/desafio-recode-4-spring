package br.com.travell.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


import br.com.travell.servicos.Servicos;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	@Autowired
	private Servicos servicesImpl;

	  @SuppressWarnings("deprecation")
	@Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	        .requestMatchers("/adminlte/**").permitAll()
	            .requestMatchers("/img/**").permitAll()
	            .requestMatchers("/js/**").permitAll()
	            .requestMatchers("/plugins/**").permitAll()
	            .anyRequest().authenticated();

	        http.formLogin()
	            .loginPage("/login")
	            .defaultSuccessUrl("/clientes")
	            .permitAll();
	        
	        http.logout()
            .logoutRequestMatcher(
                new AntPathRequestMatcher("/logout", "GET")
            )
            .logoutSuccessUrl("/login");
	       
	    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(servicesImpl).passwordEncoder(new BCryptPasswordEncoder());
	}
}

