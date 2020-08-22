<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- Encoding 필터를 사용할 경우 생략 가능 --%>
<%-- request.setCharacterEncoding("UTF-8"); --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Core - if 태그</h1>
	<hr>
	<c:if test="${!empty(param.name) }">
		<p>${param.name }님 환영합니다.</p>
	</c:if>	
	
	<%-- 처리페이지를 직접 요청한 경우 입력페이지로 이동되도록 설정 --%>
	<c:if test="${empty(param.name) }">
		<c:set var="message" value="이름을 반드시 입력해 주세요." scope="session"/>
		<%-- redirect 태그 : 원하는 웹문서를 요청하도록 클라이언트 브라우저에게 응답하는 태그 --%>
		<%-- => response.sendRedirect() 메소드와 동일한 기능을 제공하는 태그 --%>
		<%-- url 속성 : 클라이언트 브라우저에게 요청하도록 제공하는 웹문서의 URL 주소를 속성값으로 설정 --%>
		<c:redirect url="core_if_form.jsp"/>
	</c:if>
</body>
</html>