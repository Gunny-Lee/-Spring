<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type='text/css'>
@import url("fadd.css");
</style>
<link rel="stylesheet" href="css/fadd.css">
</head>
<body>

	<h3 style="color:red">${msg}</h3>
	<form action="${pageContext.request.contextPath}/reqFriend.do" method="post">
		<input type='text' class='text' name="fid" />
		<button type='submit' class='submit'>추가</button>
	</form>



</body>
</html>