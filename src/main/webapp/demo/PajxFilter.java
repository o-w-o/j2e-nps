/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henu.util;

import java.io.IOException;
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
public class PajxFilter implements javax.servlet.Filter{
     protected Boolean isPjax = true;

    @Override
    public void init(FilterConfig config) throws ServletException {
         
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

         

    }

    @Override
    public void destroy() {}
}
