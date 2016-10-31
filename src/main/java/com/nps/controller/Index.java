package com.nps.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = {
        "/index"
    },
    initParams = {
        @WebInitParam(name = "mainPage", value = "NPS主页")
    }
)

/**
 * 
 * @author dot
 */
public class Index extends HttpServlet{
    
    /**
     * @see HttpServlet #HttpServlet()
     */
    public Index(){
        super();
    }
    
    /**
     * 重写HttpServlet的service方法
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    protected void service (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        super.service(req, resp);
        req.getRequestDispatcher("/Index.jsp").forward(req, resp);
        //resp.getWriter().println("service() 执行!<br>");
    }
}
