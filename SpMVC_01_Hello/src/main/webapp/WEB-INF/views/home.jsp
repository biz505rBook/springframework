<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>나의 스프링 홈</h3>
	<P>서버시간 : ${serverTime}.</P>
	<p>이름 : ${st_name}
	<p>학과 : ${st_dept}
	<p>학년 : ${st_grade}
	
	<form action="my" method="POST">
		<input name="strName">
		<input name="strDept">
		<button>전송</button>
	</form>
</body>
</html>