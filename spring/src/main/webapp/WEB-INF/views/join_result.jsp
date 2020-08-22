<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>회원가입 정보 확인</h1>
	<hr>
	<ul>
		<%-- 
		<li>아이디 = ${id }</li>
		<li>비밀번호 = ${passwd }</li>
		<li>이름 = ${name }</li>
		<li>이메일 = ${email }</li>
		<li>전화번호 = ${phone1 } - ${phone2 } - ${phone3 }</li>
		--%>
		
		<%-- Map 인스턴스를 공유한 경우 Map 인스턴스의 Key를 이용하여 Value 출력 --%>
		<%-- => MapKey는 반드시 입력태그의 name 속성값과 동일하게 설정 --%>
		<%-- 
		<li>아이디 = ${memberMap.id }</li>
		<li>비밀번호 = ${memberMap.passwd }</li>
		<li>이름 = ${memberMap.name }</li>
		<li>이메일 = ${memberMap.email }</li>
		<li>전화번호 = ${memberMap.phone1 } - ${memberMap.phone2 } - ${memberMap.phone3 }</li>
		--%>
		
		<%-- JavaBean 인스턴스를 공유한 경우 필드명을 이용하여 필드값 출력 --%>
		<%-- 
		<li>아이디 = ${member.id }</li>
		<li>비밀번호 = ${member.passwd }</li>
		<li>이름 = ${member.name }</li>
		<li>이메일 = ${member.email }</li>
		<li>전화번호 = ${member.phone1 } - ${member.phone2 } - ${member.phone3 }</li>
		--%>

		<li>아이디 = ${mem.id }</li>
		<li>비밀번호 = ${mem.passwd }</li>
		<li>이름 = ${mem.name }</li>
		<li>이메일 = ${mem.email }</li>
		<li>전화번호 = ${mem.phone1 } - ${mem.phone2 } - ${mem.phone3 }</li>
	</ul>
</body>
</html>