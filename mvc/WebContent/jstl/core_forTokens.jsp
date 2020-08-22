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
	<h1>Core - forTokens 태그</h1>
	<hr>
	<c:set var="phone" value="010-1234-5678"/>
	<p>전화번호 = ${phone }</p>
	
	<%-- forTokens 태그 : 공유 인스턴스의 값을 특정 문자열로 구분하여 분리된 값들을 반복 처리하는 태그 --%>
	<%-- var 속성 : 분리된 값을 공유하기 위한 속성명을 속성값으로 설정 --%>
	<%-- items 속성 : 분리하고자 하는 공유 인스턴스의 값(EL)을 속성값으로 설정 --%>
	<%-- delims 속성 : 구분 문자열을 속성값으로 설정 --%>
	<c:forTokens var="num" items="${phone }" delims="-">
		<div>${num }</div>
	</c:forTokens>
</body>
</html>





