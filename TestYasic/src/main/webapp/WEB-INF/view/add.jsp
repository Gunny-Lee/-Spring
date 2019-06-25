<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
<title>Insert title here</title>

<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<style>
p { margin:20px 0px; }
</style>

<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script>
	$(function() {
		$('#user_pass').keyup(function() {
			$('font[id=check]').text('');
		}); //#user_pass.keyup

		$('#chpass').keyup(function() {
			if ($('#user_pass').val() != $('#chpass').val()) {
				$('font[id=check]').text('');
				$('font[id=check]').html("비밀번호 불일치");
			} else {
				$('font[id=check]').text('');
				$('font[id=check]').html("비밀번호 일치");
			}
		}); //#chpass.keyup
	});
</script>

</head>
<body class="body">
	







<header style="background-color:white">
    <a class="title" href="${pageContext.request.contextPath}/index.do" class="title">
       <img src="./img/title.png">
    </a> 
</header>   
   	<aside></aside>         
   	<article>
    
   	<div id="wrapper">
    
   	<form action="${pageContext.request.contextPath}/add.do" name="f" method="post" enctype="multipart/form-data" class="login-form">
    
    
    	<div class="header">
			<h1>Register</h1>
			<span>Fill out the form below to register to URI </span>
    	</div>
    
    	<div class="content">
    
    		<input name="id" type="text" class="input username" placeholder="User ID" required="required"/>
      		<div class="user-icon"></div>
      		
      		<input id="user_pass" name="pw" type="password" class="input password" placeholder="Password" required="required"/>
<!--       		<div class="pass-icon"></div>   -->
      		
      		<input id="chpass" type="password" class="input password" placeholder="Password Confirm" required="required"/><br>
      		<font id="check" size="2" color="red"></font>
      		 
    		<input name="name" type="text" class="input password" placeholder="User Name" required="required"/>
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		<div class="container">
			<div class="row">
				<div class="col">
<!-- 					<p><strong>User Sex</strong></p> -->
					<div class="btn-group btn-group-toggle" data-toggle="buttons" style="margin-top: 20px">
						<label class="btn btn-danger">
							<input type="radio" name="sex" id="jb-radio-1" value="m"> 남자
						</label>
						<label class="btn btn-danger">
							<input type="radio" name="sex" id="jb-radio-2" value="w"> 여자
						</label>
						<label class="btn btn-danger">
							<input type="radio" name="sex" id="jb-radio-3" value="e"> 기타
						</label>
					</div>
				</div>
			</div>
		</div>
    		
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    		
    		
    		
    		
    		
    		
    		
    		
      		
    		<input name="number" type="number" min="1900" max="2200" class="input password" placeholder="User Age"  value="2019" required="required"/>
      		
    		<input type="file" name="file" class="input password">
    
		</div>
		
		<div class="footer">
      <input type="submit" name="submit" value="Register" class="button" />
      <a class="register" href="${pageContext.request.contextPath}/login.do">Cancle</a>
      </div>
		
	</form>
	
	</div>
   
<!-- 		<table border="0" cellpadding="0" cellspacing="1" width="590" -->
<!-- 			bgcolor="BBBBBB" align=:"center"> -->
<!-- 			<tr> -->
<!-- 				<td>휴대폰 번호</td> -->
<!-- 				<td> -->
<!-- 					<input type="tel" style="width: 150" name="id">(-)없이 입력해주세요. -->
<!-- 				</td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>비밀번호</td> -->
<!-- 				<td> -->
<!-- 					<input type="password" name="pw" id="user_pass" style="width: 150"> -->
<!-- 				</td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>비밀번호확인</td> -->
<!-- 				<td> -->
<!-- 					<input type="password" name="chpass" id="chpass"style="width: 150">  -->
<!-- 					<font name="check" size="2" color="red"></font> -->
<!-- 				</td> -->
<!-- 			</tr> -->

<!-- 			<tr> -->
<!-- 				<td>이름</td> -->
<!-- 				<td> -->
<!-- 					<input type="text" style="width: 240" name="name"> -->
<!-- 				</td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>성별</td> -->
<!-- 				<td> -->
<!-- 					<input type="radio" name="sex" checked="checked" value="m">남 -->
<!-- 					<input type="radio" name="sex" value="w">여  -->
<!-- 					<input type="radio" name="sex" value="e">기타 -->
<!-- 				</td> -->
<!-- 			</tr> -->

<!-- 			<tr> -->
<!-- 				<td>출생연도</td> -->
<!-- 				<td> -->
<!-- 					<input type="number" min="1900" max="2200" style="width: 240" name="age" value="2019"> -->
<!-- 				</td> -->
<!-- 			</tr> -->

<!-- 			<tr> -->
<!-- 				<td>프로필</td> -->
<!-- 				<td> -->
<!-- 					<input type="file" name="file"> -->
<!-- 				</td> -->
<!-- 			</tr> -->

<!-- 		</table> -->
<!-- 		<br> -->
<!-- 		<table width=590 border=0 cellpadding=0 cellspacing=0> -->
<!-- 			<tr> -->
<!-- 				<td id="last"> -->
<!-- 					<input type="button" value="회원 가입" onClick="userCreate()"> &nbsp;  -->
<!-- 					<input type="button" value="취소" onClick="userList()"> -->
<!-- 				</td> -->
<!-- 			</tr> -->
<!-- 		</table> -->
		
		
		 
    
    


<div class="gradient"></div>   
    
   </article>
    <aside></aside>
    <footer></footer>




















 
</body>
</head>
</html>