<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>

<style type='text/css'>
@import url("page.css");
</style>
<link rel="stylesheet" href="css/page.css">
<link rel="stylesheet" href="css/button.css">

</head>

<body>
	<h3>${user.name}의 페이지 입니다.</h3>
	<div>
		<img alt="노답" id="img"
			src="${pageContext.request.contextPath}/upload/${user.img}" width=350
			height=275 />
	</div>

	<a class="name">${user.name}</a>
	<a class="hashtag">${check.why}</a>
	<a class="age">${user.age}</a>
	<a class="sex">${user.sex}</a>
	<p class="message">${check.msg}</p>
</body>
</html>