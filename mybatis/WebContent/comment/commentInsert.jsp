<%@page import="site.itwill.dao.MyCommentDAO"%>
<%@page import="site.itwill.dto.MyComment1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	MyComment1 comment=new MyComment1();
	comment.setCommentId("aaa");
	comment.setCommentContent("테스트-1");
	MyCommentDAO.getDAO().insertComment(comment);
	*/
	
	MyComment1 comment1=new MyComment1();
	comment1.setCommentId("bbb");
	comment1.setCommentContent("테스트-2");
	MyCommentDAO.getDAO().insertComment(comment1);
	
	MyComment1 comment2=new MyComment1();
	comment2.setCommentId("ccc");
	comment2.setCommentContent("테스트-3");
	MyCommentDAO.getDAO().insertComment(comment2);
	
	MyComment1 comment3=new MyComment1();
	comment3.setCommentId("aaa");
	comment3.setCommentContent("테스트-4");
	MyCommentDAO.getDAO().insertComment(comment3);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mybatis</title>
</head>
<body>
	<h1>게시글 등록</h1>
	<hr>
	<h3>게시글을 성공적으로 등록 하였습니다.</h3>
</body>
</html>