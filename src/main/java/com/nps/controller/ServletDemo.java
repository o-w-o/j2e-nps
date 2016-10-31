package com.nps.controller;

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
        "/servlet"
    },
    initParams = {
        @WebInitParam(name = "mainPage", value = "NPS主页")
    }
)


/**
 * 
 * @author dot
 */
public class ServletDemo extends HttpServlet{
    
    private static final long serialVersionUID = 1L;
    
    private ServletConfig config = null;
    
    /**
     * @see HttpServlet #HttpServlet()
     */
    public ServletDemo(){
        super();
    }
    
    /**
     * 重写init()方法,用于初始化config对象
     * @throws javax.servlet.ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException{
        super.init();
        this.config = config;
    }
    
    /**
     * 重写HttpServlet的service方法
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    @Override
    protected void service (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        super.service(req, resp);
        resp.getWriter().println("service() 执行!<br>");
    }
    
    /**
     * doGet() 方法用于处理客户端GET方式的HTTP请求
     * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse resp)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //修改HTTP相应报文的文字符编码和MIME类型, 主要用于解决文字乱码问题
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        
        //创建out内置对象
        PrintWriter out = resp.getWriter();
        out.print("doGet() 方法执行 :处理GET方式请求.<br>");
        
        //使用ServletConfig对象config 获取初始化参数
        String mainPage = config.getInitParameter("mainPage");
        
        //将字符串输出到HTML页面
        out.print(mainPage + "<br>");
    }
    
    /**
     * doPost() 方法用于处理客户端POST方式的HTTP请求
     * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse resp)
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        //调用goGet()方法
        resp.getWriter().print("doPost()方法执行: 处理POST请求");
        doGet(req, resp);
    }
}
