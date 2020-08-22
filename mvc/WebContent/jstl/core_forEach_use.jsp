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
	<%-- 
	<div>${nameArray[0]}</div>	
	<div>${nameArray[1]}</div>	
	<div>${nameArray[2]}</div>	
	<div>${nameArray[3]}</div>
	<div>${nameArray[4]}</div>
	--%>

	<%-- 
	<c:forEach var="i" begin="0" end="4" step="1">
		<div>${nameArray[i] }</div>
	</c:forEach>
	--%>	
	
	<%-- forEach 태그 : 배열 또는 컬렉션 인스턴스의 요소를 하나씩 제공받아 공유하는 태그 --%>
	<%-- => JAVA의 변형된 for 구분와 유사한 기능을 제공 --%>
	<%-- var 속성 : 공유 인스턴스의 속성명을 속성값으로 설정 --%>
	<%-- items 속성 : 공유된 배열 또는 컬렉션 인스턴스(EL)를 속성값으로 설정 --%>
	<c:forEach var="name" items="${nameArray }">
		<div>${name}</div>
	</c:forEach>
	<hr>
	
	<c:forEach var="student" items="${studentArray}">
		<div>학번 = ${student.num }, 이름 = ${student.name }</div>
	</c:forEach>
	<hr>	
	
	<c:forEach var="student" items="${studentList}">
		<div>학번 = ${student.num }, 이름 = ${student.name }</div>
	</c:forEach>
	<hr>	
	
	<%-- 공유 인스턴스가 Map인 경우 EL 표현식에서 Key와 Value 구분하여 사용 --%>
	<c:forEach var="student" items="${studentMap }">
		<div>${student.key} : 학번 = ${student.value.num }, 이름 = ${student.value.name }</div>
	</c:forEach>
</body>
</html>