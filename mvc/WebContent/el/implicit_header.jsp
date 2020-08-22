<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 내장객체 - Request Header</h1>
	<hr>
	<h2>EL 미사용</h2>
	<ul>
		<li>서버 호스트명 = <%=request.getHeader("host") %></li>
		<li>브라우저 종류 = <%=request.getHeader("user-Agent") %></li>
		<li>Accpet = <%=request.getHeaders("accept").nextElement() %></li>
	</ul>
	<hr>
	<h2>EL 사용</h2>
	<ul>
		<li>서버 호스트명 = ${header.host }</li>
		<li>브라우저 종류 = ${header["user-Agent"] }</li>
		<li>Accpet = ${headerValues.accept[0] }</li>
	</ul>
</body>
</html>




