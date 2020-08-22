<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("first", 20);
	request.setAttribute("second", 10);
	request.setAttribute("num", 15);
	
	Object object=null;
	request.setAttribute("object", object);
	
	String string="";
	request.setAttribute("string", string);
	
	String[] array={};
	request.setAttribute("array", array);
	
	List<String> list=new ArrayList<String>();
	request.setAttribute("list", list);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<h1>EL Operator</h1>
	<hr>
	<ul>
		<li>first = ${first }</li>
		<li>second = ${second }</li>
		<li>first * second = ${first * second }</li>
		<li>first / second = ${first / second }</li>
		<li>first div second = ${first div second }</li>
		<li>first % second = ${first % second }</li>
		<li>first mod second = ${first mod second }</li>
		<li>first + second = ${first + second }</li>
		<li>first - second = ${first - second }</li>
		<li>first &gt; second = ${first > second }</li>		
		<li>first gt second = ${first gt second }</li>		
		<li>first &lt; second = ${first < second }</li>		
		<li>first lt second = ${first lt second }</li>		
		<li>first &gt;= second = ${first >= second }</li>		
		<li>first ge second = ${first ge second }</li>		
		<li>first &lt;= second = ${first <= second }</li>		
		<li>first le second = ${first le second }</li>		
		<li>first == second = ${first == second }</li>		
		<li>first eq second = ${first eq second }</li>		
		<li>first != second = ${first != second }</li>		
		<li>first ne second = ${first ne second }</li>		
		<li>num = ${num }</li>
		<li>first &gt; num && second &lt; num = ${first > num && second < num}</li>
		<li>first gt num and second lt num = ${first gt num and second lt num}</li>
		<li>first &lt; num || second &gt; num = ${first < num || second > num }</li>
		<li>first lt num or second gt num = ${first lt num or second gt num }</li>
		<%-- empty 연산자 : 공유 인스턴스가 없거나 비어있는 경우 true를 제공하는 연산자 --%>
		<li>object Empty = ${empty(object) }</li>
		<li>string Empty = ${empty(string) }</li>
		<li>array Empty = ${empty(array) }</li>
		<li>list Empty = ${empty(list) }</li>
	</ul>
</body>
</html>