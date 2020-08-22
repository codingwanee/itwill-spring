<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//pageContext.setAttribute(String attributeName, Object attributeValue)
	// => pageContext 인스턴스를 이용하여 인스턴스 공유하는 메소드 - Page Scope
	// => 공유한 웹문서에서만 공유 인스턴스를 반환받아 사용
	pageContext.setAttribute("name", "홍길동");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL(Expression Language)</h1>
	<hr>
	<p>Expression Language : 공유된 객체를 제공받아 출력하기 위한 언어</p>
	<hr>
	<h2>EL 미사용</h2>
	<%
		//pageContext.getAttribute(String attributeName)
		// => pageContext 인스턴스로 공유속성명을 이용하여 공유 인스턴스를 반환하는 메소드
		// => Object 클래스 형식으로 인스턴스를 반환하므로 객체 형변환하여 사용
		String name=(String)pageContext.getAttribute("name");
		
		//공유 인스턴스가 존재하지 않을 경우 null 반환
		String pageName=(String)pageContext.getAttribute("pageName");
	%>
	<p>이름 = <%=name %></p>
	<%-- 표현식에서는 null 값을 문자열로 변환하여 출력 --%>
	<p>이름 = <%=pageName %></p>
	<%-- if 명령을 이용하여 null 값인 경우 출력되지 않도록 설정 --%>
	<p>이름 = 
	<% if(pageName!=null) { %>
		<%=pageName %>
	<% } %>
	</p>
	<hr>
	<h2>EL 사용</h2>
	<%-- ${공유속성명} : 공유속성명의 공유 인스턴스를 반환받아 출력 --%>
	<%-- => getAttribute() 메소드가 자동 호출되어 공유 인스턴스 사용 가능 --%>
	<p>이름 = ${name}</p>
	<%-- 공유 인스턴스가 존재하지 않을 경우 미출력 --%>
	<p>이름 = ${pageName}</p>
</body>
</html>