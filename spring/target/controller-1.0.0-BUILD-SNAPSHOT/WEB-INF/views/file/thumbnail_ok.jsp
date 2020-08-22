<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- Spring Framework에서 제공하는 태그 라이브러리 포함 --%>    
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>이미지 파일 업로드 및 변환 성공</h1>
	<hr>
	<p>업로드 파일명 = ${imageFilename }</p>
	<p>썸네일 파일명 = ${thumbnailFilename }</p>
	<hr>
	<%-- 
	<img src="file/${imageFilename }" width="400">
	<img src="file/${thumbnailFilename }">
	--%>
	
	<%-- 
	<img src="${pageContext.servletContext.contextPath }/file/${imageFilename }" width="400">
	<img src="${pageContext.servletContext.contextPath }/file/${thumbnailFilename }">
	--%>
	
	<%-- Spring 태그 라이브러리의 url 태그를 이용하여 컨텍스트가 포함된 절대경로로 표현 --%>
	<%-- => Core 태그 라이브러리의 url 태그와 유사 --%>
	<img src="<spring:url value='/file/${imageFilename }'/>"  width="400">
	<img src="<spring:url value='/file/${thumbnailFilename }'/>">
</body>
</html>








