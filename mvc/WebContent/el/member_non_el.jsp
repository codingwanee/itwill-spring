<%@page import="site.itwill.el.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 공유 인스턴스를 반환받아 출력하는 JSP 문서 - 뷰 역활 --%>    
<%-- => member.jsp 문서를 요청하면 스레드가 이동되어 공유 인스턴스를 반환하여 출력 --%>
<%-- => member.jsp 문서를 요청하지 않으면 공유 인스턴스가 존재하지 않아 NullPointerException 발생 --%>
<%
	Member member=(Member)request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 미사용</h1>
	<hr>
	<%-- <p>회원 = <%=member %></p> --%>
	<p>회원이름 = <%=member.getIrum() %></p>
	<%-- <p>회원 자동차 = <%=member.getCar() %></p> --%>
	<p>회원 자동차 모델명 = <%=member.getCar().getName() %></p>
	<p>회원 자동차 색상 = <%=member.getCar().getColor() %></p>
</body>
</html>



