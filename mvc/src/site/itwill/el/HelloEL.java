package site.itwill.el;

//EL 함수로 사용하기 위한 메소드를 선언한 클래스
public class HelloEL {
	//EL 함수는 반드시 정적 메소드 선언
	public static String hello(String name) {
		return name+"님 안녕하세요.";
	}
}
