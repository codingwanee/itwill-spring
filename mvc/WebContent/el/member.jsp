<%@page import="site.itwill.el.Car"%>
<%@page import="site.itwill.el.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- Member 클래스로 인스턴스를 생성하여 공유(Request Scope)하는 JSP 문서 - 모델 역활 --%>
<%
	//Member 인스턴스 생성
	Member member=new Member("홍길동",new Car("싼타페","하얀색"));

	//인스턴스 공유 - Request Scope
	// => 인스턴스를 공유한 웹문서와 스레드가 이동된 웹문서에서 공유 인스턴스 사용 가능
	// => 모델 클래스의 메소드에서 공유된 인스턴스를 JSP 문서에서 사용
	request.setAttribute("member", member);
	
	//포워드 이동 - 스레드를 다른 웹문서로 이동하여 응답 처리
	//request.getRequestDispatcher("member_non_el.jsp").forward(request, response);
	request.getRequestDispatcher("member_el.jsp").forward(request, response);
%>




