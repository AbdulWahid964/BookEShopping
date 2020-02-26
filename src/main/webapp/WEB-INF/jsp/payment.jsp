<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>
</title>

</head>
<body>
Payment Details
<form action="paymentForm" method="post">
Card Name:<input type="text" name="cardName">
Card Number:<input type="text" name="cardNo">
Expairy Date:<input type="text" name="mm" placeholder ="MM">
<input type="text" name="yy" placeholder ="YY">
<input type="hidden" name="userId" value="11">
<input type="hidden" name="bookId" value="12">
<input type="submit" value="submit">

</form>

</body>
</html>