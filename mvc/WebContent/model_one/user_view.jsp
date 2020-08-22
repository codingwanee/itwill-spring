<%@page import="site.itwill.dao.UserinfoModelOneDAO"%>
<%@page import="site.itwill.dto.UserinfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 아이디를 전달받아 USEINFO 테이블에 저장된 회원정보를 검색하여 출력하는 JSP 문서 --%>
<%-- => [수정]을 클릭한 경우 회원정보변경 입력페이지(user_modify.jsp)로 이동 - 관리자 또는 로그인 사용자와 상세 사용자가 동일한 경우 --%>
<%-- => [삭제]을 클릭한 경우 회원정보삭제 처리페이지(user_remove_action.jsp)로 이동 - 관리자 --%>
<%-- => [목록]을 클릭한 경우 회원목록 출력페이지(user_list.jsp)로 이동 --%>
<%
	UserinfoDTO loginUserinfo=(UserinfoDTO)session.getAttribute("loginUserinfo");
	if(loginUserinfo==null) {
		response.sendRedirect("user_error.jsp");
		return;
	}
	
	String userid=request.getParameter("userid");
	
	UserinfoDTO userinfo=UserinfoModelOneDAO.getDAO().getUserinfo(userid);
	if(userinfo==null) {
		response.sendRedirect("user_error.jsp");
		return;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MVC</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/user.css" type="text/css">
<script language="JavaScript">
function userRemove(userid) {
	if (confirm("정말로 삭제 하시겠습니까?") ) {
		location.href='user_remove_action.jsp?userid='+userid;
	}
}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<table width=780 border=0 cellpadding=0 cellspacing=0>
	<tr>
	  <td width="20"></td>
	  <td>
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>회원관리 - 상세정보</b></td>
		  </tr>
	  </table>  
	  <br>
	  
	  <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">아이디</td>
			<td width=490 bgcolor="ffffff"  style="padding-left:10px;">
				<%=userinfo.getUserid() %>
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
			<td width=490 bgcolor="ffffff"  style="padding-left:10px;">
				<%=userinfo.getName() %>
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">이메일</td>
			<td width=490 bgcolor="ffffff"  style="padding-left:10px;">
				<% if(userinfo.getEmail()!=null) { %>
				<%=userinfo.getEmail() %>
				<% } %>
			</td>
		  </tr>		  
	  </table>
	  <br>
	  
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td align=center>
			<% if(loginUserinfo.getUserid().equals("abc123") || loginUserinfo.getUserid().equals(userinfo.getUserid())) { %>
			<input type="button" value="수정" onClick="location.href='user_modify.jsp?userid=<%=userinfo.getUserid()%>';">
			<% } %>
			<% if(loginUserinfo.getUserid().equals("abc123") && !userinfo.getUserid().equals("abc123")) { %>
			<input type="button" value="삭제" onClick="userRemove('<%=userinfo.getUserid()%>');">
			<% } %>
			<input type="button" value="목록" onClick="location.href='user_list.jsp';"> 
			</td>
		  </tr>
	  </table>

	  </td>
	</tr>
</table>  
</body>
</html>