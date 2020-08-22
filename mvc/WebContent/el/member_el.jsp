<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 공유 인스턴스를 반환받아 출력하는 JSP 문서 - 뷰 역활 --%>    
<%-- => member.jsp 문서를 요청하지 않으면 미출력 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 사용</h1>
	<hr>
	<%-- <p>회원 = ${member }</p> --%>
	<p>회원이름 = ${member.irum }</p>
	<p>회원이름 = ${member["irum"] }</p>
	<%-- <p>회원 자동차 = ${member.car }</p> --%>
	<p>회원 자동차 모델명 = ${member.car.name }</p>
	<p>회원 자동차 색상 = ${member.car.color }</p>	
</body>
</html>




