package site.itwill.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//모든 모델(Model) 클래스가 반드시 상속 받아야 되는 인터페이스
// => 인터페이스의 추상메소드를 오버라이드 선언하여 요청 처리 메소드의 작성규칙을 제공
// => 부모 인터페이스의 참조변수에 모든 자식 클래스의 인스턴스 저장
// => 인터페이스를 이용하여 자식클래스의 오버라이드 선언된 메소드 호출
public interface Action {
	//요청을 처리하고 응답 결과를 반환받아 메소드
	ActionForward execute(HttpServletRequest request, HttpServletResponse response);
}
