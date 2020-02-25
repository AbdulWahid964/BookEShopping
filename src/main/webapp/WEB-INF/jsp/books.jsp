<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.formError {
	color: red;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book Details</title>
</head>
<body>
	<center>
		<h1>Books details Form</h1>

		<form:form action="/saveBooks" method="post" modelAttribute="books">
			<table>
				<tr>
					<td><form:input path="bookID" type="hidden" /></td>
				</tr>
				<tr>
					<td>Book Name</td>
					<td><form:input path="bookName" cssClass="formInput"
							placeholder="Enter Book Name" /></td>
					<td><form:errors path="bookName" cssClass="formError" /></td>
				</tr>
				<tr>
					<td>Author Name:</td>
					<td><form:input path="authorName" cssClass="formInput"
							placeholder="Enter Author Name" /></td>
					<td><form:errors path="authorName" cssClass="formError" /></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><form:input path="price" cssClass="formInput"
							placeholder="Enter Price" /></td>
				</tr>
				<tr>
					<td>Quantity</td>
					<td><form:input path="quantity" cssClass="formInput"
							placeholder="Enter Quantity" /></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><form:input path="description" cssClass="formInput"
							placeholder="Enter Description" /></td>
				</tr>
				<tr>
					<td colspan="2"><c:if test="${!empty books.bookName}">
							<input type="submit" value="EditBook" />
						</c:if> <c:if test="${empty books.bookName}">
							<input type="submit" value="AddBook" />
						</c:if></td>
					<td><input type=button value="Back" onCLick="history.back()">
					</td>
				</tr>
				<!-- <a href="/login">Login</a> -->
			</table>
		</form:form>
	</center>
</body>
</html>