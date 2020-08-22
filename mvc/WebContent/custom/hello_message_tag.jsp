<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="simple" uri="http://www.itwill.site/mvc/simple" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Custom Tag - Attribute and NoBody</h1>
	<hr>
	<%-- 커스텀 태그의 속성이 생략된 경우 태그 클래스의 생성자에서 설정한 초기값을 필드에 저장 --%>
	<%-- => 필수 속성으로 설정된 경우 속성이 생략되면 에러 발생 --%>
	<%-- <simple:helloMessage/> --%>
	<simple:helloMessage name="홍길동"/>
	
	<%-- 커스텀 태그의 속성을 사용할 경우 태그 클래스의 setter 메소드가 호출되어 속성값을 필드에 저장 --%>
	<simple:helloMessage name="임꺽정"/>
</body>
</html>