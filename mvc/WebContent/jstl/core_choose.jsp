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
	<h1>Core - choose 태그</h1>
	<hr>
	<p>choose 태그는 자식태그로 when 태그(필수 - 1개 이상)와 
	otherwise 태그(선택 - 0개 또는 1개)만 사용</p>
	<hr>
	<c:set var="choice" value="4"/>

	<%-- choose 태그 : JAVA의 다중 if 구문과 유사한 기능을 제공하는 태그 --%>
	<c:choose>
		<%-- choose 태그는 반드시 자식태그(when 태그와 otherwise 태그)만 선언 가능 --%>
		<%-- => 자식태그가 아닌 경우 에러 발생 : HTML 주석문도 에러 발생(JSP 주석 사용 가능) --%>
		
		<%-- when 태그 : test 속성값이 false인 경우 태그내용을 미출력하며 true인 경우 태그내용 출력 --%>
		<%-- => when 태그의 test 속성값이 true인 경우 태그내용 출력 후 choose 태그 종료 --%>
		<c:when test="${choice==1}">
			<p>수성으로 이동합니다.</p>
		</c:when>
		<c:when test="${choice==2}">
			<p>금성으로 이동합니다.</p>
		</c:when>
		<c:when test="${choice==3}">
			<p>화성으로 이동합니다.</p>
		</c:when>
		
		<%-- otherwise 태그 : 모든 when 태그의 test 속성값이 false인 경우 태그내용을 출력 --%>
		<c:otherwise>
			<p>지구로 이동합니다.</p>
		</c:otherwise>
	</c:choose>
	
	<c:set var="num" value="11"/>
	<c:choose>
		<c:when test="${num%2==0 }">
			<p>${num } = 짝수</p>
		</c:when>
		<c:otherwise>
			<p>${num } = 홀수</p>
		</c:otherwise>
	</c:choose>	
</body>
</html>







