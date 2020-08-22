<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>회원상세</h1>
	<hr>
	<div>
		아이디 = ${member.id }, 비밀번호 = ${member.passwd }
			, 이름 = ${member.name }, 이메일 = ${member.email }
	</div>
	
</body>
</html>