<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Successfully Logout</title>
</head>
<body>
<%
session.invalidate();
%>
<h3 style="color:blue; align:center">You have logged out successfully</h3>
<h3 style="color:red; align:center">Click <a href="index.html">here </a> to Login again</h3>
</body>
</html>