<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hotel Booking - Home</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<!-- <div class="header"></div> -->
	<!-- Header image -->
	<div>
	   <img src="${pageContext.request.contextPath}/images/hotel-booking-header.png" alt="Hotel Header" style="width: 50%; height: 45%;">
	</div>

    <h1> Welcome to the Hotel Booking System</h1>

    <p>Use the options below to manage your data:</p>

    <ul>
        <li><a href="${pageContext.request.contextPath}/customers"> View & Manage Customers</a></li>
        <li><a href="${pageContext.request.contextPath}/bookings"> View & Manage Bookings</a></li>
    </ul>

    <hr>
    <p style="font-size: 0.9em; color: gray;">Hotel Booking Spring Boot CRUD Application Demo</p>
</body>
</html>
