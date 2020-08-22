<%@page import="site.itwill.dao.MyHewonDAO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Map<String, Object> map=new HashMap<String, Object>();
	map.put("id","xxx");
	map.put("name","홍길동");
	map.put("phone","010-9999-9999");
	map.put("email","xxx@google.com");
	map.put("state",4);
	
	MyHewonDAO.getDAO().insertHewonMap(map);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mtbatis</title>
</head>
<body>
	<h1>회원등록</h1>
	<hr>
	<h3>회원정보를 성공적으로 등록 하였습니다.</h3>
</body>
</html>