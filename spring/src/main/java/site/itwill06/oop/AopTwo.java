package site.itwill06.oop;

public class AopTwo implements AopInterface {
	@Override
	public void display1() {
		//System.out.println("### 메소드의 명령 실행 전 콘솔 로그 기록 ###");
		System.out.println("*** AopTwo 클래스의 display1() 메소드 호출 *** ");
	}

	@Override
	public void display2() {
		//System.out.println("### 메소드의 명령 실행 전 콘솔 로그 기록 ###");
		System.out.println("*** AopTwo 클래스의 display2() 메소드 호출 *** ");
	}

	@Override
	public void display3() {
		//System.out.println("### 메소드의 명령 실행 전 콘솔 로그 기록 ###");
		System.out.println("*** AopTwo 클래스의 display3() 메소드 호출 *** ");
	}
}
