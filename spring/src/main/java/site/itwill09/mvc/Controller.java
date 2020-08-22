package site.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//요청 처리 클래스(Command Controller)가 반드시 상속받아야 되는 인터페이스
// => 인터페이스를 상속받은 자식클래스가 동일한 구조로 작성되도록 선언
// => 모든 자식클래스의 인스턴스 정보를 인터페이스 참조변수에 저장하기 위한 선언 - 다형성
public interface Controller {
	//요청 처리 메소드 - 자식클래스에서 무조건 오버라이드 선언
	// => 응답 페이지(JSP 문서) 정보 반환
	String handleRequest(HttpServletRequest request,HttpServletResponse response) 
		throws ServletException, IOException; 
}
