<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<style type='text/css'>
@import url("login.css");
@import url(https://fonts.googleapis.com/css?family=Bree+Serif);
</style>
<link rel="stylesheet" href="css/login.css">
</head>
<body>
<body>
   <header style="background-color:white">
      <a class="title" href="${pageContext.request.contextPath}/index.do" class="title">
               <img src="./img/title.png"></a> 
   </header>   
   <aside></aside>         
    <article>
    
    <div id="wrapper">

   <form ID="fomr1" name="login-form" class="login-form" action="login.do" method="post">
   
      <div class="header">
      <h1>Login</h1>
      <span>Fill out the form below to login to URI </span>
      </div>
   
      <div class="content">
      <input name="id" type="text" class="input username" placeholder="User ID" required="required"/>
      <div class="user-icon"></div>
      <input name="pw" type="password" class="input password" placeholder="Password" required="required"/>
      <div class="pass-icon"></div>      
      </div>

      <div class="footer">
      <input type="submit" name="submit" value="Login" class="button" />
      <a class="register" href="${pageContext.request.contextPath}/add.do">Register</a>
      </div>
   
   </form>

</div>
<div class="gradient"></div>   
    
   </article>
    <aside></aside>
    <footer></footer>
    
</body>
</html>