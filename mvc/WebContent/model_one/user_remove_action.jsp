<%@page import="site.itwill.dao.UserinfoModelOneDAO"%>
<%@page import="site.itwill.dto.UserinfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 아이디를 전달받아 USERINFO 테이블에 저장된 회원정보를 삭제하고 회원목록 출력페이지(user_list.jsp)로 이동하는 JSP 문서 --%>    
<%
	UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
	if(loginUserinfo==null || !loginUserinfo.getUserid().equals("abc123")) {
		response.sendRedirect("user_error.jsp");
		return;
	}
	
	String userid=request.getParameter("userid");
	if(userid==null || userid.equals("abc123")) {
		response.sendRedirect("user_error.jsp");
		return;
	}
	
	UserinfoModelOneDAO.getDAO().removeUserinfo(userid);
	
	response.sendRedirect("user_list.jsp");
%>





