<%@page import="site.itwill.dao.UserinfoModelOneDAO"%>
<%@page import="site.itwill.dto.UserinfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 변경 회원정보를 전달받아 USERINFO 테이블에 저장된 회원정보를 변경하고
회원상세 출력페이지(user_view.jsp)로 이동하는 JSP 문서 --%>    
<%
	if(request.getMethod().equals("GET")) {
		response.sendRedirect("user_error.jsp");
		return;
	}

	request.setCharacterEncoding("UTF-8");
	
	String userid=request.getParameter("userid");
	String password=request.getParameter("password");
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	
	UserinfoDTO userinfo=new UserinfoDTO();
	userinfo.setUserid(userid);
	if(password==null || password.equals("")) {
		userinfo.setPassword(UserinfoModelOneDAO.getDAO().getUserinfo(userid).getPassword());
	} else {
		userinfo.setPassword(password);
	}
	userinfo.setName(name);
	userinfo.setEmail(email);
	
	UserinfoModelOneDAO.getDAO().modifyUserinfo(userinfo);
	
	response.sendRedirect("user_view.jsp?userid="+userid);
%>	