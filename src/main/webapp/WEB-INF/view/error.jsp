<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" isErrorPage="true" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>server error</title>
</head>
<body>
   <%
      response.setStatus(200);
   %>
   <h3>문제 발생</h3>
   <p>${exception}
   <br>
   <p> <%= exception %>
</body>
</html>