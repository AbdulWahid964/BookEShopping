<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.table {
	font-family: verdana, arial, sans-serif;
	font-size: 13px;
	border-width: 1px;
	border-color: black;
	border-collapse: collapse;
}

.table td {
	border-width: 2px;
	padding: 8px;
	border-style: solid;
	border-color: black;
}

.table th {
	background-color: #c3dde0;
	border-width: 2px;
	padding: 8px;
	border-style: solid;
	border-color: black;
}
</style>
</head>
<body>
	<center>
		<h2>Books Details</h2>
		<br /> <br />
		<table class="table">
			<tr>
				<th width="80">Book-Id</th>
				<th width="80">Book-Name</th>
				<th width="80">Author-Name</th>
				<th width="80">Price</th>
				<th width="80">Quantity</th>
				<th width="80">Description</th>
				<th width="80">Edit</th>
				<th width="80">Delete</th>
			</tr>
			<c:forEach var="listbooks" items="${list}">
				<tr>
					<td>${listbooks.bookID}</td>
					<td>${listbooks.bookName}</td>
					<td>${listbooks.authorName}</td>
					<td>${listbooks.price}</td>
					<td>${listbooks.quantity}</td>
					<td>${listbooks.description}</td>
					<td><a href="<c:url value='/edit/${listbooks.bookID}' />">Edit</a></td>
					<td><a
						href="<c:url value='/remove/${listbooks.bookID}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<br/>
		<a href="${pageContext.request.contextPath}/home"> Back</a>
	</center>
</body>
</html>