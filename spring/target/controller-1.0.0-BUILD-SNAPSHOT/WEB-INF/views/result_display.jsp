<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 공유 인스턴스는 EL과 JSTL를 이용하여 출력 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>요청에 대한 처리결과 출력(응답)</h1>
	<hr>
	<h2>ModelAndView = ${mv }</h2>
	<h2>HttpServletRequest = ${request }</h2>
	<h2>Model = ${model }</h2>
	<h2>ModelMap = ${map }</h2>
</body>
</html>