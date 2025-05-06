<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<!--<div class="header"></div>	-->
<!-- Header image -->
<div>
	<img src="${pageContext.request.contextPath}/images/hotel-booking-header.png" alt="Hotel Header" style="width: 50%; height: 30%;">
</div>
<h2>Bookings</h2>
<a href="/bookings/add">Add Booking</a>
<table border="1">
<tr>
    <th>ID</th><th>Room</th><th>Check-In</th><th>Check-Out</th><th>Customer</th><th>Actions</th>
</tr>
<c:forEach var="booking" items="${bookings}">
<tr>
    <td>${booking.id}</td>
    <td>${booking.roomNumber}</td>
    <td>${booking.checkIn}</td>
    <td>${booking.checkOut}</td>
    <td>${booking.customer.name}</td>
    <td>
        <a href="/bookings/edit/${booking.id}">Edit</a> |
        <a href="/bookings/delete/${booking.id}">Delete</a>
    </td>
</tr>
</c:forEach>
</table>
</body></html>
