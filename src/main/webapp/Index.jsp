<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
        + request.getServerName() + ":"
        + request.getServerPort() + path + "/";
    
    if (session.getAttribute("utype") == null) {
        session.setAttribute("utype", "anonymous");
        response.sendRedirect("anonymous");
    } else {
        switch (request.getSession().getAttribute("utype").toString()) {
            case "anonymous":{
                response.sendRedirect("anonymous");
                break;
            }
            case "user": {
                response.sendRedirect("u");
                break;
            }
            case "admin": {
                response.sendRedirect("admin");
                break;
            }
        };
    };
%>
<!DOCTYPE html>
<html lang="zh-cn">
    <head>
        <meta charset="UTF-8">
        <meta content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no, width=device-width" name="viewport">
    </head>
    <body></body>
</html>
