<%@ page import="com.kanmeizi.util.BasePathUtil" %>
<%--
  Created by IntelliJ IDEA.
  User: liuzhengyang
  Date: 2014/11/26
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<%
  String basePath = BasePathUtil.getBasePath(request);
%>
<head>
    <title>admin</title>
    <base href="<%=basePath%>">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/flat-ui.css" rel="stylesheet">
    <link href="css/bulletin.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-3">
            <span class="sr-only">Toggle navigation</span>
        </button>
        <a class="navbar-brand" href="admin/photoList">控制台</a>
    </div>



    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="navbar-collapse-3">
        <ul class="nav navbar-nav">
            <li><a href="#">Messages<span class="navbar-unread">1</span></a></li>
            <li class="active"><a href="#">About Us</a></li>
            <li><a href="#">Clients</a></li>
        </ul>
        <form class="navbar-form navbar-left" action="#" role="search">
            <div class="form-group">
                <div class="input-group">
                    <input class="form-control" id="navbarInput-01" type="search" placeholder="Search">
                <span class="input-group-btn">
                  <button type="submit" class="btn"><span class="fui-search"></span></button>
                </span>
                </div>
            </div>
        </form>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">MonsterCritic <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="#">Action</a></li>
                    <li><a href="#">Another action</a></li>
                    <li><a href="#">Something else here</a></li>
                    <li class="divider"></li>
                    <li><a href="#">Separated link</a></li>
                </ul>
            </li>
            <li><a href="#"><span class="visible-sm visible-xs">Settings<span class="fui-gear"></span></span><span class="visible-md visible-lg"><span class="fui-gear"></span></span></a></li>
        </ul>
    </div><!-- /.navbar-collapse -->
</nav>
<div id="mainContenxt">
    <div id="photoContainer">
        <c:forEach items="${photos}" var="photo">
            <div id="photoDiv">
                <p>${photo.title}</p>
                <p><fmt:formatDate value="${photo.postDate}" pattern="yyyy年MM月dd日 HH:mm:ss"/> </p>
                <div id="imageDiv">
                    <img src="${photo.src}"/>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<script src="js/jquery-1.11.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-table.min.js"></script>

<%--Bulletin--%>
<div id="bulletin" class="bulletin">
    <ul>
        <li style="top: 0px;"><a href="http://liuzhengyang.github.io">My Repositories - Show my repositories list.</a></li>
        <li style="top: -23px;"><a href="http://liuzhengyang.github.io">Multiple Select - Multiple select is a jQuery plugin to select multiple elements with checkboxes.</a></li>
        <li style="top: -23px;"><a href="http://liuzhengyang.github.io">Bootstrap Show Password - Show/hide password plugin for bootstrap.</a></li>
        <li style="top: -23px;"><a href="http://liuzhengyang.github.io">Bulletin - A jQuery plugin to show bulletin for website.</a></li>
    </ul>
    <div class="close"><a href="javascript:void(0)">×</a></div>
</div>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="js/jquery-1.11.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.bulletin.js"></script>
<script src="js/index/index.js"></script>
</body>
</html>
