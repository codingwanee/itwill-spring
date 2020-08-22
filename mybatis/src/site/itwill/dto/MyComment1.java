package site.itwill.dto;

/*
MYCOMMENT 테이블 : 게시글을 저장하기 위한 테이블 - 글번호, 작성자 아이디, 글내용, 작성일자 
 이름              널?       유형            
--------------- -------- ------------- 
COMMENT_NO      NOT NULL NUMBER        
COMMENT_ID               VARCHAR2(20)  
COMMENT_CONTENT          VARCHAR2(100) 
COMMENT_DATE             DATE
*/

public class MyComment1 {
	private int commentNo;
	private String commentId;
	private String commentContent;
	private String commentDate;
	
	public MyComment1() {
		// TODO Auto-generated constructor stub
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
}





