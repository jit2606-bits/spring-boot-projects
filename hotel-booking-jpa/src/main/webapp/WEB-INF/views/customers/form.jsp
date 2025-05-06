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
<h2>${customer.id == null ? 'Add' : 'Edit'} Customer</h2>
<form action="/customers/save" method="post">
  <input type="hidden" name="id" value="${customer.id}" />
  Name: <input type="text" name="name" value="${customer.name}" /><br/>
  Email: <input type="text" name="email" value="${customer.email}" /><br/>
  <input type="submit" value="Save"/>
</form>
</body>
</html>
