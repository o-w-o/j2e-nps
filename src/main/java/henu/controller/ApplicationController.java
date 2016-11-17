package henu.controller;

import henu.util.CookieEx;
import henu.util.SqlDB;
import henu.util.SessionEx;
import henu.util.StringConvert;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = {
        "/app"
        
    },
    initParams = {
        @WebInitParam(name = "Application", value = "webapp")
    }
)


/**
 * 
 * @author dot
 */
public class ApplicationController extends HttpServlet{
    private static final long serialVersionUID = 1L;
    
    private final String encoding = "UTF-8";
    private static final String ROLE_ANN = "anonymous";
    private static final String ROLE_USR = "user";
    private static final String ROLE_ADMIN = "admin";
    private static String utype = ROLE_ANN;
    
    /**
     * @see HttpServlet #HttpServlet()
     */
    public ApplicationController(){
        super();
    }
    
    /**
     * 重写init()方法,用于初始化config对象
     */
    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init();
    }
    
    /**
     * 重写HttpServlet的service方法
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        //resp.getWriter().println("service() 执行!<br>");
    }
    
    /**
     * doGet() 方法用于处理客户端GET方式的HTTP请求
     * @see HttpServlet#doGet(HttpServletRequest, HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //创建out内置对象
        PrintWriter out = resp.getWriter();
        //获取行动对象
        String target = req.getParameter("target");
        
        if (target != null) {
            switch (target) {
                case "test": {
                    doTestGet(req, resp);
                    break;
                }
            }
        } else {
            
        }
        out.close();
    }
    
    private void doTestGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        //创建out内置对象
        PrintWriter out = resp.getWriter();
        out.print(StringConvert.UTF2IOS("Hi doUserGet() 中文测试 !"));
        out.close();
        
        req.setCharacterEncoding(encoding);
    }
    
    /**
     * doPost() 方法用于处理客户端POST方式的HTTP请求
     * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse resp)
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
       
        String target = req.getParameter("target");
        
        if (target != null) {
            switch (target) {
                case "signIn":{
                    doSignInPost(req,resp);
                    break;
                }
                case "signOut":{
                    doSignOutPost(req, resp);
                    break;
                }
            }
        }
    }
    
    private void doSignInPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uid = req.getParameter("uid");
        String password = req.getParameter("password");

        //创建out内置对象
        PrintWriter out = resp.getWriter();
        
        if (isUserExist(uid)) {
            if (trySignIn(uid, password)) {
                
                if (null != utype) switch (utype) {
                    case "user":
                        SessionEx.setSession(req, "utype", "user");
                        break;
                    case "admin":
                        SessionEx.setSession(req, "utype", "admin");
                        break;
                    default:
                        SessionEx.setSession(req, "utype", "anonymous");
                        break;
                }
                
                SessionEx.setSession(req, "uid", uid);
                CookieEx.setCookie(resp, "uid", uid, 3600);
                out.print("ok");
            }else {
                out.print("false");
            }
        } else {
            out.print("false");
        }
        
        out.close();
    }

    private void doSignOutPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        //创建out内置对象
        PrintWriter out = resp.getWriter();
        
        SessionEx.setSession(req, "utype", "anonymous");
        SessionEx.setSession(req, "uid", "anonymous");
        CookieEx.setCookie(resp, "uid", "anonymous", 3600);
        
        //获取一个cookie相关信息
        Cookie[] cookies = req.getCookies();
        for (Cookie c : cookies) {
            c.getName();
            c.getValue();
        }
        
        out.print("ok");
        
        out.close();
    }


    /**
     * 根据ID与密码 尝试登录 
     * @param uid
     * @param password
     * @return Boolean
     */
    protected boolean trySignIn(String uid, String password){
        
        String sql = "select * from user where uid='" + uid + "'and password='" + password + "'";
        ResultSet resultSet = SqlDB.executeQuery(sql);
        
        try {
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE, null, ex);
        }

        SqlDB.close();

        return false;
    }

    /**
     * 根据用户ID,检查用户名是否存在
     * @param uid
     * @return Boolean
     */
    protected boolean isUserExist(String uid) {
        
        String sql = "select * from user where uid='" + uid + "'";
        ResultSet resultSet = SqlDB.executeQuery(sql);
        
        try {
            if(resultSet.next()){
                System.out.println(resultSet.getInt("UID"));
                setRole(resultSet.getString("UTYPE"));
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE, null, ex);
        }

        SqlDB.close();

        return false;
    }
    
    private void setRole(String role){
        
        switch (role) {
            case "user" :{
                utype=ROLE_USR;
                break;
            }
            case "admin" :{
                utype=ROLE_ADMIN;
                break;
            }
            default:{
                utype=ROLE_ANN;
                break;
            }
        }
        
    }
    
    protected static boolean isUser(HttpServletRequest req, HttpServletResponse resp) {
        return req.getSession().getAttribute("utype") == "user";
    }
    
    protected static  boolean isAdmin(HttpServletRequest req, HttpServletResponse resp) {
        return req.getSession().getAttribute("utype") == "admin";
    }
    
    protected static  boolean isAnonymous(HttpServletRequest req, HttpServletResponse resp) {
        return req.getSession().getAttribute("utype") == "anonymous";
    }
}


