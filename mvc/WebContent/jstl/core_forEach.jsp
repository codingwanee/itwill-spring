<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Core - forEach 태그</h1>
	<hr>
	<%-- forEach 태그 : JAVA의 for 구문과 유사한 기능을 제공하는 태그 --%>
	<%-- => 태그내용을 반복 출력하는 기능 제공 --%>
	<%-- var 속성 : 공유 인스턴스의 속성명을 속성값으로 설정 --%>
	<%-- begin 속성 : 공유 인스턴스의 시작값(Integer)을 속성값으로 설정 --%>
	<%-- end 속성 : 공유 인스턴스의 종료값(Integer)을 속성값으로 설정 --%>
	<%-- step 속성 : 공유 인스턴스의 증가값(Integer)을 속성값으로 설정 --%>
	<c:forEach var="i" begin="1" end="5" step="1">
		<div>${i }번째 실행되는 명령</div>
	</c:forEach>
	<hr>
	
	<%-- 1~100 범위의 정수들의 합계를 계산하여 출력 --%>
	<c:forEach var="i" begin="1" end="100" step="1">
		<c:set var="tot" value="${tot+i }"/>
	</c:forEach>
	<p>1~100 범위의 정수 합계 = ${tot }</p>
	<hr>
	
	<table>
	<c:forEach var="i" begin="1" end="9" step="1">
		<tr align="center">
		<c:forEach var="j" begin="2" end="9" step="1">
			<td width="100">${j }*${i }=${i*j }</td>
		</c:forEach>
		</tr>
	</c:forEach>
	</table>
</body>
</html>







