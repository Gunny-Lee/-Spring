<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<style type='text/css'>
@import url("checkbox.css");
</style>
<link rel="stylesheet" href="css/checkbox.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
   var log = console.log;
   var d = 0;
   function checkboxCreate() {
      f.action = "./checkbox.do";
      f.method = "post";
      f.submit();
      self.close();
   }
   function userList() {
      self.close();
   }
</script>
<title>Uri</title>
</head>
<body onload="window.resizeTo(400,550)">
<form name="f">
   <h2>카테고리를 선택해 주세요.</h2>
   <li>1. 용도를 선택해주세요.</li>
   <input type="hidden" name="id" value="${login.id}">
   
   <input type="radio" name="why" value="#식사">식사
   <input type="radio" name="why" value="#운동">운동
   <input type="radio" name="why" value="#영화">영화
   <input type="radio" name="why" value="#기타">기타
   <input type="radio" name="why" value="#상관없음">상관없음
   <br>
   <br>
   <br>
   <li>2. 시간을 선택해주세요.</li>
   <br>
   <select id="start" name="stime" onfocus="babo()" onchange="mungchung()">
   <option value="--" selected>--</option>
      <script>
         var i = 1;
         function babo() {
            for (; i <= 24; i++) {
               $("#start").append(
                     $("<option val="+i+">" + i + "</option>"));
               //document.write('<option value=' + i + '>' + i + '</option>');
               log(i);
                  
            }
         }
         function mungchung() {
            var start = parseInt($("#start").val());
            log(start);
            $("#end").empty();
            for (var j = start; j <= start + 12; j++) {
               $("#end").append(
                     $("<option val="+j+">" + j % 24 + "</option>"));
               log(j);
            }
         }
         var k = 0;
         var l = 0;
               function babot() {
                  for (; k <= 59; k=k+5) {
                     $("#startt").append(
                           $("<option val="+k+">" + k + "</option>"));
                     //document.write('<option value=' + i + '>' + i + '</option>');
                     log(k);
                  }

               }
               function mungchungt() {
                  var startt = parseInt($("#startt").val());
                  log(startt);
                  $("#endt").empty();
                  var a = parseInt($("#start").val());
                  var b = parseInt($("#end").val());
                  
                  if(a==b){
                     for (var h = startt + 5; h <= 59; h=h+5) {
                        $("#endt").append(
                              $("<option val="+h+">" + h + "</option>"));
                        log(h);
                     }
                  }
                  else{
                     for (; l <= 59; l=l+5) {
                        $("#endt").append(
                              $("<option val="+l+">" + l + "</option>"));
                        log(h);
                     }

                  }
                     
               }
   </script>
   </select>
   <label>시</label>
   <select id="startt" name="smin" onfocus="babot()" onchange="mungchungt()">
   <option value="--" selected>--</option>
   </select>
   <label>분부터 ~</label>
   <select id="end" name="etime">
   <option value="--" selected>--</option>
   </select>
   <label>시</label>
   <select id="endt" name="emin">
   <option value="--" selected>--</option>
   </select>
   <label>분까지</label>
   <br>
   <br>


   <br>
   <br>
   <br>
   <br>
   <li>3. 장소를 선택해주세요.</li>
   <textarea name="content" cols="40" rows="1"></textarea>
   <br>
   <br>
   <br>
   <li>4. 인원수를 선택해주세요.</li>
   <input type="radio" name="ppnum" value="2">2
   <input type="radio" name="ppnum" value="3">3
   <input type="radio" name="ppnum" value="4">4
   <input type="radio" name="ppnum" value="5">5
   <input type="radio" name="ppnum" value="99">기타
   <input type="radio" name="ppnum" value="99">상관없음
   <br>
   <br>
   <br>
    <li>5. 불 색깔을 선택해주세요.</li>
   <input type="radio" name="color" style="color: blue;" value="0">회색
   <input style="color: green;" type="radio" name="color" value="1">초록
   <br>
   <br>
   <br>
   <li>6. 상태 메시지를 적어주세요.</li>
   <textarea name="msg" cols="40" rows="1"></textarea>
   <br>
   <input type="button" value="확 인" onClick="checkboxCreate()" class="button"> &nbsp;
   <input type="button" value="닫 기" onClick="userList()" class="button">
   </form>
</body>
</html>