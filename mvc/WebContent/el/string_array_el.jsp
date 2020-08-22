<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL - Array</h1>
	<hr>
	<ul>
		<%-- 공유 인스턴스가 배열인 경우 EL 표현식에서 . 연산자로 배열의 
		첨자(index)를 표현할 경우 ELException 예외 발생 --%>
		<%-- ELException : EL 표현식이 잘못된 경우 발생하는 예외 --%>
		<%-- <li>${nameArray.0}</li> --%>
		<%-- 반드시 [] 연산자로 배열의 첨자를 표현하여 배열 요소값 출력 --%>
		<%-- <li>${nameArray["0"]}</li> --%>
		<li>${nameArray[0]}</li>
		<li>${nameArray[1]}</li>
		<li>${nameArray[2]}</li>
		<li>${nameArray[3]}</li>
		<li>${nameArray[4]}</li>
		<%-- 배열 요소의 첨자를 잘못 사용한 경우 미출력 --%>
		<%-- <li>${nameArray[5]}</li> --%>
	</ul>
</body>
</html>





