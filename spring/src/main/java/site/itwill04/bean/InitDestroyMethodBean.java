package site.itwill04.bean;

public class InitDestroyMethodBean {
	public InitDestroyMethodBean() {
		System.out.println("### InitDestroyMethodBean 클래스의 기본 생성자 호출 ###");
	}
	
	//인스턴스 생성 후 한번만 자동 호출되어 초기화 작업을 제공하는 메소드
	public void init() {
		System.out.println("*** InitDestroyMethodBean 클래스의 init() 메소드 호출 ***");
	}
	
	public void destroy() {
		System.out.println("*** InitDestroyMethodBean 클래스의 destroy() 메소드 호출 ***");
	}
	
	//인스턴스 소멸 전 한번만 자동 호출되어 마무리 작업을 제공하는 메소드
	public void display() {
		System.out.println("*** InitDestroyMethodBean 클래스의 display() 메소드 호출 ***");
	}
}
