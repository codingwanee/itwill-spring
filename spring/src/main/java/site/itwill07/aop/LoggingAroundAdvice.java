package site.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAroundAdvice {
	private final static Logger logger=LoggerFactory.getLogger(LoggingAfterAdvice.class);

	//횡단관심모듈이 핵심관심모듈의 전후에 삽입되어 실행될 경우 JoinPoint를 around로 설정
	// => 횡단관심모듈로 선언된 메소드는 반드시 반환형을 Object로 작성하고 매개변수를 ProceedingJoinPoint로 작성하여 선언
	// => Throwable 클래스(최상위 예외클래스)를 전달되도록 선언
	//Spring Container로부터 핵심관심모듈을 전달받아 매개변수에 자동으로 저장
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("[around]핵심관심모듈이 실행되기 전에 삽입되어 실행될 횡단관심모듈");
		
		//ProceedingJoinPoint 인스턴스 : 핵심관심모듈의 정보를 저장하는 인스턴스
		//ProceedingJoinPoint.proceed() : 핵심관심모듈을 호출하여 핵심관심코드를 실행하는 메소드
		// => 핵심관심모듈의 코드가 실행된 후 반환되는 결과를 제공받아 저장
		// => 핵심관심모듈의 코드에서 예외가 발생될 경우 예외 전달
		Object object=joinPoint.proceed();

		logger.info("[around]핵심관심모듈이 실행된 후에 삽입되어 실행될 횡단관심모듈");
		return object;
	}
}