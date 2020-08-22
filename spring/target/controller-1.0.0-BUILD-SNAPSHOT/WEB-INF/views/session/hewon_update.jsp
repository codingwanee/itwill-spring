<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>회원정보변경</h1>
	<hr>
	<form action="hewon_update" method="post">
	<%-- <input type="hidden" name="id" value="${hewon.id }"> --%>
	<table>
		<tr>
			<td>아이디</td>
			<td>${hewon.id }</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="passwd"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="${hewon.name }"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email" value="${hewon.email }"></td>
		</tr>
		<tr>
			<td>성별</td>
			<td>
				남자<input type="radio" name="gender" value="남자" checked>
				여자<input type="radio" name="gender" value="여자">
			</td>
		</tr>
		<tr>
			<td colspan="2"><button type="submit">회원변경</button>
		</tr>
	</table>
	</form>
</body>
</html>