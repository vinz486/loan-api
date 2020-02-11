package com.bigbank.loan.autoconfiguration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;


@Configuration
@EnableWebSecurity
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter
{

    @Value("${http.header.name:Bigbank-Apikey}")
    private String principalRequestHeader;

    @Value("${http.api-key:TOKEN-ABC}")
    private String principalRequestValue;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception
    {
        ApiKeyFilter filter = new ApiKeyFilter(principalRequestHeader);

        filter.setAuthenticationManager(authentication -> {

            String principal = (String) authentication.getPrincipal();

            if (!principalRequestValue.equals(principal))
            {
                throw new BadCredentialsException("The API key was not found.");
            }

            authentication.setAuthenticated(true);

            return authentication;
        });

        httpSecurity.
                antMatcher("/**").
                csrf().disable().
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).
                and().addFilter(filter).authorizeRequests().anyRequest().authenticated();
    }

    public static class ApiKeyFilter extends AbstractPreAuthenticatedProcessingFilter
    {

        private String principalRequestHeader;

        public ApiKeyFilter(String principalRequestHeader)
        {
            this.principalRequestHeader = principalRequestHeader;
        }

        @Override
        protected Object getPreAuthenticatedPrincipal(HttpServletRequest request)
        {
            return request.getHeader(principalRequestHeader);
        }

        @Override
        protected Object getPreAuthenticatedCredentials(HttpServletRequest request)
        {
            return null;
        }
    }
}
