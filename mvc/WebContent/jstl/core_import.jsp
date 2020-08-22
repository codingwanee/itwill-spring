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
	<h1>Core - import 태그</h1>
	<hr>
	<%-- import 태그 : 현재 JSP 문서에 다른 웹문서의 요청 결과를 포함하는 기능을 제공하는 태그 --%>
	<%-- => include 액션태그와 유사한 기능 제공 --%>
	<%-- include 액션태그는 현재 서버의 웹문서를 요청하여 결과를 포함하지만
	import 태그는 다른 서버의 웹문서를 요청하여 결과 포함 가능 --%>
	<%-- url 속성 : 요청자원의 URL 주소를 속성값으로 설정 --%>
	<%-- <c:import url="core_import_source.jsp"/> --%>
	
	<c:import url="core_import_source.jsp">
		<%-- param 태그 : 요청 JSP 문서에 값을 전달하기 위한 태그 --%>
		<%-- name 속성 : 파라메터 이름을 속성값으로 설정 --%>
		<%-- value 속성 : 전달값을 속성값으로 설정 --%>
		<c:param name="name" value="홍길동"/>
	</c:import>
	<hr>
	<%-- <c:import url="https://www.daum.net"/> --%>
	<iframe src="https://www.daum.net" width="100%" height="400"></iframe>	
</body>
</html>