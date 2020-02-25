<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>  
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Home Page</h1>
<c:if test="${role eq '[admin]'}">
<a href="showBooks">Add Books</a>
</c:if>
<br>
<br>
<div>
Welcome Back <sec:authentication property="name"/> 

<sec:authentication property="principal.authorities"/>
<a href="logout">Logout</a></div>

</body>
</html>