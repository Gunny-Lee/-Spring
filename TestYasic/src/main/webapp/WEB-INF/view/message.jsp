<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type='text/css'>
@import url("message.css");
</style>
<link rel="stylesheet" href="css/message.css">
</head>
<body>
	<h3>${friend.name}에게 메세지 보내기</h3>
	<form action="${pageContext.request.contextPath}/reqMeet.do">
		<div>
			<textarea name="content" cols="40" rows="8" placeholder="30자 제한 입니다."></textarea>
			<input type="hidden" value="${friend.id}" name="fid">
		</div>
		<input type="submit" value="submit">
		<input type="button" onclick="self.close()" value="cancle">
	</form>
</body>
</html>