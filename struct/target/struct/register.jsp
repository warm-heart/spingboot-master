<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="S" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <base href="<%=basePath%>">
</head>

<body>
<s:form action="register" method="POST">
    <s:textfield name="loginUser.account" label="请输入用户名"/>
    <s:password name="loginUser.password" label="请输入密码"/>
    <s:submit value="注册"/>
    <s:reset value="重置"/>
</s:form>
</body>
</html>