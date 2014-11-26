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
</head>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div id="container" class="container">
  <form action="<%=basePath%>/admin/save" method="post">
    <table>
      <tr>
        <td>Title</td>
        <td><input type="text" name="title" /></td>
      </tr>
      <tr>
        <td>Src</td>
        <td><input type="text" name="src" /></td>
      </tr>
      <tr>
        <td><input type="submit" value="保存"/></td>
      </tr>

    </table>
  </form>
</div>
</body>
</html>
