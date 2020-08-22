<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- form 태그의 입력태그를 이용하여 값을 입력하는 JSP 문서 --%>    
<%-- => submit 이벤트에 의해 form 태그의 입력값 다른 JSP 문서로 전달하여 요청 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 내장객체 - Request Parameter</h1>
	<hr>
	<form action="implicit_param_action.jsp" method="post">
		<div><b>개인정보</b></div>
		<div>이름 : <input type="text" name="name"></div>
		<div>주소 : <input type="text" name="address"></div>
		<div>&nbsp;</div>
		<div><b>좋아하는 음식</b></div>
		<div>음식-1 : <input type="text" name="food"></div>
		<div>음식-2 : <input type="text" name="food"></div>
		<div>&nbsp;</div>
		<button type="submit">전송</button>
	</form>	
</body>
</html>









