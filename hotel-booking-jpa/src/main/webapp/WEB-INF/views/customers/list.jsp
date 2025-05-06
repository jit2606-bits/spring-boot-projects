<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<!-- Header image -->
<div>
	<img src="${pageContext.request.contextPath}/images/hotel-booking-header.png" alt="Hotel Header" style="width: 50%; height: 30%;">
</div>
<h2>Customers</h2>
<a href="/customers/add">Add Customer</a>
<table border="1">
<tr><th>ID</th><th>Name</th><th>Email</th><th>Actions</th></tr>
<c:forEach var="customer" items="${customers}">
<tr>
  <td>${customer.id}</td>
  <td>${customer.name}</td>
  <td>${customer.email}</td>
  <td>
    <a href="/customers/edit/${customer.id}">Edit</a> |
    <a href="/customers/delete/${customer.id}">Delete</a>
  </td>
</tr>
</c:forEach>
</table>
</body></html>
