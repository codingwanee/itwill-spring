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
	<h1>Core - if 태그</h1>
	<hr>
	<%-- if 태그 : JAVA의 if 구분와 유사한 기능을 제공하는 태그 - 명령 선택 기능 제공 --%>
	<%-- => else 기능 미제공 --%>
	<%-- test 속성 : 속성값이 false인 경우 태그 내용을 미출력하며 true인경우 태그를 출력 --%>
	<c:if test="true">
		<p>test 속성값이 true인 경우 출력되는 내용</p>
	</c:if>
	
	<c:set var="sw" value="true"/>
	<%-- test 속성값으로 EL 사용이 가능하며 실행 결과가 false 또는 true 제공 --%>
	<c:if test="${sw }">
		<p>test 속성값이 true인 경우 출력되는 내용</p>
	</c:if>
	
	<c:set var="num" value="11"/>
	<%-- EL 표현식으로 EL 연산자를 이용하여 false 또는 true 제공 --%>
	<%-- 
	<c:if test="${num % 2 == 0}">
		<p>${num } = 짝수</p>
	</c:if>
	
	<c:if test="${num % 2 != 0}">
		<p>${num } = 홀수</p>
	</c:if>
	--%>
	<c:if test="${num mod 2 eq 0}">
		<p>${num } = 짝수</p>
	</c:if>
	
	<c:if test="${num mod 2 ne 0}">
		<p>${num } = 홀수</p>
	</c:if>
	
	<c:set var="score" value="185"/>
	<%-- 
	<c:if test="${score <= 100 && score >= 0 }">
		<p>${score }점은 정상적인 점수입니다.</p>
	</c:if>
	<c:if test="${score > 100 || score < 0  }">
		<p>${score }점은 비정상적인 점수입니다.</p>
	</c:if>
	--%>
	<c:if test="${score le 100 and score ge 0 }">
		<p>${score }점은 정상적인 점수입니다.</p>
	</c:if>
	<c:if test="${score gt 100 or score lt 0  }">
		<p>${score }점은 비정상적인 점수입니다.</p>
	</c:if>
	
	<c:if test="${empty(name) }">
		<p>name 속성명으로 공유된 인스턴스 값이 존재하지 않습니다.</p>
	</c:if>

	<c:set var="name" value="홍길동"/>
	<c:if test="${!empty(name) }">
		<p>name 속성명으로 공유된 인스턴스 값은 [${name }]입니다.</p>
	</c:if>	
</body>
</html>