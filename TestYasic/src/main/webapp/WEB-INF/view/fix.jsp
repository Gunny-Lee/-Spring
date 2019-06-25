<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type='text/css'>
@import url("fix.css");
</style>
<link rel="stylesheet" href="css/fix.css">
<link rel="stylesheet" href="css/button.css">
<script>
	function tclose() {
		console.log("close");
		self.close();
	}
</script>

</head>
<body>

	<h2>회원정보수정</h2>
	<!-- modify Form  -->
	<form name="f" method="post" action="${pageContext.request.contextPath}/fix.do" enctype="multipart/form-data">
		<table border="0" cellpadding="0" cellspacing="1" width="350"
			bgcolor="BBBBBB">
			<tr>
				<td>휴대폰번호</td>
				<td><input type="text" name="id" value="${user.id}" readonly>
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value="${user.name}">
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type="radio" name="sex" checked="checked" value="m">남
					<input type="radio" name="sex" value="w">여 
					<input type="radio" name="sex" value="e">기타
				</td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="number" min="1900" max="2100" name="age" value="${user.age}"></td>
			</tr>
			<tr>
				<td>프로필</td>
				<td><input type="file" name="file"></td>
			</tr>

		</table>
		<br>

		<table width=300 border=0 cellpadding=0 cellspacing=0>
			<tr>
				<td id="last" align=center>
					<input type="submit" value="수정" class="button"> &nbsp; 
					<input type="button" value="취소" onclick="tclose()" class="button">
				</td>
			</tr>
		</table>
	</form>




</body>
</html>