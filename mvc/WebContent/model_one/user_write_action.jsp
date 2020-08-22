<%@page import="site.itwill.dao.UserinfoModelOneDAO"%>
<%@page import="site.itwill.dto.UserinfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 회원정보를 전달받아 USERINFO 테이블에 저장하고 로그인정보 입력페이지(user_login.jsp)로 이동하는 JSP 문서 --%>
<%-- => 비정상적인 요청이 발생된 경우 에러메세지 출력페이지(user_error.jsp)로 이동 --%>
<%-- => 회원정보를 USERINFO 테이블에 저장하지 못한 경우 회원정보 입력페이지(user_write.jsp)로 이동 --%>    
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
	userinfo.setPassword(password);
	userinfo.setName(name);
	userinfo.setEmail(email);
	
	int rows=UserinfoModelOneDAO.getDAO().addUserinfo(userinfo);
	
	if(rows>0) {//회원등록이 성공한 경우
		response.sendRedirect("user_login.jsp");
	} else {//회원등록이 실패한 경우 - 입력된 아이디가 이미 USERINFO 테이블에 저장된 상태
		session.setAttribute("message", "이미 저장된 아이디를 입력 하였습니다.");
		session.setAttribute("userinfo", userinfo);
		response.sendRedirect("user_write.jsp");
	}
%>
