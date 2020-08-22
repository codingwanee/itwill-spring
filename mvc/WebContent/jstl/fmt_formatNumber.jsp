<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>Formatter - formatNumber 태그</h1>
	<hr>
	<c:set var="price" value="100000000"/>
	<p>가격 = ${price }원</p>	
	
	<%-- formatNumber 태그 : 숫자를 원하는 패턴으로 변환하는 기능을 제공하는 태그 --%>
	<%-- => DecimalFormat 클래스의 역활과 유사한 기능 제공 --%>
	<%-- value 속성 : 변환하고자 하는 숫자(EL)를 속성값으로 설정 --%>
	<%-- type 속성 : 숫자(number) 또는 화폐(currency)를 속성값으로 설정 --%>
	<%-- type 속성값이 number인 경우 숫자 3자리마다 ,로 구분하여 변환 --%>
	<p>가격 = <fmt:formatNumber value="${price }" type="number"/>원</p>
	<%-- type 속성값이 currency인 경우 숫자 3자리마다 ,로 구분하며 앞에 화폐단위를 붙여 변환 --%>
	<p>가격 = <fmt:formatNumber value="${price }" type="currency"/></p>
	<%-- pattern 속성 : 숫자 패턴기호(DecimalFormat 클래스)를 이용하여 변환 --%>
	<p>가격 = <fmt:formatNumber value="${price }" pattern="$###,###,##0.00"/></p>
</body>
</html>