<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% out.println("First Name: "+session.getAttribute("fname"));%><br>
<% out.println("Last Name: "+session.getAttribute("lname"));%><br>
<% out.println("User Type: "+session.getAttribute("type"));%><br>
<% out.println("Mob no:"+session.getAttribute("mob"));%><br>
<% out.println("Email: "+session.getAttribute("email"));%><br>
<% out.println("Experience: "+session.getAttribute("exp"));%><br>
<% out.println("Username: "+session.getAttribute("uname"));%><br>
<% out.println("Password: " +session.getAttribute("pwd"));%><br></br>
</body>
</html>