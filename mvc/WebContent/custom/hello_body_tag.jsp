<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="simple" uri="http://www.itwill.site/mvc/simple"%>
<% 
	boolean vip=true;
	request.setAttribute("vip", vip);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Custom Tag - Attribute and Body</h1>
	<hr>
	<simple:helloBody test="true">홍길동</simple:helloBody>
	<simple:helloBody test="false">임꺽정</simple:helloBody>
	<%-- 태그 속성값으로 상수만 설정 가능 - Expression 또는 EL를 속성값으로 설정할 경우 에러 발생  --%>
	<simple:helloBody test="<%=vip %>">전우치</simple:helloBody>
	<simple:helloBody test="${vip }">일지매</simple:helloBody>
</body>
</html>






