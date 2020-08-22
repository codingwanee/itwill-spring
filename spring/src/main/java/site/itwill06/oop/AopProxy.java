package site.itwill06.oop;

//Proxy 클래스 : 핵심관심코드에 횡단관심코드가 삽입된 메소드가 선언된 클래스
// => 프로그램에서 호출하여 사용하는 클래스 - Aspect 
public class AopProxy implements AopInterface {
	//횡단관심코드로 작성된 메소드가 선언된 클래스의 인스턴스를 저장하기 위한 필드
	private AopLogger logger;
	
	//핵심관심코드로 작성된 매소드가 선언된 클래스의 인스턴스를 저장하기 위한 필드
	// => 인터페이스를 상속받은 자식클래스의 인스턴스 저장
	private AopInterface target;
	
	public AopProxy(AopInterface target) {
		logger=new AopLogger();
		this.target=target;
	}
	
	//핵심관심코드에 횡단관심코드가 삽입된 메소드 작성 - Weaving
	@Override
	public void display1() {
		//핵심관심코드를 기준으로 원하는 위치에 횡단관심코드를 삽입 - JoinPoint
		logger.beforeLog();//횡단관심코드
		target.display1();//핵심관심코드 - 필드에 저장된 자식 인스턴스에 따라 다른 명령 포함
	}

	@Override
	public void display2() {
		logger.beforeLog();
		target.display2();
	}

	@Override
	public void display3() {
		logger.beforeLog();
		target.display3();
	}

}
