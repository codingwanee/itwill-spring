package site.itwill06.oop;

//인터페이스를 상속받아 작성된 오버라이드 메소드에 횡단관심코드 삽입되도록 설정 - PointCut
public class AopOne implements AopInterface {
	@Override
	public void display1() {
		//횡단관심코드 : 로그, 보안, 트렌젝션, 예외처리등을 구현하기 위한 명령 
		//System.out.println("### 메소드의 명령 실행 전 콘솔 로그 기록 ###");
		//핵심관심코드 : 메소드 호출로 얻을 수 있는 기능을 구현하기 위한 명령
		System.out.println("*** AopOne 클래스의 display1() 메소드 호출 *** ");
	}

	@Override
	public void display2() {
		//System.out.println("### 메소드의 명령 실행 전 콘솔 로그 기록 ###");
		System.out.println("*** AopOne 클래스의 display2() 메소드 호출 *** ");
	}

	@Override
	public void display3() {
		//System.out.println("### 메소드의 명령 실행 전 콘솔 로그 기록 ###");
		System.out.println("*** AopOne 클래스의 display3() 메소드 호출 *** ");
	}
}
