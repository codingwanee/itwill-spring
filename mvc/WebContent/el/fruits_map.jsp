<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Map<String,String> fruits=new HashMap<String,String>();

	fruits.put("one","딸기");
	fruits.put("two","복숭아");
	fruits.put("three","참외");
	
	request.setAttribute("fruits", fruits);
	request.setAttribute("choice", "two");
	
	request.getRequestDispatcher("fruits_map_el.jsp").forward(request, response);
%>