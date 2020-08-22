<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 클라이언트의 모든 요청은 Front Controller를 이용하여 매핑 처리 후 응답 --%>
<%-- => 리소스 파일을 Front Controller에게 요청할 경우 미응답(매핑 미처리) --%>
<%-- 리소스 파일은 Front Controller을 이용하지 않고 직접 응답되도록 설정 --%>
<%-- => servlet-context.xml 파일에 resources 엘리먼트 이용 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
<%-- 
<style type="text/css">
.text { color: red; }
</style>
--%>

<%-- servlet-context.xml 파일의 resources 엘리먼트의 매핑정보 이용 --%>
<%-- <link rel="stylesheet" href="resources/css/style.css" type="text/css"> --%>

<%-- servlet-context.xml 파일의 resources 엘리먼트의 매핑정보를 변경한 경우 --%>
<%-- 템플릿 페이지를 이용하여 요청에 대한 응답처리 할 경우 요청자원은 절대경로로 표현하는 것을 권장 --%>
<%-- <link rel="stylesheet" href="css/style.css" type="text/css"> --%>

<%-- <link rel="stylesheet" href="http://localhost:8000/spring/css/style.css" type="text/css"> --%>
<%-- 동일 서버에 존재하는 자원은 서버경로를 생략하여 표현 => 컨텍스트명이 변경될 경우 문제 발생 -->
<%-- <link rel="stylesheet" href="/spring/css/style.css" type="text/css"> --%>

<%-- EL 내장객체(pageContext)를 이용하여 컨텍스트명을 제공받아 표현 --%>
<%-- <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/style.css" type="text/css"> --%>

<%-- Core 태그 라이브러리의 url 태그를 이용하여 컨텍스트명을 제공받아 표현 --%>
<link rel="stylesheet" href='<c:url value="/css/style.css"/>' type="text/css">
</head>
<body>
	<h1>Resource 파일</h1>
	<hr>
	<p class="text">리소스 파일 : 멀티미디어 파일, CSS 파일, JaveScript 파일 등</p>
	<hr>
	<img src="images/Koala.jpg" width="200">
	<img src="${pageContext.servletContext.contextPath }/images/Koala.jpg" width="200">
</body>
</html>