package site.itwill.exception;

//사용자 정의 예외클래스 : 개발자가 예외처리를 위해 작성한 클래스
//아이디에 대한 회원정보가 존재할 경우 발생되는 예외클래스
public class ExistsUserinfoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ExistsUserinfoException() {
		// TODO Auto-generated constructor stub
	}
	
	public ExistsUserinfoException(String message) {
		super(message);
	}
	
}
