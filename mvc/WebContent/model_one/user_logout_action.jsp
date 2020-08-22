<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그아웃 처리하고 로그인정보 입력페이지(user_login.jsp)로 이동 --%>    
<%
	session.invalidate();
	response.sendRedirect("user_login.jsp");
%>