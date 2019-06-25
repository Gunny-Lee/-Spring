<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<style type='text/css'>
@import url("index.css");
</style>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/button.css">

<script>
	function target_popup(form) {
		window.open('', 'formpopup',
				'width=400,height=550,resizeable,scrollbars=no');
		form.target = 'formpopup';
	}
	function simple_popup(){
		window.open(this.href, '_blank', 'width=400px,height=550px,toolbars=no,scrollbars=no'); return false;
	}
</script>
</head>
<body>
	<header>
		<a href="${pageContext.request.contextPath}/index.do" class="title">
			<img src="./img/title.png">
		</a> 
		<span class='search_window'>
			<form action="${pageContext.request.contextPath}/search.do" method="get">
				<input type='text' class='text' name="condition" /> 
				<input type="submit" value="검색" class="submit">
			</form>
		</span> 
		<span class='mail_window'>
			<form action="${pageContext.request.contextPath}/mailbox.do" method="get" onsubmit="target_popup(this)">
				<input type="image" src="./img/mail.png" value="mail">
			</form>
			<img class="mailcount_bg" src="./img/mailcount.png">
			<div class="mailcount">
				
				<p class="count">${mailCount}</p>
			</div>
		</span> 
		
		<a href="${pageContext.request.contextPath}/contact.do"
			class="contact"
			onclick="window.open(this.href, '_blank', 'width=400px,height=550px,toolbars=no,scrollbars=no'); return false;">
			<img src="./img/contact.png" width=160 height=80>
		</a> 
		
		<a href="${pageContext.request.contextPath}/mypage.do"
			class="profile"
			onclick="window.open(this.href, '_blank', 'width=400px,height=550px,toolbars=no,scrollbars=no'); return false;">
			<img src="${pageContext.request.contextPath}/upload/${myview.img}" width=80 height=80>
			</a>
	</header>
	<aside></aside>
	<article>
		
		<table>
			<tr>
				<td>
					<form action="${pageContext.request.contextPath}/mypage.do" method="get" onsubmit="target_popup(this)">
						<input name="id" type="hidden" value="${myview.id}">
						<input type="image" src="${pageContext.request.contextPath}/upload/${myview.img}" id="myimg">
					</form>
				</td>
				<td>${myview.name}</td>
				<td>${myview.why}</td>
				<td>
					<form action="${pageContext.request.contextPath}/checkbox.do"
						method="get" onsubmit="target_popup(this)">
						<c:if test="${empty myview.color}">
							<input type="image" src="./img/off.jpg" id="myimg">
						</c:if>
						<c:if test="${myview.color=='1'}">
							<input type="image" src="./img/on.jpg" id="myimg">
						</c:if>
					</form>
				</td>
			</tr>
		</table>
		
		<table>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>
						<form action="${pageContext.request.contextPath}/yourpage.do"
							method="get" onsubmit="target_popup(this)">
							<input name="id" type="hidden" value="${user.id}">
							<input type="image" src="${pageContext.request.contextPath}/upload/${user.img}" id="myimg">
						</form>
					</td>
					<td>${user.name}</td>
					<td>${user.why}</td>
					<c:if test="${empty user.color}">
						<td><img src="./img/off.jpg" id="myimg"></td>
					</c:if>
					
					
					<c:if test="${user.color=='1'}">
						<td>
							<form action="${pageContext.request.contextPath}/msg.do" method="get" onsubmit="target_popup(this)">
								<input name="fid" type="hidden" value="${user.id}">
								<input type="image" src="./img/on.jpg" id="myimg">
							</form>
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</article>
	<aside>
<%-- 	<a href="${pageContext.request.contextPath}/fadd.do" --%>
<!-- 			onclick="window.open(this.href, '_blank', 'width=400px,height=550px,toolbars=no,scrollbars=no'); return false;">친구추가</a> -->
	<button onclick="window.open('${pageContext.request.contextPath}/fadd.do', '_blank', 'width=400px,height=550px,toolbars=no,scrollbars=no'); return false;" class="button">친구추가</button>
		
	<button type="button" onclick="location.href='${pageContext.request.contextPath}/logout.do'" class="button"> 로그아웃</button>
	</aside>
	<footer></footer>
</body>
</html>