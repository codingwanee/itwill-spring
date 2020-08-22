<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<String> nameList=Arrays.asList("홍길동","임꺽정","전우치","일지매","장길산");
	request.setAttribute("nameList", nameList);
	request.getRequestDispatcher("string_list_el.jsp").forward(request, response);
	
%>