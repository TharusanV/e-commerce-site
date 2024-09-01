package com.ecommerce.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ecommerce.backend.security.JWTAuthenticationFilter;
import com.ecommerce.backend.security.LoginFilter;

import static org.springframework.security.config.Customizer.withDefaults;


import java.util.Arrays;

@Configuration
//@EnableWebSecurity - Remove the comment if you want debug testing
public class SecurityConfiguration {
	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF
            .cors().and() // Enable CORS
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // No session creation
            .and()
            .authorizeRequests()
            .anyRequest().permitAll(); // Allow all requests without restrictions

        return http.build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173") // Allow CORS from frontend
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Allow all HTTP methods
                        .allowedHeaders("*"); // Allow all headers
            }
        };
    }
	
	/*
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(userDetailsService)
	    .passwordEncoder(new BCryptPasswordEncoder());
	}
	
	
	@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http
			.csrf(csrf -> csrf.disable()) //#1
			.cors() //#2
			.and() //Chained the two requests with this 'and'
			.sessionManagement() //4
	        .sessionCreationPolicy(SessionCreationPolicy.STATELESS); //5
		
		http
		.authorizeRequests() //6
		.antMatchers(HttpMethod.POST, "/user") //7
	    .permitAll() //7
	    .and()
	    .authorizeRequests() 
		.anyRequest().authenticated() //8
		.and()
		.addFilterBefore(new LoginFilter("/login", authenticationManager(http.getSharedObject(AuthenticationConfiguration.class))),
				UsernamePasswordAuthenticationFilter.class) //9
		.addFilterBefore(new JWTAuthenticationFilter(), 
				UsernamePasswordAuthenticationFilter.class); //10
		

		return http.build();
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() { //#3
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
				.allowedOrigins("http://localhost:5173");
			}
		};
	}
	
	*/

	/*
	//If you want to configure an InMemory User for testing
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User
				.withUsername("user")
				.password(passwordEncoder().encode("password"))
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
	  return new BCryptPasswordEncoder();
	} 
	*/
	
	
	
	
	
	
	
	
	
	
}


/*
@Configuration: This annotation tells Spring that the class defines beans that will be managed 
by the Spring container. It essentially marks the class as a configuration file for Spring's dependency injection. 

@Autowired: Spring's way of injecting dependencies automatically.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------
#1 When enabled it shuts down the web app to post requests and it expects a CSRF token accompanied by post requests
We already have the JSON web token, which is unique. So we disable it as we are using JSON web tokens

#2 Enabled CORS, which is allowing us to say what cross-origins we are going to be accepting in our web application.
Typically, browsers don't like different domains to make requests to each other. So with this, we can configure what domains can make requests to the backend.
And when we configure this, then when the browser asks if this is okay to the backend, the backend will respond, saying that that it would be acceptable and then the request can succeed.
We need this because our frontend is running in localhost:3000 and our backend application is running on localhost:8080. So for that requests from local host 3000 to succeed at local host 8080, we would have to have a configuration for this.

#3 And that configuration is in a separate bean. And here I say, add this mapping to anything that my back-end serves with 
slash star star says that includes subfolders sub-paths as well from this origin of Local host 3000. 

#4 Configure next the session management as I'm using JSON web tokens I would like that no cookies are sent and no session is created at the back end. 
#5 So that's why I put a stateless session creation policy. And this is telling to the backend that no cookies should be sent.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------

#6 Next, I would like to tell which endpoints need to be authorised. I say authorise requests for the endpoint user.
#7 if it's a post, if it's posting to that endpoint which corresponds to registering a new user, I would like to permit all. So no checks for this. Anonymous users can register to the back end.
#8 The next rule is any other request should be authenticated.

#9 Then I put an and. Now I say add a filter. This is the where I'm changing the springs security default filter mechanisms a login filter and this will be triggered if the request is coming 
to the login endpoint and it will be using the authentication manager that I just configured and it will replace the username password authentication filter.
#10 for any other endpoint Use the JWT authentication filter to authenticate the user.


*/
