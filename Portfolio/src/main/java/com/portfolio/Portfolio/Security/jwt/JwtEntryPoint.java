
package com.portfolio.Portfolio.Security.jwt;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 *
 * @author Lucas Robles
 */

@Component

public class JwtEntryPoint implements AuthenticationEntryPoint{
    private final static Logger logger =LoggerFactory.getLogger(JwtEntryPoint.class);
    
}
