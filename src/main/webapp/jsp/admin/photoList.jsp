<%@ page import="com.kanmeizi.util.BasePathUtil" %>
<%--
  Created by IntelliJ IDEA.
  User: liuzhengyang
  Date: 2014/11/26
  Time: 16:30
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
</head>
<body>
<a href="admin/photoList">返回控制台首页</a>
<a href="admin/new"><button>添加新图片</button></a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>title</th>
        <th>src</th>
        <th>postDate</th>
        <th>操作</th>
    </tr>
  <c:forEach items="${photos}" var="photo" varStatus="status">
    <tr>
      <td>${photo.id}</td>
      <td>${photo.title}</td>
      <td>${photo.src}</td>
      <td>${photo.postDate}</td>
      <td><a href="admin/edit/${photo.id}">修改</a></td>
      <%--<td><fmt:formatDate value="${photo.postDate}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>--%>
    </tr>
  </c:forEach>
</table>
</body>
</html>
