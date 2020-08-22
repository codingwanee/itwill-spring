<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>입력페이지</h1>
	<hr>
	<%-- <form action="input2" method="post"> --%>
	<%-- 동일한 URL 주소의 페이지로 전달하고자 할 경우 action 속성 생략 가능 --%>
	<form <%-- action="input"--%> method="post">
		이름 : <input type="text" name="name">
		<button type="submit">전송</button>
	</form>
</body>
</html>