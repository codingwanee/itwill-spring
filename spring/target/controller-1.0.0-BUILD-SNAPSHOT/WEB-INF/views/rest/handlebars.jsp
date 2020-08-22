<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- handlebars : JSON 텍스트 데이타를 전달받아 HTML 코드로 변환하는 기능을 제공하는 템플릿 라이브러리 -->
<%-- https://cdnjs.com 사이트에서 handlebars 라이브러리 검색하여 포함 --%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.2.0/handlebars.min.js"></script>
</head>
<body>
	<h1>handlebars</h1>
	<hr>
	<div id="display1"></div>

	<%-- 템플릿 코드(HTML) 작성 --%>
	<%-- {{PropertyName}} : JavaScript 객체의 속성(Property)를 표현하여 속성값을 출력하기 위한 표현식 --%>
	<script id="template1" type="text/x-handlebars-template">
	<ul>
		<li>아이디 = {{id}}</li>
		<li>이름 = {{name}}</li>
		<li>주소 = {{address}}</li>
	</ul>
	</script>
	
	<!-- {{#each .}} 표현식을 이용하여 배열 객체에 대한 반복 처리 -->
	<script id="template2" type="text/x-handlebars-template">
	{{#each .}}
	<ul>
		<li>아이디 = {{id}}</li>
		<li>이름 = {{name}}</li>
		<li>주소 = {{address}}</li>
	</ul>
	{{/each}}
	</script>

	
	<script type="text/javascript">
	/*
	//템플릿 코드를 반환받아 저장
	var source=$("#template1").html();
	//템플릿 코드 전달받아 템플릿 객체를 생성하여 반환받아 저장
	var template=Handlebars.compile(source);
	//출력하고자 하는 JSON으로 표현된 객체 설정
	var data={id:"abc",name:"홍길동",address:"서울시 강남구"};
	*/
	
	var source=$("#template2").html();
	var template=Handlebars.compile(source);
	var data=[{id:"abc",name:"홍길동",address:"서울시 강남구"}
		,{id:"xyz",name:"임꺽정",address:"서울시 종로구"}];
	
	//출력객체를 전달하여 템플릿 코드로 변환된 HTML를 반환받아 출력
	$("#display1").html(template(data));
	</script>	
</body>
</html>