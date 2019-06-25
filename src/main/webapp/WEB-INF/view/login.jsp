<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>login1</title>


</head>
<body>
   <h2>로그인</h2>
   <form id="form1" name="form1" action="login.do" method="post"
      onsubmit="return check()">
      <table border="1">
         <tr>
            <td colspan="2"><span style="color: red">${msg}</span></td>
         </tr>
         <tr>
            <td>ID</td>
            <td><input type="text" id="id" name="userid" required="required"></td>
         </tr>
         <tr>
            <td>PW</td>
            <td><input type="text" id="pw" name="userpwd" required="required">
         </tr>
         <tr align="center">
            <td colspan="2"><input type="submit" value="login"> <input
               type="reset" value="reset"></td>
         </tr>
         <tr>
            <td colspan="2"><a href="#">회원등록  </a></td>
         </tr>
      </table>
   </form>
</body>
</html>