package site.itwill06.oop;

public class OopTwo {
	/*
	public void beforeLog() {
		System.out.println("### 메소드의 명령 실행 전 콘솔 로그 기록 ###");
	}
	*/
	
	private OopLogger logger=new OopLogger();//포함
	
	public void display1() {
		//System.out.println("### 메소드의 명령 실행 전 콘솔 로그 기록 ###");
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopTwo 클래스의 display1() 메소드 호출 *** ");
	}
	
	public void display2() {
		//System.out.println("### 메소드의 명령 실행 전 콘솔 로그 기록 ###");
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopTwo 클래스의 display2() 메소드 호출 *** ");
	}
	
	public void display3() {
		//System.out.println("### 메소드의 명령 실행 전 콘솔 로그 기록 ###");
		//beforeLog();
		logger.beforeLog();
		System.out.println("*** OopTwo 클래스의 display3() 메소드 호출 *** ");
	}	
}
