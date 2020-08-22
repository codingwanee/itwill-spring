<%@page import="site.itwill.el.Student"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- taglib Directive를 이용하여 JSTL의 태그 라이브러리를 포함해야만 태그 사용 가능 --%>
<%-- Core 태그 라이브러리 : EL 지원 태그, 흐름 제어 태그, URL 자원 관련 태그 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Core - set 태그와 remove 태그</h1>
	<hr>
	<%-- set 태그 : 인스턴스를 생성하여 공유하거나 기존 공유 인스턴스를 변경하는 태그 --%>
	<%-- var 속성 : 공유속성명을 속성값으로 설정 --%>
	<%-- value 속성 : 공유 인스턴스를 속성값으로 설정 --%>
	<%-- scope 속성 : 공유범위(page : 기본, request, session, application)를 속성값으로 설정 --%>
	<c:set var="su" value="10" scope="page"/>
	<p>su = ${su }</p>
	
	<%-- 공유 속성명이 동일한 경우 공유 인스턴스 변경 --%>
	<%-- value 속성 대신 태그 내용으로 공유 인스턴스 설정 가능 --%>
	<c:set var="su">20</c:set>
	<p>su = ${su }</p>
	
	<%-- value 속성값으로 EL 사용 가능 => EL 표현식에서 EL 연산자 사용 --%>
	<c:set var="tot" value="${su+20 }"/>
	<p>tot = ${tot }</p>

	<c:set var="name" value="홍길동"/>
	<p>name = ${name }</p>
	
	<c:set var="now" value="<%=new Date() %>"/>
	<%-- EL 표현식으로 공유 인스턴스를 출력할 경우 toString() 메소드 호출 --%>
	<p>now = ${now }</p>
	<%-- EL 표현식으로 공유 인스턴스의 메소드 호출 가능 --%>
	<p>now.getTime() = ${now.getTime() }</p>
	<%-- EL 표현식으로 필드명을 사용하여 자동으로 getter 메소드 자동 호출 --%>
	<p>now.time = ${now.time }</p>
	
	<c:set var="student" value="<%=new Student(1000,\"홍길동\") %>"/>
	<p>student = ${student }</p>	
	<p>학번 = ${student.num }, 이름 = ${student.name }</p>
	
	<%-- set 태그 : 공유 인스턴스의 필드값을 변경하는 태그 --%>
	<%-- target 속성 : 필드값을 변경하고자 하는 공유 인스턴스를 속성값(EL)으로 설정 --%>
	<%-- property 속성 : 필드값을 변경하고자 하는 공유 인스턴스의 필드명을 속성값으로 설정 - setter 메소드 자동 호출 --%>
	<c:set target="${student }" property="num" value="2000"/>	
	<p>학번 = ${student.num }, 이름 = ${student.name }</p>
	<c:set target="${student }" property="name" value="임꺽정"/>	
	<p>학번 = ${student.num }, 이름 = ${student.name }</p>
	
	<%-- remove 태그 : 공유 속성명으로 공유 인스턴스를 제거하는 태그 --%>
	<c:remove var="student"/>
	<p>student = ${student }</p>	
</body>
</html>