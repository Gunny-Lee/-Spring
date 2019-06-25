<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
<title>Insert title here</title>
<style type='text/css'>
@import url("add.css");
</style>
<link rel="stylesheet" href="css/add.css">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script>
	$(function() {
		$('#user_pass').keyup(function() {
			$('font[name=check]').text('');
		}); //#user_pass.keyup

		$('#chpass').keyup(function() {
			if ($('#user_pass').val() != $('#chpass').val()) {
				$('font[name=check]').text('');
				$('font[name=check]').html("비밀번호 불일치");
			} else {
				$('font[name=check]').text('');
				$('font[name=check]').html("비밀번호 일치");
			}
		}); //#chpass.keyup
	});

	function userCreate() {
		f.action = "./add.do";
		f.method = "post";
		f.submit();
	}

	function userList() {
		f.action = "./login.do";
		f.method = "get";
		f.submit();
	}
</script>

</head>
<body>
	<form name="f" method="post" enctype="multipart/form-data">
		<table border="0" cellpadding="0" cellspacing="1" width="590"
			bgcolor="BBBBBB" align=:"center">
			<tr>
				<td>휴대폰 번호</td>
				<td><input type="tel" style="width: 150" name="id">
<!-- 					pattern="[0-9]{3}-[0-9]{2}-[0-9]{3}" required -->
<!-- 					pattern="((?=.*[1-9]])(?=.*[1-9])(?=.*[1-9])(?=.*[1-9])(?=.*[1-9]])(?=.*[1-9])(?=.*[1-9])(?=.*[1-9])(?=.*[1-9]])(?=.*[1-9])(?=.*[1-9]).{11})"> -->
					(-)없이 입력해주세요.</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw" id="user_pass"
					style="width: 150"></td>
			</tr>
			<tr>
				<td>비밀번호확인</td>
				<td><input type="password" name="chpass" id="chpass"
					style="width: 150"> <font name="check" size="2" color="red"></font>
				</td>
			</tr>

			<tr>
				<td>이름</td>
				<td><input type="text" style="width: 240" name="name">

				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type="radio" name="sex" checked="checked" value="m">남
					<input type="radio" name="sex" value="w">여 <input
					type="radio" name="sex" value="e">기타</td>
			</tr>

			<tr>
				<td>출생연도</td>
				<td><input type="number" min="1900" max="2200"
					style="width: 240" name="age" value="2019"></td>
			</tr>

			<tr>
				<td>프로필</td>
				<td><input type="file" name="file"></td>
			</tr>

		</table>
		<br>
		<table width=590 border=0 cellpadding=0 cellspacing=0>
			<tr>
				<td id="last"><input type="button" value="회원 가입"
					onClick="userCreate()"> &nbsp; <input type="button"
					value="취소" onClick="userList()"></td>
			</tr>
		</table>
	</form>

	</td>
	</tr>
	</table>
</body>

</head>
<body>

</body>
</html>