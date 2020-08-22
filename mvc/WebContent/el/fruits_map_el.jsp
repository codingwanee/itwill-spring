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
	<h2>과일의 종류</h2>
	<ul>
		<li>${fruits.one }</li>
		<li>${fruits.two }</li>
		<li>${fruits.three }</li>
	</ul>
	<hr>
	<%-- EL 표현식에서 다른 공유 인스턴스에 대한 표현식을 사용하고자 할 경우 [] 안에 표현식 사용 --%>
	<h3>좋아하는 과일 = ${fruits[choice]}</h3>
</body>
</html>




