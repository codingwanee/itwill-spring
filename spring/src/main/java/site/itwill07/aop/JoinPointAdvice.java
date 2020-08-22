package site.itwill07.aop;

import org.aspectj.lang.JoinPoint;

public class JoinPointAdvice {
	//before, after-returning, after-throwing, after 위치에 삽입될 횡단관심모듈(메소드)은 
	//일반적으로 반환형을 void로 선언하고 매개변수를 선언하지 않고 작성
	// => 공통적으로 JoinPoint 매개변수를 선언하여 자동으로 정보를 제공받아 사용
	// => 위치(JoinPoint)에 따라 매개변수를 다르게 선언하여 자동으로 정보를 제공받아 사용
	
	//around 위치에 삽입될 횡단관심모듈은 반환형을 Object로 선언하고 ProceedingJointPoint
	//매개변수를 선언하여 핵심관심모듈 정보를 자동으로 제공받아 사용
	// => 핵심관심모듈에서 발생되는 예외를 외부로 전달하도록 선언
	
	//핵심관심모듈의 명령이 실행되기 전에 삽입되어 실행될 메소드 - before
	// => JoinPoint 매개변수를 선언하여 핵심관심모듈 정보를 전달받아 사용
	public void displayTarget(JoinPoint joinPoint) {
		//System.out.println("[before]핵심관심코드 실행 전에 삽입되어 동작될 횡단관심코드");
		
		//JoinPoint.getTarget() : 핵심관심모듈이 선언된 클래스를 Object 타입으로 반환하는 메소드
		//Object.getClass() : 메모리에 저장된 클래스(Clazz)를 반환하는 메소드 - 리플렉션 기능
		//Class.getName() : 메모리에 저장된 클래스(Clazz)의 패키지가 포함된 클래스이름을 반환하는 메소드
		//String className=joinPoint.getTarget().getClass().getName();
		//Class.getSimpleName() : 메모리에 저장된 클래스(Clazz)의 클래스이름을 반환하는 메소드
		//String className=joinPoint.getTarget().getClass().getSimpleName();
		//System.out.println("[before]핵심관심모듈이 선언된 클래스 = "+className);
		
		//JoinPoint.getSignature() : Signature 인스턴스(핵심관심모듈 특징정보)를 반환받는 메소드
		//Signature.getName() : 핵심관심모듈의 이름을 반환하는 메소드
		//String methodName=joinPoint.getSignature().getName();
		//System.out.println("[before]핵심관심모듈의 이름 = "+methodName);
		
		//JoinPoint.getArgs() : 핵심관심모듈의 매개변수들을 Object 배열로 반환하는 메소드
		Object[] objects=joinPoint.getArgs();
		System.out.println("[before]핵심관심모듈의 매개변수 갯수 = "+objects.length);
	}
	
	//핵심관심모듈의 명령이 정상적으로 실행된 후 삽입되어 실행될 메소드 - after-returning
	// => JoinPoint 매개변수를 선언하여 핵심관심모듈 정보를 전달받아 사용
	// => Object 매개변수를 선언하여 핵심관심모듈의 반환값을 전달받아 사용 
	// => after-returning 엘리먼트의 returning 속성을 반드시 설정하여 반환값을 전달받아 저장
	public void displayName(Object object) {
		//System.out.println("[after-returning]핵심관심코드가 정상적으로 실행된 후 삽입되어 동작될 횡단관심코드");
		
		if(object instanceof String) {
			String name=(String)object;
			System.out.println("[after-returning]"+name+"님 환영합니다.");
		}
	}
	
	//핵심관심모듈의 명령 실행시 예외가 발생된 경우 삽입되어 실행될 메소드 - after-throwing
	// => JoinPoint 매개변수를 선언하여 핵심관심모듈 정보를 전달받아 사용
	// => Excption 매개변수를 선언하여 예외정보를 전달받아 사용 - throwing 속성
	// => after-throwing 엘리먼트의 throwing 속성을 반드시 설정하여 예외를 전달받아 저장
	public void displayException(Exception exception) {
		//System.out.println("[after-throwing]핵심관심코드 실행시 예외가 발생된 경우 삽입되어 동작될 횡단관심코드");
		
		System.out.println("[after-throwing]예외 발생 = "+exception.getMessage());
	}
}
