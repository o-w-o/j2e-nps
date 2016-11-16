<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%
    //将项目的根取出来，页面中不再使用相对路径
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
        + request.getServerName() + ":"
        + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8">
        <title>登录</title>
        <link href="<%=path%>/lib/base.min.css" rel="stylesheet" type="text/css" />
        <link href="<%=path%>/lib/project.min.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="<%=path%>/css/app.css" />
        <style>
            html,body{
                height: 100%;
            }
            #login-form-wrap{
                width: 960px;
                margin: auto;
                height: 100%;

                display: flex;
                justify-content: center;
                align-items: center;
                
            }
            #tree-footer{
                background-color: rgba(0,0,0,.3);
            }
        </style>
    </head>

    <body class="stage-image" id="app_login" style="background-image: url(<%=path%>/images/bg.jpg);">
        
        <div class="container-fuild" style="height: inherit;padding: 0;">
            <div class="row" id="login-form-wrap">
                <form id="login-form" class="card col-md-12 form-horizontal" role="form" action="/app?action=login" method="post">

                    <!--ID号-->
                    <div class="form-group form-group-label col-md-5">
                        <div class="row">
                            <div class="col-md-12">
                                <label class="floating-label" for="id">ID号</label>
                                <input type="text" class="form-control" id="id" name="id" placeholder="请输入学生证号/教职工号">
                            </div>
                        </div>
                    </div>

                    <!--密码-->
                    <div class="form-group form-group-label col-md-5">
                        <div class="row">
                            <div class="col-md-12">
                                <label class="floating-label" for="pw">密码</label>
                                <input type="password" class="form-control" id="pw"  name="pw" placeholder="请输入密码">
                            </div>
                        </div>
                    </div>

                    <div class="form-group form-group-label col-md-2">
                        <div type="submit" class="btn-gold btn-card btn-success btn-block" onclick="trySignIn()">登录</div>
                    </div>

                </form>
            </div>
        </div>

        <footer class="ui-footer" id="tree-footer">
            <div class="container">
                <p >
                    <strong>Copyright © 2016 软工一班  llgt · 【 NPS System 】</strong>
                </p>
            </div>
        </footer>
                        
         <!--单向信息传递 snackbar-->
        <div id="snackbar"></div>
        
        <!--退出框 modal-->
        <div class="modal fade" id="modal" role="dialog" >
            <div class="modal-dialog modal-xs">
                <div class="modal-content">
                    <div class="modal-heading">
                        <a class="modal-close" data-dismiss="modal">×</a>
                        <h2 class="modal-title">:-)</h2>
                    </div>
                    <div class="modal-inner">
                        <p class="test-center h5" id="modal-msg">
                            
                        </p>
                    </div>
                    <div class="modal-footer">
                        <p class="text-right"><button class="btn btn-flat btn-brand waves-attach waves-effect" data-dismiss="modal" type="button">关闭</button></p>
                    </div>
                </div>
            </div>
        </div>

        <!--js-->                                    
        <script src="<%=path%>/lib/jquery.min.js"></script>
        <script src="<%=path%>/lib/base.min.js"></script>
        <script src="<%=path%>/lib/project.min.js"></script>
        <script src="<%=path%>/js/api.common.js"></script>

        <script>

            $(document).ready(function () {
                if (top.location !== self.location) {
                    top.location = self.location;
                }
                var treeFrame = $(window).height();
                var treeHeader = $("footer").height();
                var treeBlank = $("#login-form").height();
                var treeContent = treeFrame - treeHeader;
                var treePosition = treeFrame - treeBlank;
            });

            $(window).resize(function () {
                var treeFrame = $(window).height();
                var treeHeader = $("footer").height();
                var treeBlank = $("#login-form").height();
                var treeContent = treeFrame - treeHeader;
                var treePosition = treeFrame - treeBlank;
            });

            function trySignIn() {

                if (isGo()) {
                    $("#loginMsg").html("正在登录...请稍后...");
                    changeRole();
                }

            };
            function signIn(){
                window.location.href="app";
            }
            function changeRole(){
                $.ajax({
                   url: "<%=path%>/signin?email=" +  $("#id").val() + "&password=" + $("#pw").val(),
                   type: 'post',
                   async: false,
                   success: function (data) {
                       if (data === "false") {
                            api.msg.alert("输入的账户错误，请重试...");
                            $("#pw").val("");
                        };
                        if (data === "true") {
                            api.msg.snackbar("登录成功!");
                            signIn();
                        };
                   },
                   error: function () {
                       status = -1;
                   }
               });
            }
            
            function isGo(){
                var id = $("#id"),pw = $("#pw"),msg = "";
                
                if(id.val() === ''){
                    msg = "ID号不能为空...";
                } else if(pw.val() === ''){
                    msg = "密码不能为空...";
                } else {
                    return true;
                }
                
                //api.msg.snackbar(msg);
                api.msg.alert(msg);
                
                return false;
            }
            
            //updateCcdImage();
            
        </script>
    </body>

</html>
