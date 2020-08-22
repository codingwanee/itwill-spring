<%@page import="site.itwill.dao.MyMemberXMLDAO"%>
<%@page import="site.itwill.dto.MyMemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 회원정보를 전달받아 MYMEMBER 테이블에 저장된 학생정보를 변경하고 회원목록 출력페이지(memberDisplay.jsp)로 이동 --%>    
<%
	request.setCharacterEncoding("UTF-8");

	String id=request.getParameter("id");
	String name=request.getParameter("name");
	String phone=request.getParameter("phone");
	String email=request.getParameter("email");
	
	MyMemberDTO member=new MyMemberDTO();
	member.setId(id);
	member.setName(name);
	member.setPhone(phone);
	member.setEmail(email);
	
	MyMemberXMLDAO.getDAO().modifyMember(member);
	
	response.sendRedirect("memberDisplay.jsp");
%>