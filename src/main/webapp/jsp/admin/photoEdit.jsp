<!DOCTYPE html>
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
<html >
<%
  String basePath = BasePathUtil.getBasePath(request);
%>
<head>
  <title>admin</title>
  <base href="<%=basePath%>">
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="icon" href="../../favicon.ico">

  <title>Dashboard Template for Bootstrap</title>

  <!-- Bootstrap core CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/dashboard.css" rel="stylesheet">
  <link href="css/admin/dash.css" rel="stylesheet">
  <link href="css/bulletin.css" rel="stylesheet">



</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="admin/photoList">控制台</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">控制台</a></li>
        <li><a href="#">设置</a></li>
        <li><a href="#">信息</a></li>
        <li><a href="#">帮助</a></li>
      </ul>
      <form class="navbar-form navbar-right">
        <input type="text" class="form-control" placeholder="Search...">
      </form>
    </div>
  </div>
</nav>

<div class="container-fluid">
  <div class="row">
    <div class="col-sm-3 col-md-2 sidebar">
      <ul class="nav nav-sidebar">
        <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Reports</a></li>
        <li><a href="#">Analytics</a></li>
        <li><a href="#">Export</a></li>
      </ul>
      <ul class="nav nav-sidebar">
        <li><a href="">Nav item</a></li>
        <li><a href="">Nav item again</a></li>
        <li><a href="">One more nav</a></li>
        <li><a href="">Another nav item</a></li>
        <li><a href="">More navigation</a></li>
      </ul>
      <ul class="nav nav-sidebar">
        <li><a href="">Nav item again</a></li>
        <li><a href="">One more nav</a></li>
        <li><a href="">Another nav item</a></li>
      </ul>
    </div>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


      <h2 class="sub-header">Section title</h2>
      <div class="table-responsive">
        <form action="admin/update" method="post">
          <table>
            <input type="hidden" name="id" value="${photo.id}"/>
            <tr>
              <td>postDate</td>
              <td><input type="text" name="postDate" value="<fmt:formatDate value="${photo.postDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"/> </td>
            </tr>
            <tr>
              <td>Title</td>
              <td><input type="text" name="title" value="${photo.title}"/></td>
            </tr>
            <tr>
              <td>Src</td>
              <td><input type="text" name="src" value="${photo.src}"/></td>
            </tr>
            <div id="preview">
              <img src="${photo.src}"/>
            </div>
            <tr>
              <td><input type="submit" value="保存"/></td>
            </tr>

          </table>
        </form>
      </div>
    </div>
  </div>
</div>
<%--Bulletin--%>
<div id="bulletin" class="bulletin">
  <ul>
    <li style="top: 0px;"><a href="http://repos.wenzhixin.net.cn/">My Repositories - Show my repositories list.</a></li>
    <li style="top: -23px;"><a href="http://wenzhixin.net.cn/p/multiple-select/">Multiple Select - Multiple select is a jQuery plugin to select multiple elements with checkboxes.</a></li>
    <li style="top: -23px;"><a href="https://github.com/wenzhixin/bootstrap-show-password">Bootstrap Show Password - Show/hide password plugin for bootstrap.</a></li>
    <li style="top: -23px;"><a href="http://wenzhixin.net.cn/p/bulletin/">Bulletin - A jQuery plugin to show bulletin for website.</a></li>
  </ul>
  <div class="close"><a href="javascript:void(0)">×</a></div>
</div>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="js/jquery-1.11.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.bulletin.js"></script>
<script src="js/admin/photoList.js"></script>
</body>
</html>