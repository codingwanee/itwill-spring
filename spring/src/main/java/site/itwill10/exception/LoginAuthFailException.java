package site.itwill10.exception;

//인증 실패될 경우 발생되는 예외클래스
// => 회원정보를 이용한 인증처리 기능을 구현할 때 예외 발생
public class LoginAuthFailException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String userid;
	
	public LoginAuthFailException() {
		// TODO Auto-generated constructor stub
	}

	public LoginAuthFailException(String userid, String message) {
		super(message);
		this.userid = userid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
}
