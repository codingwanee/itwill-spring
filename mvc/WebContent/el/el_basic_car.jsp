<%@page import="site.itwill.el.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//생성자의 파라메터에 값을 전달하여 인스턴스 필드에 초기값 부여
	//Car car=new Car("싼타페","하얀색");

	//기본 생성자를 이용하여 인스턴스 생성 후 Setter 메소드를 호출하여 필드값 변경
	Car car=new Car();
	car.setName("싼타페");
	car.setColor("하얀색");
	
	pageContext.setAttribute("car", car);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL(Expression Language)</h1>
	<hr>
	<h2>EL 미사용</h2>
	<%
		Car pageCar=(Car)pageContext.getAttribute("car");
		//공유속성명의 인스턴스가 존재하지 않으므로 null 값이 반환되어 저장
		//Car pageCar=(Car)pageContext.getAttribute("pageCar");
	
		//Getter 메소드를 호출하여 인스턴스 필드값을 반환받아 저장
		//참조변수에 null 값이 저장되어 있는 경우 메소드 호출시 NullPointerException 발생
		String name=pageCar.getName();
		String color=pageCar.getColor();
	%>
	<p>car = <%=pageCar %></p>	
	<p>모델명 = <%=name %></p>	
	<p>색상 = <%=color %></p>	
	<hr>
	<h2>EL 사용</h2>
	<p>car = ${car }</p>	
	<%-- ${공유속성명.필드명} 형식으로 공유 인스턴스(Bean)의 필드값을 반환받아 출력 --%>
	<%-- => getAttribute() 메소드와 Getter 메소드가 자동 호출 --%>
	<%-- => Bean 클래스의 Getter 메소드를 규칙에 따라 작성하지 않은 경우 호출 에러 발생 --%>
	<p>모델명 = ${car.name }</p>	
	<p>색상 = ${car.color }</p>	
	<%-- 공유 인스턴스가 존재하지 않을 경우 미출력 - NullPointerExcetion 미발생 --%>
	<p>모델명 = ${pageCar.name }</p>	
</body>
</html>







