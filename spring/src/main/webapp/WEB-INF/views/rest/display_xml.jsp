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
	<h1>AJAX 요청과 XML 응답</h1>
	<hr>
	<div id="display"></div>
	
	<script type="text/javascript">
	$.ajax({
		type: "GET",
		url: "xml_list",
		dataType: "xml",
		success:function(xml) {
			//var count=$(xml).find("member").size();
			//$("#display").text(count+"명의 회원정보가 검색 되었습니다.");
			
			var html="<ul>";
			$(xml).find("member").each(function() {
				html+="<li>아이디 = "+$(this).find("id").text()+
					", 이름 = "+$(this).find("name").text()+
					", 주소 = "+$(this).find("address").text()+"</li>"
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









