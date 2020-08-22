<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL - Map</h1>
	<hr>
	<h2>회원정보</h2>
	<ul>
		<%-- EL 표현식이 식별자 작성 규칙에 맞지 않을 경우 값 미출력 --%>
		<%-- => 맵키의 표현식으로 사용 불가능한 기호를 이용한 경우 . 연산자로 맵값을 출력 불가능 --%>
		<%-- => 맵키의 표현식으로 사용 불가능한 기호를 이용한 경우 [] 연산자로 맵값을 출력 가능 --%>
		<%-- <li>이름-1 = ${hewon.first.name}</li> --%>
		<li>이름-1 = ${hewon["first.name"]}</li>
		<li>이름-2 = ${hewon["second.name"]}</li>
	</ul>
</body>
</html>



