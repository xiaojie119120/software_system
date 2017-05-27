package cn.jiesunshine.software_system.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

public class XssFilter extends OncePerRequestFilter {
	/*private static final Logger LOGGER = LoggerFactory.getLogger(XssFilter.class); */ 
	  
    @Override  
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)  
            throws ServletException, IOException {  
    	XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper((HttpServletRequest) request);  
        chain.doFilter(xssRequest, response);      
    }  

}
