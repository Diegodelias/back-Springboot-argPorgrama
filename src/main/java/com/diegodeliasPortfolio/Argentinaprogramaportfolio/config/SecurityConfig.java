package com.diegodeliasPortfolio.Argentinaprogramaportfolio.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.filter.JwtFilter;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.service.CustomUserDetailsService;
import org.springframework.security.config.http.SessionCreationPolicy;



@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

  
    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    private static final String[] AUTH_WHITELIST = {
        "/usuarios","/trabajos",
     };
     


    // @Override
    // protected void configure(HttpSecurity http) throws Exception {
    //     http.csrf().disable().authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll()
    //             .antMatchers("/authenticate")
    //             .permitAll().anyRequest().authenticated()
                
               
    //             .and().exceptionHandling().and().sessionManagement()
    //             .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    //     http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);;
    // }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // http.cors().disable();
        http.cors();
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/authenticate")
        .permitAll().antMatchers(HttpMethod.OPTIONS , "/**");
        http.authorizeRequests().antMatchers("/trabajos")
        .permitAll()
        .antMatchers("/skills")
        .permitAll()
        // .antMatchers("/trabajos/acciones/**").hasAnyRole("ADMIN")
        .antMatchers("/trabajos/acciones/**").permitAll()
        .antMatchers("/skills/acciones/**").permitAll();
        http.authorizeRequests().antMatchers("/usuarios")
        .permitAll()
        .antMatchers("/usuarios/acciones/**").permitAll();
        http.authorizeRequests().antMatchers("/educacion")
        .permitAll()
        .antMatchers("/educacion/acciones/**").permitAll();
        http.authorizeRequests().antMatchers("/proyectos")
        .permitAll()
        .antMatchers("/proyectos/acciones/**").permitAll()
        
        
       
      
        
        .anyRequest()
        .authenticated()
        .and().httpBasic();

        // http.authorizeRequests().antMatchers("/trabajos/acciones/**").hasAnyRole("ADMIN").anyRequest().fullyAuthenticated().and()
        // .httpBasic();
        // http.authorizeRequests() .antMatchers("/authenticate").permitAll().anyRequest().authenticated();
		// http.authorizeRequests() .antMatchers("/trabajos").permitAll().anyRequest().authenticated();
		
        
     ;
                
               
                // .and().exceptionHandling().and().sessionManagement()
                http.exceptionHandling().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);;
    }

    
}
