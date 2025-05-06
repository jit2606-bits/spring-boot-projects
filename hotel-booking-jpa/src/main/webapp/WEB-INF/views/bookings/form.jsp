<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.time.LocalDate" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<!-- Header image -->
<div>
	<img src="${pageContext.request.contextPath}/images/hotel-booking-header.png" alt="Hotel Header" style="width: 50%; height: 30%;">
</div>
<h2>${booking.id == null ? 'Add' : 'Edit'} Booking</h2>
<form action="/bookings/save" method="post">
    <input type="hidden" name="id" value="${booking.id}" />
    
    Room Number: <input type="text" name="roomNumber" value="${booking.roomNumber}"/><br/>

    Check-In Date: <input type="date" name="checkIn" value="${booking.checkIn}"/><br/>

    Check-Out Date: <input type="date" name="checkOut" value="${booking.checkOut}"/><br/>

    Customer:
    <select name="customer.id">
        <c:forEach var="cust" items="${customers}">
            <option value="${cust.id}" 
                ${booking.customer != null && booking.customer.id == cust.id ? 'selected' : ''}>
                ${cust.name}
            </option>
        </c:forEach>
    </select><br/>

    <input type="submit" value="Save"/>
</form>
</body></html>
