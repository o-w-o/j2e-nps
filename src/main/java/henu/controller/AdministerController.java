/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henu.controller;

import henu.dao.bean.User;
import henu.dao.factory.DaoFactory;
import henu.util.StringConvert;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;

@WebServlet(
    urlPatterns = {
        "/admin","/admin/env"
        
    },
    initParams = {
        @WebInitParam(name = "Admin Page", value = "admin")
    }
)

public class AdministerController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    
    private ServletConfig config = null;
    private String encoding = "UTF-8";
    
    
    public AdministerController(){
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init();
        this.config = config;
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        if(!ApplicationController.isAdmin(req, resp)){
            req.getRequestDispatcher("/WEB-INF/jsp/Index.jsp").forward(req, resp);
        }
        //获取行动对象
        String target = req.getParameter("target");

        if (target != null) {
            switch (target) {
                case "getenvinfo": {
                    doEnvInfoGet(req, resp);
                }
                case "getuinfo": {
                    doUserInfoGet(req, resp);
                    break;
                }
                case "getallinfo": {
                    doAllInfoGet(req, resp);
                    break;
                }
                case "2excel": {
                    do2ExcelGet(req, resp);
                    break;
                }
            }
        } else {
            switch (req.getRequestURI().replace("/nps", "")) {
                case "/admin/env": {
                    System.out.println(Arrays.toString(req.getParameterValues("action")));
                    req.getRequestDispatcher("/WEB-INF/jsp/administrator/EnvInfo.jsp").forward(req, resp);
                    break;
                }
                default: {
                    req.getRequestDispatcher("/WEB-INF/jsp/administrator/Index.jsp").forward(req, resp);
                }
            }
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        
        //获取行动对象
        String target = req.getParameter("target");

        if (target != null) {
            switch (target) {
                case "delete": {
                    doUserDeletePost(req, resp);
                    break;
                }
                case "resetpw": {
                    doPasswordResetPost(req, resp);
                    break;
                }
                case "signup": {
                    doUserSignUpPost(req, resp);
                    break;
                }
                case "autoadd": {
                    doUserAppendPost(req, resp);
                    break;
                }
            }
        }else {
            switch (req.getRequestURI().replace("/nps", "")) {
                case "/admin/env": {
                    System.out.println(Arrays.toString(req.getParameterValues("action")));
                    req.getRequestDispatcher("/WEB-INF/jsp/administrator/EnvInfo.jsp").forward(req, resp);
                    break;
                }
                default :{
                    
                }
            }
        }
    }

    private void doUserInfoGet(HttpServletRequest req, HttpServletResponse resp) {
        if (ApplicationController.isAdmin(req, resp)) {
            
        }
    }

    private void doAllInfoGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        //创建out内置对象
        PrintWriter out = resp.getWriter();
        
        List<User> list = DaoFactory.getUserDaoInstance().getAllInfo();
        String json = JSONArray.fromObject(list).toString();
        out.print(StringConvert.UTF2IOS(json));
    }

    private void doPasswordResetPost(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doUserDeletePost(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doUserSignUpPost(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void do2ExcelGet(HttpServletRequest req, HttpServletResponse resp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void doUserAppendPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        //创建out内置对象
        PrintWriter out = resp.getWriter();
        
        for (int i = 10; i < 100; i++) {
            User u = new User();
            
            u.setId("14452020" + i);
            u.setBrithday("12-03月-1994");
            u.setEmail("Unkonwn");
            u.setGender("Unkonwn");
            u.setName("Unamed");
            u.setPassword("123");
            u.setUtype("user");
            u.setUwords("Hello world !");
            DaoFactory.getUserDaoInstance().appendUser(u);
        }
        out.print("done...");
        out.close();
    }

    private void doEnvInfoGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
            req.getRequestDispatcher("/WEB-INF/jsp/administrator/EnvInfo.jsp").forward(req, resp);
    }
}
