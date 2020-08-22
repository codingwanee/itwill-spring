<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Map<String,String> hewon=new HashMap<String,String>();

	hewon.put("first.name","홍");
	hewon.put("second.name","길동");
	
	request.setAttribute("hewon", hewon);
	
	request.getRequestDispatcher("hewon_map_el.jsp").forward(request, response);
%>