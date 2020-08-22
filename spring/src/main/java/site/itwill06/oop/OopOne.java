package site.itwill06.oop;

public class OopOne {
	//메소드에 중복된 명령(코드)가 존재할 경우 중복코드가 선언된 메소드를 
	//선언하여 중복코드 대신 메소드를 호출하여 사용
	// => 중복코드를 최소화하여 유지보수의 효율성 증가
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
		System.out.println("*** OopOne 클래스의 display1() 메소드 호출 *** ");
	}
	
	public void display2() {
		//System.out.println("### 메소드의 명령 실행 전 콘솔 로그 기록 ###");
		//beforeLog();
		logger.beforeLog();		
		System.out.println("*** OopOne 클래스의 display2() 메소드 호출 *** ");
	}
	
	public void display3() {
		//System.out.println("### 메소드의 명령 실행 전 콘솔 로그 기록 ###");
		//beforeLog();
		logger.beforeLog();		
		System.out.println("*** OopOne 클래스의 display3() 메소드 호출 *** ");
	}
}
