<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
 <center>
		<h2>Cart Details</h2>
		<br /> <br />
		<table class="table">
			<tr>
				<th width="80">Book-Name</th>
				<th width="80">Price</th>
				<th width="80">Description</th>
			</tr>
			<c:if test="${cartDetails.size() eq 0}">
			<tr>
					<td colspan=8>No Data to be display</td>
			</c:if>
			<c:forEach var="listCarts" items="${cartDetails}">
				<tr>
					<td>${listCarts.bookName}</td>
					<td>${listCarts.price}</td>
					<td>${listCarts.description}</td>
					
					<td><a
						href="/deletecart/${listCarts.cartID}">Delete</a></td>
				</tr>
			</c:forEach>
			<tr><td><a href="<c:url value='/payment' />">Payment</a></td></tr>
		</table>
		<br/>
		<a href="${pageContext.request.contextPath}/home"> Back</a>
	</center>
<%-- <c:if test="${cartDetails != null}"> --%>
<%-- <h2>Items added in cart</h2>
	<table>
		<tr>
			<th>BookName</th>
			<th>Description</th>
			<th>Price</th>
		</tr>
		<tr>
			<td>${cartDetails.bookName}</td>
			<td>${cartDetails.description}</td>
			<td>${cartDetails.price}</td>
		</tr>
		<tr></tr>
	</table> --%>
	<%-- </c:if>
 --%>

</body>
</html>