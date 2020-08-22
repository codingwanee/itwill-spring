package site.itwill.dto;

import java.util.List;

//MYCOMMENT 테이블과 MYUSER 테이블, MYREPLY 테이블의 검색 결과를 저장하기 위한 자바빈 클래스
public class MyCommentUserReplyUser {
	//MYCOMMENT 테이블의 게시글번호를 저장하기 위한 필드
	private int commentNo;
	
	//MYCOMMENT 테이블의 게시글 정보를 저장하기 위한 필드 - 포함 인스턴스
	private MyComment1 comment;
	
	//MYUSER 테이블의 회원정보(게시글 작성자)를 저장하기 위한 필드 - 포함 인스턴스
	private MyUser user;
	
	//MYREPLY 테이블의 댓글목록을 저장하기 위한 필드 - List 인스턴스
	// => 댓글정보(MYREPLY 테이블)과 회원정보(MYUSER 테이블 - 댓글 작성자)를 요소로 저장 
	private List<MyReplyUser> replies;
	
	public MyCommentUserReplyUser() {
		// TODO Auto-generated constructor stub
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public MyComment1 getComment() {
		return comment;
	}

	public void setComment(MyComment1 comment) {
		this.comment = comment;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	public List<MyReplyUser> getReplies() {
		return replies;
	}

	public void setReplies(List<MyReplyUser> replies) {
		this.replies = replies;
	}
}





