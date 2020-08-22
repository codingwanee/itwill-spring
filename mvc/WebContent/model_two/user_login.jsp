<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%-- 세션으로 공유된 인증정보를 이용하여 로그인 상태와 비로그인 상태를 구분하여 결과를 제공하는 JSP 문서 --%>    
<%-- 비로그인 상태 : 로그인정보를 입력받기 위한 JSP 문서  --%>
<%-- => [로그인]을 클릭한 경우 로그인 처리페이지(/login.do)로 요청 --%>    
<%-- 로그인 상태 : 환영메세지를 출력하는 JSP 문서 --%>
<%-- => [회원목록]을 클릭한 경우 회원목록 출력페이지(/list.do)로 요청 --%>
<%-- => [로그아웃]을 클릭한 경우 로그아웃 처리페이지(/logout.do)로 요청 --%>
<%-- => [회원등록]을 클릭한 경우 회원등록 입력페이지(/writeForm.do)로 요청 - 관리자만 출력 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>MVC</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- 요청 URL 주소와 JSP 문서의 경로가 다른 경우 때문에 리소스 파일은 절대경로로 표현하는 것을 권장 --%>
<%-- <link rel=stylesheet href="${pageContext.request.contextPath }/model_two/css/user.css" type="text/css"> --%>
<link rel=stylesheet href='<c:url value="/model_two/css/user.css"/>' type="text/css">
<script language="JavaScript">
function userLogin() {
	if ( f.userid.value == "" ) {
		alert("아이디를 입력하십시요.");
		f.userid.focus();
		return;
	} 
	if ( f.password.value == "" ) {
		alert("비밀번호를 입력하십시요.");
		f.password.focus();
		return;
	}	
	
	f.action = "login.do";
	f.submit();
}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<table width=780 border=0 cellpadding=0 cellspacing=0>
	<tr>
	  <td width="20"></td>
	  <td style="color: red;">${message}</td>			
	</tr>

	<tr>
	  <td width="20"></td>
	  <td>
  	  <!--contents-->
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>회원관리 - 로그인</b></td>
		  </tr>
	  </table>  
	  <br>
	  
	  <%-- 비로그인 상태 --%>
	  <c:choose>
		  <c:when test="${empty(loginUserinfo)}">
			  <!-- login Form  -->
			  <form name="f" method="post">
			  <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
				  <tr>
					<td width=100 align=center bgcolor="E6ECDE" height="22">사용자 아이디</td>
					<td width=490 bgcolor="ffffff" style="padding-left:10px;">
						<input type="text" style="width:150" name="userid" value="${userid }">
					</td>
				  </tr>
				  <tr>
					<td width=100 align=center bgcolor="E6ECDE" height="22">비밀번호</td>
					<td width=490 bgcolor="ffffff" style="padding-left:10px;">
						<input type="password" style="width:150" name="password">
					</td>
				  </tr>
			  </table>
			  </form>
			  <br>
			  
			  <table width=590 border=0 cellpadding=0 cellspacing=0>
				  <tr>
					<td align=center>
						<input type="button" value="로그인" onClick="userLogin();"> &nbsp;
					</td>
				  </tr>
			  </table>
		  </c:when>
		  <c:otherwise>
			  <%-- 로그인 상태 --%>
			  <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
				  <tr>
					<td width=590 align=center bgcolor="E6ECDE" height="22">
						${loginUserinfo.name}님 환영합니다.
					</td>
				  </tr>
			  </table>
			  <br>
			  
			  <table border="0" cellpadding="0" cellspacing="1" width="590">
				  <tr>
					<td width=590 align=center>
						<button type="button" onclick="location.href='list.do';">회원목록</button>
						<button type="button" onclick="location.href='logout.do';">로그아웃</button>
						<c:if test="${loginUserinfo.userid=='abc123' }">
						<button type="button" onclick="location.href='writeForm.do';">회원등록</button>
						</c:if>
					</td>
				  </tr>
			  </table>
		</c:otherwise>
	</c:choose>
	</td>
	</tr>
</table>  
</body>
</html>