<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
        + request.getServerName() + ":"
        + request.getServerPort() + path + "/";
    
    if (session.getAttribute("utype") == null) {
        session.setAttribute("utype", "anonymous");
        response.sendRedirect("anonymous");
    } else if(session.getAttribute("utype") != "user"){
        switch (request.getSession().getAttribute("utype").toString()) {
            case "anonymous": {
                response.sendRedirect("anonymous");
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
        <title>NPS 首页</title>
        
        
        
        <!--进度条-->
        <link href="lib/nprogress.css" rel="stylesheet" type="text/css"/>
        <script src="lib/nprogress.js" type="text/javascript"></script><script>NProgress.start();</script>
        
        <!-- css -->
        <link href="<%=path%>/lib/base.min.css" rel="stylesheet" />
        <link href="<%=path%>/lib/project.min.css" rel="stylesheet" />
        <link href="<%=path%>/lib/jquery.fs.boxer.css" rel="stylesheet" />
        <link href="<%=path%>/css/app.css" rel="stylesheet" />
        
        <style> 
            .ubox{
                display:none;
            }
            .ubox.active{
                display:block;
            }
        </style>
        <script src="<%=path%>/lib/jquery.min.js"></script>
        
    </head>
    <%
        String utype = session.getAttribute("utype").toString();
        if(utype != "anonymous"){
            
        }
    %>
    <body class="page-default" id='lms-main'>
        
        <!--header-->
        <header class="header header-brand header-waterfall ui-header">

            <ul class="nav nav-list pull-left">
                <li>
                    <a href="<%=path%>/">
                        <span class="icon icon-lg">home</span>
                    </a>
                </li>
            </ul>
            
            <span class="header-logo" >NPS系统 | <span id="header-location">主页</span></span>
            
            <ul class="nav nav-list pull-right" id="uheader">

                <!--                
                <li class="nav-item">
                    <a href="#"><span class="nav-item-text">登录</span><span class="icon icon-lg nav-item-icon">input</span></a>
                </li>
                -->
                
                <li class="dropdown">
                    <a class="dropdown-toggle padding-left-no padding-right-no" data-toggle="dropdown" >
                        <span class="access-hide">Avatar</span>
                        <span class="avatar avatar-sm"><span class="icon mg-sm-right" id="uavatar-small">account_circle</span></span>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-right">
                        <li class="">
                            <a class="waves-attach waves-effect" href="javascript:void(0)">
                                <span class="icon mg-sm-right">person</span> 个人信息
                            </a>
                        </li>
                        <li class="divider-b"></li>
                        <li class="">
                            <a class="waves-attach waves-effect" href="javascript:void(0)">
                                <span class="icon mg-sm-right">settings</span> 设置
                            </a>
                        </li>
                        <li class="divider-b"></li>
                        <li class="">
                            <a class="waves-attach waves-effect" href="javascript:void(0)" onclick="signOut()">
                                <span class="icon mg-sm-right">exit_to_app</span> 退出
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>                  
        </header>
        
        <!--App Main Content-->                
        <div id="app-content" class="container">
            <nav class="fbtn-container" id="app-nav-ubtn">
                

                <div class="fbtn-inner">
                    <a class="fbtn btn-grey waves-attach waves-circle waves-light" data-toggle="tab" href="#panel-Index">
                        <span class="fbtn-text fbtn-text-left">个人面板</span><span class="icon">keyboard_return</span>
                    </a>
                </div>

                <div class="fbtn-inner">
                    <a class="fbtn btn-aqua waves-attach waves-circle waves-light waves-effect"  data-toggle="tab" href="#panel-manageTable">
                        <span class="fbtn-ori icon">view_list</span><span class="fbtn-text fbtn-text-left">表格管理</span>
                    </a>
                </div>

                <div class="fbtn-inner">
                    <a class="fbtn fbtn-trans waves-attach waves-circle waves-light waves-effect"  data-toggle="tab" href="#panel-manageFriend">
                        <span class="fbtn-ori icon">people</span><span class="fbtn-text fbtn-text-left">好友管理</span>
                    </a>
                </div>

                <div class="fbtn-inner">
                    <a class="fbtn fbtn-trans waves-attach waves-circle waves-light waves-effect"  data-toggle="tab" href="#panel-manageInbox">
                        <span class="fbtn-ori icon">inbox</span><span class="fbtn-text fbtn-text-left">消息管理</span>
                    </a>
                </div>

                <div class="fbtn-inner">
                    <a class="fbtn fbtn-trans waves-attach waves-circle waves-light" data-toggle="dropdown">
                        <span class="fbtn-ori icon">more_vert</span><span class="fbtn-sub icon">close</span>
                    </a>
                    <div class=" fbtn-dropdown">
                        <a class="fbtn waves-attach waves-circle waves-light" href="javascript:void(0)">
                            <span class="fbtn-text fbtn-text-left">反馈</span><span class="icon">bug_report</span>
                        </a>
                        <a class="fbtn waves-attach waves-circle" href="javascript:void(0)" >
                            <span class="fbtn-text fbtn-text-left">关于系统</span><span class="icon">info</span>
                        </a>
                    </div>
                </div>

            </nav>
            <div class="row tab-content">
                
                <div id="panel-Index" class="tab-pane fade in active">
                    <div class="bg-content z-index-bg"></div>
                    <!-- 个人面板 -->
                    <div class="col-md-12"> 
                        <div class="card">

                            <div class="card-main">
                                <div class="card-inner">
                                    <div class="card-heading">这就是我</div>
                                    <div id="itisme">
                                        <a  href="javascript:void(0)" class='fbtn btn-golden'>
                                            U<span class="fbtn-text fbtn-text-left">Sample Tips</span>
                                        </a>
                                        <div class="fbtn btn-alizarin">13</div>
                                        <div class="fbtn btn-alizarin">12</div>
                                        <div class="fbtn btn-alizarin">13</div>
                                        <div class="fbtn btn-alizarin">13</div>
                                    </div>
                                </div>
                                <div class="card-action">
                                    <div class="card-action-btn" style="margin:6px 16px;">
                                        <a href="dean/pinfo" class="btn btn-flat lms-c-text-light stage-card waves-attach pull-right" style="text-align: right;"> 查看 / 修改 个人信息<span class="icon margin-left-sm">open_in_new</span> </a>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                    <div class="col-md-12"> 
                        <div class="card">
                            
                            <div class="card-main">
                                <div class="card-inner">
                                    <div class="card-heading">Sample Title</div>
                                    <div class="sample-height">

                                        <ul class="">
                                            <li><a id="ajax-test">TEST</a></li>
                                            <p id="test"></p>
                                        </ul>
                                        
                                    </div>
                                </div>
                                <div class="card-action">
                                    <div class="card-action-btn" style="margin:6px 16px;">
                                        <a href="dean/pinfo" class="btn btn-flat lms-c-text-light stage-card waves-attach pull-right" style="text-align: right;"> 查看 / 修改 个人信息<span class="icon margin-left-sm">open_in_new</span> </a>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                                            
                    <!-- 个人面板 END-->                
                    
                </div>

                <div id="panel-manageTable" class="tab-pane fade">
                    <jsp:include page="IncludeTable.jsp"/>
                </div>
                
                <div id="panel-manageFriend" class="tab-pane fade">
                    <jsp:include page="IncludeFriend.jsp"/>
                </div>
                
                <div id="panel-manageInbox" class="tab-pane fade">
                    <jsp:include page="IncludeInbox.jsp"/>
                </div>
                
            </div>


            <!--用户功能集 START-->
            <jsp:include page="/WEB-INF/jsp/u/IncludeInbox.jsp"/>
            <!--用户功能集 END-->
        </div>


        <!--ubtn-->
        <div class="fbtn-container" id="app-ubtn">

            <div class="fbtn-inner" id="msgBox">
                <a class="fbtn fbtn-red waves-attach waves-circle waves-light" href="javascript:void(0)">
                    <span class="fbtn-text fbtn-text-left">消息盒子</span><span class="icon">message</span>
                </a>
            </div>

            <div class="fbtn-inner" id="postNew">
                <a class="fbtn btn-gold waves-attach waves-circle waves-light waves-effect" >
                    <span class="fbtn-ori icon">add</span><span class="fbtn-text fbtn-text-left">创建新表</span>
                </a>
            </div>

            <div class="fbtn-inner" id="scrollUp">
                <a class="fbtn fbtn-trans waves-attach waves-circle waves-light waves-effect" >
                    <span class="fbtn-ori icon">keyboard_arrow_up</span><span class="fbtn-text fbtn-text-left">返回顶部</span>
                </a>
            </div>

        </div>

        <!--单向信息传递 snackbar-->
        <div id="snackbar" class="z-index-covermsg"></div>

        <!--退出框 modal-->
        <div class="modal fade z-index-covermsg" id="modal" role="dialog" >
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
            
        <!--footer-->
        <footer class="ui-footer" id="tree-footer">
            <div class="container">
                <p >
                    <strong>Copyright © 2016 软工一班  llgt · 【 NPS System 】</strong>
                </p>
            </div>
        </footer>
        
        <!-- js -->
        <script src="<%=path%>/lib/base.min.js" type="text/javascript"></script>
        <script src="<%=path%>/lib/project.min.js" type="text/javascript"></script>
        <script src="<%=path%>/lib/jquery.fs.core.js" type="text/javascript"></script>
        <script src="<%=path%>/lib/transition.js" type="text/javascript"></script>
        <script src="<%=path%>/lib/jquery.fs.boxer.min.js" type="text/javascript"></script>
        <script src="<%=path%>/lib/jquery.scrollUp.min.js" type="text/javascript"></script>
        <script src="<%=path%>/js/api.common.js" type="text/javascript"></script>
        <script>NProgress.done();</script>
        <script>
             //返回顶部 插件 scrollUp 配置
             $(function () {
		            $.scrollUp({
		                scrollName: 'scrollUp',      // Element ID
		                scrollDistance: 0,         // Distance from top/bottom before showing element (px)
		                scrollFrom: 'top',           // 'top' or 'bottom'
		                scrollSpeed: 300,            // Speed back to top (ms)
		                easingType: 'linear',        // Scroll to top easing (see http://easings.net/)
		                animation: 'fade',           // Fade, slide, none
		                animationSpeed: 200,         // Animation speed (ms)
		                scrollTrigger: false,        // Set a custom triggering element. Can be an HTML string or jQuery object
		                scrollTarget: false,         // Set a custom target element for scrolling to. Can be element or number
		                scrollText: '',                  // Text for element, can contain HTML
		                scrollTitle: false,           // Set a custom <a> title if required.
		                scrollImg: false,            // Set true to use image
		                activeOverlay: false,    // Set CSS color to display scrollUp active point, e.g '#00FFFF'
		                zIndex: 2000                 // Z-Index for the overlay
		                            
                    }); 
                });
             $('#ajax-test').click(function(){
                 
                $.ajax({
                   url: "<%=path%>/app?target=text",
                   type: 'get',
                   async: false,
                   success: function (data) {
                       console.log(data);
                       $('#test').html(data);
                       status = 0;
                   },
                   error: function () {
                       status = -1;
                   }
               });
               
             });
        </script>

        <script>
            function signOut(){
                $.ajax({
                   url: "<%=path%>/app?target=signOut",
                   type: 'post',
                   async: false,
                   success: function (data) {
                        if (data === "ok") {
                            api.msg.alert("正在退出...");
                            $("#pw").val("");
                        }else{
                            api.msg.snackbar("未知错误!请尝试刷新页面...");
                        }
                   },
                   error: function () {
                       api.msg.snackbar("未知错误!请尝试关闭浏览器...");
                       status = -1;
                   }
               });
               window.top.location = "<%=path%>/";
            }
        </script>
    </body>  
</html>