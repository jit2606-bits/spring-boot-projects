<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Error</title></head>
<body>
    <h2>Error Occurred</h2>
    <div style="color:red;">${error}</div>
    <a href="${pageContext.request.contextPath}/">Return to Home</a>
</body>
</html>