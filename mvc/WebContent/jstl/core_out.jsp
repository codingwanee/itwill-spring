<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Core - out 태그</h1>
	<hr>
	<c:set var="num" value="100"/>
	<p>정수값 = ${num }</p>
	
	<%-- out 태그 : 클라이언트 브라우저에 값을 전달하여 출력하는 태그 --%>
	<%-- value 속성 : 출력값(EL)을 속성값으로 설정 --%>
	<p>정수값 = <c:out value="${num }"/></p>
	<hr>
	<c:set var="html" value="<font size='7' color='red'>안녕하세요</font>"/>
	<%-- EL를 사용하여 태그가 존재하는 문자열을 출력할 경우 태그가 적용되어 출력 --%>
	<p>html = ${html }</p>
	<%-- out 태그를 사용하여 태그가 존재하는 문자열을 출력할 경우 태그가 문자열로 그대로 출력 --%>
	<p>html = <c:out value="${html }"/></p>
</body>
</html>






