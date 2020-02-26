
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->


<link href="/css/style.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
   function preventBack()
   {
		   	window.history.forward();
			 setTimeout("preventBack()", 0);
			 window.onunload=function(){null};
	   		
	} 
</script>

</head>
  <body onload="preventBack()"> 
	<div class="wrapper fadeInDown">
		<div id="formContent">

			<div class="fadeIn first">
				<h2>Login Page</h2>
			</div>
			<!-- Tabs Titles -->
			<c:if test="${param.error != null}">
				<div class="fadeIn first">
					<h2>Invalid user name and password</h2>
				</div>
			</c:if>
			<c:if test="${param.logout != null}">
				<div class="fadeIn first">
					<h2>you have been logged out</h2>
				</div>
			</c:if>
			<!-- Login Form -->
			<form:form action="/login" method="POST">
				<input type="text" id="username" class="fadeIn second"
					name="username" placeholder="enter username">
				<input type="text" id="password" class="fadeIn third"
					name="password" placeholder="password">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}">
				<input type="submit" class="fadeIn fourth" value="Log In">
			</form:form>
			<a href="showUserRegistration"> click here to register</a>
		</div>
	</div>
</body>
<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<form:form action="${pageContext.request.contextPath}/authenticateduser" method="POST">

UserName:<input type="text" name="username"/>
<input type="password" name="password"/>
<input type="submit" value="submit"/>

</form:form>


</body>

</html> --%>