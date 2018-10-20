<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to MyStud</title>
</head>
<body bgcolor="gray">
<h1 align="center">
<% 
out.print("Welcome "+session.getAttribute("uname"));
%></h1>

<menu>
<!-- <form action="./Profile" method="post"> -->
<button type="submit"><a href="profile.jsp">Profile</a><!-- </button> --></form>&nbsp; &nbsp;
<form action="./SearchCand" method="post"><button type="submit">SearchCandidate</button></form>
<a href="logout.jsp">logout</a>
</menu>


</body>
</html>