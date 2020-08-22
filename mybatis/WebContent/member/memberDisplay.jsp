<%@page import="site.itwill.dao.MyMemberXMLInterfaceDAO"%>
<%@page import="site.itwill.dao.MyMemberInterfaceDAO"%>
<%@page import="site.itwill.dto.MyMemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="site.itwill.dao.MyMemberXMLDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- MYMEMBER 테이블에 저장된 모든 회원정보를 검색하여 출력하는 JSP 문서 --%>
<%-- => [회원입력]를 클릭한 경우 회원정보 입력페이지(memberInputForm.jsp) 이동 --%>
<%-- => [회원이름]을 클릭한 경우 회원정보 상세 출력페이지(memberView.jsp) 이동 - 아이디 전달 --%>
<%
	//XML Mappper 파일을 이용한 DAO 클래스의 메소드 호출
	//List<MyMemberDTO> memberList=MyMemberXMLDAO.getDAO().getMemberList();

	//Interface Mappper 파일을 이용한 DAO 클래스의 메소드 호출
	//List<MyMemberDTO> memberList=MyMemberInterfaceDAO.getDAO().getMemberList();

	//XML Mappper 파일과 Interface Mappper 파일을 이용한 DAO 클래스의 메소드 호출
	List<MyMemberDTO> memberList=MyMemberXMLInterfaceDAO.getDAO().getMemberList();
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mybatis</title>
</head>
<body>
	<h1 align="center">회원 리스트</h1>
	<hr>
	<table align="center" border="1" cellspacing="0" width="300">
		<tr>
			<th width="140">아이디</th>
			<th width="160">이름</th>
		</tr>
		<%-- 회원목록 출력 => 반복문 시작 --%>	
		<% for(MyMemberDTO member:memberList) { %>
		<tr align="center">
			<td width="140"><%=member.getId() %></td>
			<td width="160"><a href="memberView.jsp?id=<%=member.getId() %>">
				<%=member.getName() %></a></td>
		</tr>
		<% } %>
		<%-- 반복문 종료 --%>

		<tr align="right">
			<td colspan="2">
				<button type="button" 
					onclick="location.href='memberInputForm.jsp';">회원입력</button>
			</td>
		</tr>
	</table>
</body>
</html>