package com.ecommerce.backend.security;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginFilter extends AbstractAuthenticationProcessingFilter {

  public LoginFilter(String url, AuthenticationManager authManager) {
    super(new AntPathRequestMatcher(url));
    this.setAuthenticationManager(authManager);
  }

  @Override
  public Authentication attemptAuthentication(
  HttpServletRequest req, HttpServletResponse res)
      throws AuthenticationException, IOException, ServletException {
  AccountCredentials creds = new ObjectMapper()
        .readValue(req.getInputStream(), AccountCredentials.class);
   
  return this.getAuthenticationManager().authenticate(
        new UsernamePasswordAuthenticationToken(
            creds.getUsername(),
            creds.getPassword(),
            Collections.emptyList()
        )
    );
  }

  @Override
  protected void successfulAuthentication(
      HttpServletRequest req,
      HttpServletResponse res, FilterChain chain,
      Authentication auth) throws IOException, ServletException {
    JWTService.addToken(res, auth.getName());
  }
}

/*
The LoginFilter class extends AbstractAuthenticationProcessingFilter and is responsible for handling the authentication process when a user logs in. 
It processes login requests, authenticates the user with their credentials, and generates a JWT token upon successful authentication. 

Constructor:
This constructor is initializing the LoginFilter with a specific login URL (where login requests are intercepted) and an AuthenticationManager.
AntPathRequestMatcher(url): The AntPathRequestMatcher matches incoming requests against the specified URL, so any request to that URL will trigger this filter.
this.setAuthenticationManager(authManager): It sets the AuthenticationManager, which handles the actual authentication process.

attemptAuthentication Method:
Purpose: This method is called when a login request is made. It handles the extraction of user credentials from the request and performs authentication.
Steps:
	Extracting credentials:
		- new ObjectMapper().readValue(req.getInputStream(), AccountCredentials.class):
		- This reads the incoming HTTP request's body (which typically contains JSON) and maps it to the AccountCredentials object, which contains username and password.
	Authenticating the user:
		- The credentials are passed to the AuthenticationManager using a UsernamePasswordAuthenticationToken.
		- UsernamePasswordAuthenticationToken holds the user's username, password, and any additional authorities (in this case, an empty list).
		- The AuthenticationManager performs the actual authentication (e.g., comparing the credentials with a database).

successfulAuthentication Method:
Purpose: This method is triggered after successful authentication of the user.
Steps:
	Generating a JWT token:
		- JWTService.addToken(res, auth.getName()): This method creates and attaches a JWT token to the response. The token is likely based on the authenticated user's name (from auth.getName()).
		- The token is typically added to the response headers, which will be used by the client for subsequent requests.

Summary:
The LoginFilter processes login requests by extracting username and password from the request.
It delegates the authentication to the AuthenticationManager using a UsernamePasswordAuthenticationToken.
Upon successful login, it generates and adds a JWT token to the response, allowing the client to use this token for further authenticated requests. The filter ensures a clean separation of login processing and authentication mechanics.


*/