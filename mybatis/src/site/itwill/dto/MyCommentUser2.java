package site.itwill.dto;

//MYCOMMENT 테이블과 MYUSER 테이블의 검색결과를 저장하기 위한 자바빈 클래스
//=> 1:1 관계의 조인 결과를 저장하기 위한 클래스
public class MyCommentUser2 {
	//검색행의 게시글정보(MYCOMMENT 테이블)를 저장하기 위한 필드
	// => POJO(Plain Old Java Object) : 기존 자바빈 클래스를 재사용하는 방법
	private MyComment1 comment;//포함 인스턴스
	
	//검색행의 회원정보(MYUSER 테이블)를 저장하기 위한 필드
	private MyUser user;
	
	public MyCommentUser2() {
		// TODO Auto-generated constructor stub
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
}
