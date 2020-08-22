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
	<h1>Core - url 태그</h1>
	<hr>
	<%-- 리소스 파일(CSS 파일, JS 파일, 멀티미디어 파일 등)을 상대경로 표현방식으로 제공 --%>
	<%-- 요청 문서와 응답 문서의 경로가 다른 경우 응답 문서에서의 리소스 파일 경로는 
	요청 문서 경로 기준으로 설정 - 경로 설정 문제로 404 코드 발생 --%>
	<img src="images/Koala.jpg" width="200">
	
	<%-- 리소스 파일(CSS 파일, JS 파일, 멀티미디어 파일 등)을 절대경로 표현방식으로 제공 --%>
	<img src="http://localhost:8000/mvc/jstl/images/Koala.jpg" width="200">
	<%-- 동일 서버의 리소스 파일인 경우 서버명 생략 가능 --%>
	<%-- => 컨텍스트 이름이 변경될 경우 404 코드 발생  --%>
	<img src="/mvc/jstl/images/Koala.jpg" width="200">
	
	<%-- request.getContextPath() 메소드를 호출하여 컨텍스트 경로를 제공받아 표현 --%>
	<img src="<%=request.getContextPath() %>/jstl/images/Koala.jpg" width="200">
	
	<%-- EL 내장객체인 pageContext를 이용하여 컨텍스트 경로를 제공받아 표현 --%>
	<img src="${pageContext.request.contextPath}/jstl/images/Koala.jpg" width="200">
	
	<%-- url 태그를 이용하여 컨텍스트 경로를 제공받아 표현 --%>
	<%-- url 태그 : 컨텍스트 경로가 포함된 리소스 파일 경로를 제공하는 태그 --%>
	<%-- value 속성 : 컨텍스트 경로를 제외한 리소스 파일의 경로를 속성값으로 설정 --%>
	<img src='<c:url value="/jstl/images/Koala.jpg"/>' width="200">
</body>
</html>
