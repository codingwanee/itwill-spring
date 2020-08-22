<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSP 문서에서 tld 파일에 등록된 커스텀 태그를 사용하고자 할 경우 taglib Directive 선언 --%>
<%-- => prefix 속성 : 태그에 대한 접두사(NameSpace)를 속성값으로 설정  --%>    
<%-- => uri 속성 : tld 파일에서 설정한 uri 엘리먼트값을 속성값으로 설정  --%>    
<%@taglib prefix="simple" uri="http://www.itwill.site/mvc/simple"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Custom Tag - NoAttribute and NoBody</h1>
	<hr>
	<%-- 시작태그와 종료태그 사용 --%>
	<%-- <simple:hello></simple:hello> --%>
	<%-- 시작태그와 종료태그 같이 사용 => 태그 내용이 없는 태그 사용 --%>
	<simple:hello/>
	<simple:hello/>
	<simple:hello/>
	<simple:hello/>
	<simple:hello/>
</body>
</html>




