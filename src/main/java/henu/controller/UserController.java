/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = {
        "/u"
        
    },
    initParams = {
        @WebInitParam(name = "User Page", value = "user")
    }
)

public class UserController extends HttpServlet{
     private static final long serialVersionUID = 1L;
    
    private ServletConfig config = null;
    private String encoding = "UTF-8";
    
    
    public UserController(){
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init();
        this.config = config;
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/u/Index.jsp").forward(req,resp);
        //resp.getWriter().println("service() 执行!<br>");
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        
        //获取行动对象
        String target = req.getParameter("target");

        if (target != null) {
            switch (target) {
                case "me": {
                    doMeGet(req, resp);
                    break;
                }
                case "table": {
                    doTableGet(req, resp);
                    break;
                }
                case "friend": {
                    doFriendGet(req, resp);
                    break;
                }
                case "msg": {
                    doMsgGet(req, resp);
                    break;
                }
            }
        } else {

            resp.sendRedirect("/WEB-INF/jsp/u/Index.jsp");
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        String target = req.getParameter("target");

        if (target != null) {
            switch (target) {
                case "me": {
                    doMePost(req, resp);
                    break;
                }
                case "table": {
                    doTablePost(req, resp);
                    break;
                }
                case "friend": {
                    doFriendPost(req, resp);
                    break;
                }
                case "msg": {
                    doMsgPost(req, resp);
                    break;
                }
            }
        }
    }

    private void doMeGet(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doMePost(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doTableGet(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doTablePost(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doFriendGet(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doFriendPost(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doMsgGet(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doMsgPost(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
