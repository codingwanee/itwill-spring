package site.itwill10.exception;

import site.itwill10.dto.Userinfo;

//아이디의 회원정보가 테이블에 이미 저장되어 있을 경우 발생되는 예외클래스
// => 회원정보 저장에 대한 기능을 구현할 때 예외 발생
public class UserinfoExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	
	//ExceptionHandler에게 예외 관련 정보를 전달하기 위한 필드
	private Userinfo userinfo;	
	
	public UserinfoExistsException() {
		// TODO Auto-generated constructor stub
	}
	
	public UserinfoExistsException(Userinfo userinfo,String message) {
		super(message);
		this.userinfo=userinfo;
	}

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
}
