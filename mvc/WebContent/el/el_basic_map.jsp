<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Map 인스턴스 생성
	Map<String,String> car=new HashMap<String,String>();

	//Map.put(String key,String value) 메소드를 호출하여 Map 인스턴스에 엔트리 추가
	car.put("name","싼타페");
	car.put("color","하얀색");
	
	pageContext.setAttribute("carMap", car);
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
	<h2>EL 미사용</h2>
	<%
		Map<String, String> carMap=(Map<String, String>)pageContext.getAttribute("carMap");	
	
		//Map.get(String key) 메소드를 호출하여 Map 인스턴스에 저장된 엔트리의 값을 반환받아 저장
		String name=carMap.get("name");
		String color=carMap.get("color");
	%>
	<p>Car = <%=carMap %></p>
	<p>모델명 = <%=name %></p>	
	<p>색상 = <%=color %></p>		
	<hr>
	<h2>EL 사용</h2>
	<p>Car = ${carMap}</p>
	<%-- ${공유속성명.맵키} 형식으로 공유 인스턴스(Map)의 값을 반환받아 출력 --%>
	<%-- => getAttribute() 메소드와 get() 메소드가 자동 호출 --%>
	<p>모델명 = ${carMap.name }</p>	
	<p>색상 = ${carMap.color }</p>		
</body>
</html>


