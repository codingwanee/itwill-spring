<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<h1>AJAX 요청과 JSON 응답</h1>
	<hr>
	<div id="display"></div>
	
	<script type="text/javascript">
	$.ajax({
		type: "GET",
		url: "json_list",
		dataType: "json",
		success:function(json) {
			/*
			var count=$(json).size();
			$("#display").text(count+"명의 회원정보를 검색 하였습니다.");
			*/
			
			var html="<ul>";
			$(json).each(function(){
				html+="<li>아이디 = "+this.id+
					", 이름 = "+this.name+", 주소 = "+this.address+"</li>"
			});			
			
			$("#display").html(html);
		},
		error:function(req) {
			$("#display").text("응답오류 = "+req.status);
		}
	});
	</script>
</body>
</html>









