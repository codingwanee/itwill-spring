﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%-- 모델 클래스에서 공유한 회원정보를 반환받아 출력하는 JSP 문서 --%>
<%-- => [수정]을 클릭한 경우 회원변경 입력페이지(/userinfo/modify) 요청 - 관리자 또는 로그인 사용자와 상세 사용자가 동일한 경우 --%>
<%-- => [삭제]을 클릭한 경우 회원삭제 처리페이지(/userinfo/remove) 요청 - 관리자 --%>
<%-- => [목록]을 클릭한 경우 회원목록 출력페이지(/userinfo/list) 요청 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MVC</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="JavaScript">
function userRemove(userid) {
	if (confirm("정말로 삭제 하시겠습니까?") ) {
		location.href='${pageContext.request.contextPath }/userinfo/remove?userid='+userid;
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
				${userinfo.userid}
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
			<td width=490 bgcolor="ffffff"  style="padding-left:10px;">
				${userinfo.name}
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">이메일</td>
			<td width=490 bgcolor="ffffff"  style="padding-left:10px;">
				${userinfo.email}
			</td>
		  </tr>		  
	  </table>
	  <br>
	  
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td align=center>
			<c:if test="${loginUserinfo.userid=='abc123' || loginUserinfo.userid==userinfo.userid }">
			<input type="button" value="수정" onClick="location.href='${pageContext.request.contextPath }/userinfo/modify?userid=${userinfo.userid}';">
			</c:if>
			<c:if test="${loginUserinfo.userid=='abc123' && userinfo.userid!='abc123'}">
			<input type="button" value="삭제" onClick="userRemove('${userinfo.userid}');">
			</c:if>
			<input type="button" value="목록" onClick="location.href='${pageContext.request.contextPath }/userinfo/list';"> 
			</td>
		  </tr>
	  </table>
	  </td>
	</tr>
</table>  
</body>
</html>