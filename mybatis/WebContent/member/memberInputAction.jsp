<%@page import="site.itwill.dao.MyMemberXMLDAO"%>
<%@page import="site.itwill.dto.MyMemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 회원정보를 전달받아 MYMEMBER 테이블에 저장하고 회원목록 출력페이지(memberDisplay.jsp)로 이동하는 JSP 문서 --%>    
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
	try {
		MyMemberXMLDAO.getDAO().addMember(member);
		response.sendRedirect("memberDisplay.jsp");
	} catch(Exception e) {
		//response.sendRedirect("memberInputForm.jsp");
		out.println("<script>");
		out.println("alert('이미 사용중인 아이디를 입력하여 회원 가입이 실패 하였습니다.');");
		out.println("history.back();");//out.println("history.go(-1);");
		out.println("</script>");
	}
%>







