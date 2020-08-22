<%@page import="site.itwill.dao.MyMemberXMLDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 아이디를 전달받아 MYMEMBER 테이블에 저장된 회원정보를 삭제하고 회원목록 출력페이지(memberDisplay.jsp)로 이동하는 JSP 문서 --%>
<%
	String id=request.getParameter("id");
	MyMemberXMLDAO.getDAO().removeMember(id);
	response.sendRedirect("memberDisplay.jsp");
%>