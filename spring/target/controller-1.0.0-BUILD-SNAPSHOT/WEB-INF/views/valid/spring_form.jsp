<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- Spring Framework에서 제공하는 스프링 폼 태그 라이브러리 포함 --%>    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style type="text/css">
.error { color: red; }
</style>
</head>
<body>
	<h1>회원등록 - Spring(form)</h1>
	<hr>
	<%-- Spring form 태그 : 액션 페이지로 입력값을 전달하는 태그 --%>
	<%-- modelAttribute 속성(필수) : Command 객체를 속성값으로 설정 --%>
	<%-- => 요청처리 메소드에 반드시 Command 객체 선언 --%>
	<%-- => 입력값에 대한 유효성 검사에서 오류가 발생된 경우 입력태그에 기존 입력값을 초기값으로 출력 --%>
	<form:form action="valid_spring" method="post" id="form" modelAttribute="hewon">
	<table>
		<tr>
			<td>아이디</td>
			<%-- Spring input 태그 : 텍스트를 입력받기 위한 태그 --%>
			<%-- path 속성 : HTML 입력태그의 name 속성과 id 속성의 역활 수행 --%>
			<%-- => 유효성 검사에서 오류가 발생된 경우 value 속성의 역활 수행 --%>
			<td><form:input path="id"/></td>
			<%-- Spring errors 태그 : 에러메세지를 출력하는 태그 --%>
			<%-- path 속성 : 속성값과 동일한 필드의 에러메세지 출력 --%>
			<%-- delimiter 속성 : 에러메세지가 여러 개인 경우 메세지를 구분하기 위한 구분자를 속성값으로 설정(기본 : 엔터) --%>
			<td>
				<form:errors path="id" class="error" delimiter=" "/>
				<span id="idMsg" class="error"></span>
			</td>	
		</tr>
		
		<tr>
			<td>비밀번호</td>
			<%-- Spring password 태그 : 텍스트(기호)를 입력받기 위한 태그 --%>
			<td><form:password path="passwd"/></td>
			<td>
				<form:errors path="passwd" class="error"/>
				<span id="passwdMsg" class="error"></span>
			</td>	
		</tr>
		
		<tr>
			<td>이름</td>
			<td><form:input path="name"/></td>
			<td>
				<form:errors path="name" class="error"/>
				<span id="nameMsg" class="error"></span>
			</td>	
		</tr>
		
		<tr>
			<td>이메일</td>
			<td><form:input path="email"/></td>
			<td>
				<form:errors path="email" class="error"/>
				<span id="emailMsg" class="error"></span>
			</td>	
		</tr>
		
		<tr>
			<td>성별</td>
			<td>
				<%-- Spring radiobutton 태그 : 목록 중 하나만 선택하여 입력받기 위한 태그 --%>
				<%-- 
				남자<form:radiobutton path="gender" id="gender1" value="남자" checked="checked"/>
				&nbsp;&nbsp;
				여자<form:radiobutton path="gender" id="gender2" value="여자"/>
				--%>
				
				<%-- Spring radiobuttons 태그 : 목록 중 하나만 선택하여 입력받기 위한 태그 --%>
				<%-- items 속성 : 뷰페이지에 공유된 List 인스턴스를 속성값으로 설정 --%>
				<%-- => 공유된 List 인스턴스의 요소값이 출력값과 입력값으로 자동 설정 --%>
				<%-- => 목록 중 선택 요소를 설정할 수 없으므로 JavaScript를 이용 --%>
				<form:radiobuttons path="gender" items="${genderList }"/>
				
				<%-- Spring select 태그 : 목록 중 하나만 선택하여 입력받기 위한 태그 --%>
				<%-- <form:select path="gender" items="${genderList }"/> --%>				
			</td>
			
			<td>
				<form:errors path="gender" class="error"/>
				<span id="genderMsg" class="error"></span>
			</td>	
		</tr>
		
		<tr>
			<td colspan="3"><button type="submit">회원등록</button>
		</tr>
	</table>
	</form:form>
	
	<script type="text/javascript">
	$("#gender1").prop("checked", true);
	
	/*
	$("#form").submit(function() {
		$(".error").text("");
		
		if($("#id").val()=="") {
			$("#idMsg").text("아이디를 입력해 주세요.");
			$("#id").focus();
			return false;
		}	
		
		var idReg=/^[a-zA-Z]\w{5,19}$/g;
		if(!idReg.test($("#id").val())) {
			$("#idMsg").text("아이디를 형식에 맞게 입력해 주세요.");
			$("#id").focus();
			return false;
		}
		
		if($("#passwd").val()=="") {
			$("#passwdMsg").text("비밀번호를 입력해 주세요.");
			$("#passwd").focus();
			return false;
		}	
		
		var passwdReg=/^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$/g;
		if(!passwdReg.test($("#passwd").val())) {
			$("#passwdMsg").text("비밀번호를 형식에 맞게 입력해 주세요.");
			$("#passwd").focus();
			return false;
		}
		
		if($("#name").val()=="") {
			$("#nameMsg").text("이름을 입력해 주세요.");
			$("#name").focus();
			return false;
		}
		
		var nameReg=/^[가-힣]{2,10}$/g;
		if(!nameReg.test($("#name").val())) {
			$("#nameMsg").text("이름을 형식에 맞게 입력해 주세요.");
			$("#name").focus();
			return false;
		}
		
		if($("#email").val()=="") {
			$("#emailMsg").text("이메일을 입력해 주세요.");
			$("#email").focus();
			return false;
		}
		
		var emailReg=/^([a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+(\.[-a-zA-Z0-9]+)+)*$/g;
		if(!emailReg.test($("#email").val())) {
			$("#emailMsg").text("이메일을 형식에 맞게 입력해 주세요.");
			$("#email").focus();
			return false;
		}
	});
	*/
	</script>	
</body>
</html>
