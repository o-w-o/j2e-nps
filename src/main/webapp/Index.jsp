<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    //    将项目的根取出来，页面中不再使用相对路径
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
        + request.getServerName() + ":"
        + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
    <head>
        
        <meta charset="UTF-8">
        <meta content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no, width=device-width" name="viewport">
        <title>NPS 首页</title>

        <!-- css -->
        <link href="<%=path%>/lib/base.css" rel="stylesheet" />
        <link href="<%=path%>/lib/project.css" rel="stylesheet" />
        <link href="<%=path%>/lib/jquery.fs.boxer.css" rel="stylesheet" />
        <link href="<%=path%>/css/page.css" rel="stylesheet" />
        <link href="<%=path%>/css/tools.css" rel="stylesheet" />

        <script src="<%=path%>/lib/jquery.min.js"></script>
        
    </head>
    <body class="page-default tab-content" id='lms-main'>

        <header class="header header-brand header-waterfall ui-header">

            <ul class="nav nav-list pull-left">
                <li>
                    <a href="<%=path%>/dean">
                        <span class="icon icon-lg">home</span>
                    </a>
                </li>
            </ul>
            
            <span class="header-logo" >NPS系统 | 主页</span>
            
            <ul class="nav nav-list pull-right">

                <li class="dropdown">
                    <a class="dropdown-toggle padding-left-no padding-right-no" data-toggle="dropdown" >
                        <span class="access-hide">Avatar</span>
                        <span class="avatar avatar-sm"><span class="icon mg-sm-right" id="uavatar-small">account_circle</span></span>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-right">
                        <li class="">
                            <a class="waves-attach waves-effect" href="#">
                                <span class="icon mg-sm-right">account_circle</span> 个人中心
                            </a>
                        </li>
                        <li class="">
                            <a class="waves-attach waves-effect" href="#">
                                <span class="icon mg-sm-right">settings</span> 订阅管理
                            </a>
                        </li>
                        
                        <li class="divider-b"></li>
                        <li class="">
                            <a class="waves-attach waves-effect" href="#">
                                <span class="icon mg-sm-right">exit_to_app</span> 退出
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>                  
        </header>
                                
        <div id="nps-content" class="sample-height">
        
        </div>

        <footer class="ui-footer" id="tree-footer">
            <div class="container">
                <p >
                    <strong>Copyright © 2016 软工一班  llgt · 【 NPS System 】</strong>
                </p>
            </div>
        </footer>

                      <!--返回顶部-->
        <div class="fbtn-container" id="nps-ubtn">

            <div class="fbtn-inner">
                <a class="fbtn btn-gold waves-attach waves-circle waves-light" data-toggle="dropdown"><span class="fbtn-ori icon">apps</span><span class="fbtn-sub icon">close</span></a>
                <div class="fbtn-dropup">
                    <a class="fbtn fbtn-brand waves-attach waves-circle stage-card" href="teacher/pinfo"><span class="fbtn-text fbtn-text-left">我的订阅</span><span class="icon">account_circle</span></a>
                    <a class="fbtn fbtn-red waves-attach waves-circle waves-light" href="<%=path%>/us"><span class="fbtn-text fbtn-text-left">消息中心</span><span class="icon">all_inclusive</span></a>
                    <a class="fbtn fbtn-trans waves-attach waves-circle" href="#" ><span class="fbtn-text fbtn-text-left">加入我们</span><span class="icon">add</span></a>
                </div>
            </div>
            
            <div class="fbtn-inner" id="scrollUp">
                <a class="fbtn fbtn-trans waves-attach waves-circle waves-light waves-effect" ><span class="fbtn-ori icon">keyboard_arrow_up</span><span class="fbtn-text fbtn-text-left">返回顶部</span></a>
            </div>
            
        </div>



        <!-- js -->
        <script src="<%=path%>/lib/base.min.js" type="text/javascript"></script>
        <script src="<%=path%>/lib/project.min.js" type="text/javascript"></script>
        <script src="<%=path%>/lib/jquery.fs.core.js" type="text/javascript"></script>
        <script src="<%=path%>/lib/transition.js" type="text/javascript"></script>
        <script src="<%=path%>/lib/jquery.fs.boxer.min.js" type="text/javascript"></script>
        <script src="<%=path%>/lib/jquery.scrollUp.min.js" type="text/javascript"></script>

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
		                            }); });
        </script>    
    </body>  
</html>