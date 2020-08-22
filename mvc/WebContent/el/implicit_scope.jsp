<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//인스턴스 공유 범위(Scope) : page, request, session, application
	// => 공유 범위가 다른 경우라도 공유 속성명을 다르게 선언하는 것을 권장
	pageContext.setAttribute("pageName", "홍길동");
	request.setAttribute("requestName", "임꺽정");
	session.setAttribute("sessionName", "전우치");
	application.setAttribute("applicationName", "일지매");
	
	//공유 범위가 다르기 때문에 동일 공유 속성명 사용 가능
	// => EL 표현식으로 공유 속성명을 사용할 경우 pageContext로 공유된 인스턴스만 출력
	pageContext.setAttribute("name", "홍길동");
	request.setAttribute("name", "임꺽정");
	session.setAttribute("name", "전우치");
	application.setAttribute("name", "일지매");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL 내장객체 - Scope Attribute</h1>
	<hr>
	<ul>
		<li>공유 인스턴스(page scope) = ${pageName }</li> 
		<li>공유 인스턴스(request scope) = ${requestName }</li> 
		<li>공유 인스턴스(session scope) = ${sessionName }</li> 
		<li>공유 인스턴스(application scope) = ${applicationName }</li> 
	</ul>
	<hr>
	<%-- EL 표현식에서 공유 속성명을 사용할 경우 공유 인스턴스를 순차적으로 검색하여 출력 --%>
	<%-- 검색순서 : page >> request >> session >> application --%>
	<ul>
		<li>공유 인스턴스(page scope) = ${name }</li> 
		<li>공유 인스턴스(request scope) = ${name }</li> 
		<li>공유 인스턴스(session scope) = ${name }</li> 
		<li>공유 인스턴스(application scope) = ${name }</li> 
	</ul>
	<hr>
	<%-- EL 표현식에서 내장객체를 이용하여 공유 범위를 명시적으로 표현하여 공유 인스턴스 출력 --%>
	<%-- => pageScope, requestScope, sessionScope, applicationScope --%>
	<ul>
		<li>공유 인스턴스(page scope) = ${pageScope.name }</li> 
		<li>공유 인스턴스(request scope) = ${requestScope.name }</li> 
		<li>공유 인스턴스(session scope) = ${sessionScope.name }</li> 
		<li>공유 인스턴스(application scope) = ${applicationScope.name }</li> 
	</ul>
	
</body>
</html>





