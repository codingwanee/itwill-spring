<%@page import="site.itwill.dao.UserinfoModelOneDAO"%>
<%@page import="site.itwill.dto.UserinfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 로그인정보를 전달받아 USERINFO 테이블에 저장된 회원정보와 비교하여 인증 
성공한 경우 환영메세지 출력페이지(user_login.jsp)로 이동하는 JSP 문서 --%>
<%-- => 인증 실패된 경우에는 로그인정보 입력페이지(user_login.jsp)로 이동  --%>    
<%
	if(request.getMethod().equals("GET")) {
		response.sendRedirect("user_error.jsp");
		return;
	}

	String userid=request.getParameter("userid");
	String password=request.getParameter("password");
	
	UserinfoDTO userinfo=UserinfoModelOneDAO.getDAO().getUserinfo(userid);
	
	//검색된 회원정보가 존재하지 않는 경우 - 아이디 인증 실패
	if(userinfo==null) {
		session.setAttribute("message", "입력된 아이디가 존재하지 않습니다.");
		session.setAttribute("userid", userid);
		response.sendRedirect("user_login.jsp");
		return;
	}
	
	//비밀번호 인증 실패
	if(!password.equals(userinfo.getPassword())) {
		session.setAttribute("message", "입력된 아이디가 잘못 되었거나 비밀번호가 맞지 않습니다.");
		session.setAttribute("userid", userid);
		response.sendRedirect("user_login.jsp");
		return;
	}
	
	session.setAttribute("loginUserinfo", userinfo);
	
	response.sendRedirect("user_login.jsp");
%>