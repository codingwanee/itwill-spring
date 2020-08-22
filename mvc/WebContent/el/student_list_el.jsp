<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL - List</h1>
	<hr>
	<h2>1번째 학생정보</h2>
	<ul>
		<li>학번 = ${studentList[0]["num"] }</li>
		<li>이름 = ${studentList[0]["name"] }</li>
	</ul>
	<hr>
	<h2>2번째 학생정보</h2>
	<ul>
		<li>학번 = ${studentList[1].num }</li>
		<li>이름 = ${studentList[1].name}</li>
	</ul>
	<hr>
	<h2>3번째 학생정보</h2>
	<ul>
		<li>학번 = ${studentList[2].num }</li>
		<li>이름 = ${studentList[2].name}</li>
	</ul>
	<hr>
	<h2>4번째 학생정보</h2>
	<ul>
		<li>학번 = ${studentList[3].num }</li>
		<li>이름 = ${studentList[3].name}</li>
	</ul>
	<hr>
	<h2>5번째 학생정보</h2>
	<ul>
		<li>학번 = ${studentList[4].num }</li>
		<li>이름 = ${studentList[4].name}</li>
	</ul>			
</body>
</html>