package site.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
//@Aspect : Spring Bean으로 등록된 클래스에 Aspect 기능을 제공하기 위한 어노테이션
// => Bean Configuration File의 aspect 엘리먼트와 동일한 역활을 수행
@Aspect
public class AopAnnotationAdvice {
	private final static Logger logger=LoggerFactory.getLogger(AopAnnotationAdvice.class); 	
	
	//@Pointcut : Pointcut를 설정하기 위한 어노테이션
	// => Bean Configuration File의 pointcut 엘리먼트와 동일한 역활을 수행
	// => Pointcut의 재사용을 위해 설정하며 메소드명과 매개변수를 Pointcut의 고유값으로 사용
	//value 속성 : Pointcut 지정을 위한 정보(execution 또는 within)를 속성값으로 설정
	@Pointcut(value = "within(site.itwill07.aop.AopAnnotationBean)")
	public void aopPointcut() {}
	
	//@Before : JoinPoint가 before인 메소드를 설정하는 어노테이션 - Before Advice Method
	// => Bean Configuration File의 before 엘리먼트와 동일한 역활을 수행
	//value 속성 : Pointcut 지정을 위한 정보(execution 또는 within)를 속성값으로 설정
	//@Before(value = "within(site.itwill07.aop.AopAnnotationBean)")
	//value 속성값으로 @Pointcut 어노테이션으로 설정된 메소드명과 매개변수를 대신 사용
	@Before(value = "aopPointcut()")
	public void beforeLog() {
		logger.info("[before]핵심관심코드 실행 전 삽입되어 실행될 횡단관심코드");
	}
	
	//@AfterReturning : JoinPoint가 after-returning인 메소드를 설정하는 어노테이션 - AfterReturning Advice Method
	// => Bean Configuration File의 after-returning 엘리먼트와 동일한 역활을 수행
	// => value 속성 대신 pointcut 속성 사용 가능
	//returning 속성 : 핵심관심모듈의 반환값을 전달하여 저장하기 위한 매개변수명을 속성값으로 설정
	@AfterReturning(value = "aopPointcut()",returning = "object")
	public void afterReturningLog(Object object) {
		logger.info("[after-returning]핵심관심코드가 정상적으로 실행된 후 삽입되어 실행될 횡단관심코드");
	}
	
	//@AfterThrowing : JoinPoint가 after-throwing인 메소드를 설정하는 어노테이션 - AfterThrowing Advice Method
	// => Bean Configuration File의 after-throwing 엘리먼트와 동일한 역활을 수행
	// => value 속성 대신 pointcut 속성 사용 가능
	//throwing 속성 : 핵심관심모듈 실행시 발생된 예외정보를 전달하여 저장할 매개변수명을 속성값으로 설정
	@AfterThrowing(pointcut = "aopPointcut()", throwing = "exception")
	public void afterThrowingLog(Exception exception) {
		logger.info("[after-throwing]핵심관심코드 실행시 예외가 발생된 경우 삽입되어 실행될 횡단관심코드");
	}

	//@After : JoinPoint가 after인 메소드를 설정하는 어노테이션 - After Advice Method
	// => Bean Configuration File의 after 엘리먼트와 동일한 역활을 수행
	@After(value = "aopPointcut()")
	public void after() {
		logger.info("[after]핵심관심코드 실행 후 무조건 삽입되어 실행될 횡단관심코드");
	}

	//@After : JoinPoint가 around인 메소드를 설정하는 어노테이션 - Around Advice Method
	// => Bean Configuration File의 around 엘리먼트와 동일한 역활을 수행
	@Around(value = "aopPointcut()")
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("[around]핵심관심코드 실행 전 삽입되어 실행될 횡단관심코드");
		Object object=joinPoint.proceed();
		logger.info("[around]핵심관심코드 실행 후 삽입되어 실행될 횡단관심코드");
		return object;
	}
}







