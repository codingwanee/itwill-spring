<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- Formatter 태그 라이브러리 : 숫자 또는 날짜 및 시간 관련 변환 태그, 국제화 및 다국어 지원 태그 등 --%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Formatter - formatDate 태그</h1>
	<hr>
	<c:set var="now" value="<%=new Date() %>"/>
	<p>now = ${now }</p>
	
	<%-- formatDate 태그 : 날짜와 시간정보(Date 인스턴스)를 원하는 패턴으로 변환하는 기능을 제공하는 태그 --%>
	<%-- => SimpleDateFormat 클래스의 역활과 유사한 기능 제공 --%>
	<%-- value 속성 : 공유된 날짜와 시간정보를 저장한 Date 인스턴스(EL)를 속성값으로 설정 --%>
	<%-- type 속성 : 날짜(date) 또는 시간(time)을 속성값으로 설정 --%>
	<%-- type 속성값이 date인 경우 "yyyy.M.d" 형태로 변환되어 출력 -  --%>
	<p>now(날짜) = <fmt:formatDate value="${now }" type="date"/></p>
	<%-- dateStyle 속성 : 날짜 변환 형태(full 또는 short)를 속성값으로 설정 --%>
	<%-- dateStyle 속성값이 full인 경우 "yyyy년 M월 d일 E요일" 형태로 변환되어 출력 --%>
	<p>now(날짜) = <fmt:formatDate value="${now }" type="date" dateStyle="full"/></p>
	<%-- dateStyle 속성값이 short인 경우 "yy.M.d" 형태로 변환되어 출력 --%>
	<p>now(날짜) = <fmt:formatDate value="${now }" type="date" dateStyle="short"/></p>

	<%-- type 속성값이 time인 경우 "a h:mm:ss" 형태로 변환되어 출력 -  --%>
	<p>now(시간) = <fmt:formatDate value="${now }" type="time"/></p>
	<%-- timeStyle 속성 : 시간 변환 형태(full 또는 short)를 속성값으로 설정 --%>
	<%-- timeStyle 속성값이 full인 경우 "a h시 mm분 ss초 z" 형태로 변환되어 출력 --%>
	<p>now(시간) = <fmt:formatDate value="${now }" type="time" timeStyle="full"/></p>
	<%-- timeStyle 속성값이 short인 경우 "a h:mm" 형태로 변환되어 출력 --%>
	<p>now(시간) = <fmt:formatDate value="${now }" type="time" timeStyle="short"/></p>

	<%-- type 속성값이 both인 경우 "yyyy.M.d a h:mm:ss" 형태로 변환되어 출력 -  --%>
	<p>now(날짜와 시간) = <fmt:formatDate value="${now }" type="both"/></p>
	<p>now(날짜와 시간) = <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/></p>
	<p>now(날짜와 시간) = <fmt:formatDate value="${now }" type="both" dateStyle="short" timeStyle="short"/></p>
	
	<%-- pattern 속성 : 날짜와 시간정보를 패턴기호(SimpleDateFormat 클래스)를 이용하여 변환하기 위한 정보를 속성값으로 설정 --%>
	<p>now(패턴) = <fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm:ss"/>
	<hr>
	
	<%-- timeZone 태그 : 타임존(TimeZone)을 변경하는 태그 --%>
	<%-- value 속성 : 타임존을 속성값으로 설정 --%>
	<fmt:timeZone value="Asia/Hong_Kong">
		<p>현재 홍콩의 날짜와 시간 = <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/></p>
	</fmt:timeZone>	
</body>
</html>
