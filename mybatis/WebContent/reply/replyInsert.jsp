<%@page import="site.itwill.dao.MyReplyDAO"%>
<%@page import="site.itwill.dto.MyReply"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1번 게시글에 대한 댓글
	MyReply reply1=new MyReply();
	reply1.setReplyCommentNo(1);
	reply1.setReplyId("bbb");
	reply1.setReplyContent("1번 게시글에 대한 댓글-1");
	
	MyReply reply2=new MyReply();
	reply2.setReplyCommentNo(1);
	reply2.setReplyId("ccc");
	reply2.setReplyContent("1번 게시글에 대한 댓글-2");

	MyReply reply3=new MyReply();
	reply3.setReplyCommentNo(1);
	reply3.setReplyId("bbb");
	reply3.setReplyContent("1번 게시글에 대한 댓글-3");

	//3번 게시글에 대한 댓글
	MyReply reply4=new MyReply();
	reply4.setReplyCommentNo(3);
	reply4.setReplyId("aaa");
	reply4.setReplyContent("3번 게시글에 대한 댓글-1");
	
	//4번 게시글에 대한 댓글
	MyReply reply5=new MyReply();
	reply5.setReplyCommentNo(4);
	reply5.setReplyId("bbb");
	reply5.setReplyContent("4번 게시글에 대한 댓글-1");
	
	MyReply reply6=new MyReply();
	reply6.setReplyCommentNo(4);
	reply6.setReplyId("ccc");
	reply6.setReplyContent("4번 게시글에 대한 댓글-2");
	
	MyReplyDAO.getDAO().insertReply(reply1);
	MyReplyDAO.getDAO().insertReply(reply2);
	MyReplyDAO.getDAO().insertReply(reply3);
	MyReplyDAO.getDAO().insertReply(reply4);
	MyReplyDAO.getDAO().insertReply(reply5);
	MyReplyDAO.getDAO().insertReply(reply6);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mybatis</title>
</head>
<body>
	<h1>댓글등록</h1>
	<hr>
	<h3>댓글을 성공적으로 등록 하였습니다.</h3>
</body>
</html>
