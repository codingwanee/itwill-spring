package site.itwill.exception;

//아이디에 대한 회원정보가 존재하지 않을 경우 발생되는 예외클래스
public class UserinfoNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public UserinfoNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public UserinfoNotFoundException(String message) {
		super(message);
	}
}
