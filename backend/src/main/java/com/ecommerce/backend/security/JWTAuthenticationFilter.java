package com.ecommerce.backend.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class JWTAuthenticationFilter extends GenericFilterBean {
	
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
	Authentication authentication = JWTService.getAuthentication((HttpServletRequest)request);
    
    SecurityContextHolder.getContext().setAuthentication(authentication);
    
    filterChain.doFilter(request, response);
  }
}

/*
The JWTAuthenticationFilter class extends GenericFilterBean and is used to 
- intercept HTTP requests, 
- verify a user's authentication using JWT (JSON Web Token), 
- and pass the authentication information to the Spring Security context. 

Extending GenericFilterBean:
GenericFilterBean is a Spring Security class that provides basic filtering functionality for HTTP requests. By extending this class, JWTAuthenticationFilter becomes a filter that can intercept HTTP requests and responses.

The doFilter method is overridden from GenericFilterBean. It's the core method that handles filtering logic for each HTTP request. Parameters:
	- ServletRequest request: Represents the incoming HTTP request (cast to HttpServletRequest).
	- ServletResponse response: Represents the HTTP response.
	- FilterChain filterChain: Used to continue the request-response flow to the next filter or the resource.
	
3. Authentication with JWT:
JWTService.getAuthentication((HttpServletRequest) request): - This line is responsible for extracting the JWT token from the HTTP request (likely from the headers, like Authorization).
															  It calls JWTService to parse the JWT and validate the token, returning an Authentication object (which holds the user's authentication information, like username, roles, etc.).

4. Setting Authentication in Security Context:
SecurityContextHolder.getContext().setAuthentication(authentication); - The SecurityContextHolder is a Spring Security class that holds the security context for the current request thread.
 																	    This line sets the Authentication object (retrieved from the JWT) into the SecurityContext. Once it's set, the entire request can access the authenticated user's details.

5. Continuing the Filter Chain:
filterChain.doFilter(request, response); - This line ensures the filter chain continues. If authentication is valid, the request proceeds further down the chain to the next filter or resource (like a controller or other filter).
 										   If authentication fails, some exception handling may take place (not shown here).

Summary:
This class is part of the security layer that intercepts incoming HTTP requests, extracts the JWT token, authenticates the user based on that token, and sets the authentication details in the security context. This allows other parts of the application to identify the user and authorize actions based on their authentication.

*/