/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henu.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = {
        "/anonymous"
        
    },
    initParams = {
        @WebInitParam(name = "SignIn Page", value = "signin")
    }
)

public class AnonymousController extends HttpServlet{
     private static final long serialVersionUID = 1L;
    
    private ServletConfig config = null;
    private String encoding = "UTF-8";
    
    
    public AnonymousController(){
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init();
        this.config = config;
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        
        req.getRequestDispatcher("/WEB-INF/jsp/Index.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        
    }
}
