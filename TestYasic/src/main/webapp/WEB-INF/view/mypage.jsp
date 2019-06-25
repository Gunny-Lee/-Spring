<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type='text/css'>
@import url("page.css");
</style>
<link rel="stylesheet" href="css/page.css">
<link rel="stylesheet" href="css/button.css">
</head>
<body>
	<h3>${login.name}의 페이지 입니다.</h3>
	<div>
		<span id="editinfo">
			<a href="${pageContext.request.contextPath}/fix.do" class="button"> 정보수정</a> 
		</span> 
		<img id="img" src="${pageContext.request.contextPath}/upload/${login.img}" width=350 height=275 /> 
	</div>
	<a class="name">${login.name}</a>
	<a class="hashtag">${mycheck.why}</a>
	<a class="age">${login.age}</a>
	<a class="sex">${login.sex}</a>
	<p class="message">${mycheck.msg}</p>
</body>
</html>