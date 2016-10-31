/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nps.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

@WebFilter(
    urlPatterns = {"/*"},
    initParams = {
        @WebInitParam(name = "encoding", value = "utf-8")
    }
)

/**
 *
 * @author dot
 */
public class CharacterEncodingFilter implements Filter {

    protected String encoding;

    @Override
    public void init(FilterConfig config) throws ServletException {
        this.encoding = config.getInitParameter(encoding);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (encoding != null) {
            request.setCharacterEncoding(encoding);
        }
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {}
}
