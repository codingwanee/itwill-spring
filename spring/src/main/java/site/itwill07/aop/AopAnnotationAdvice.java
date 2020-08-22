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
//@Aspect : Spring Bean���� ��ϵ� Ŭ������ Aspect ����� �����ϱ� ���� ������̼�
// => Bean Configuration File�� aspect ������Ʈ�� ������ ��Ȱ�� ����
@Aspect
public class AopAnnotationAdvice {
	private final static Logger logger=LoggerFactory.getLogger(AopAnnotationAdvice.class); 	
	
	//@Pointcut : Pointcut�� �����ϱ� ���� ������̼�
	// => Bean Configuration File�� pointcut ������Ʈ�� ������ ��Ȱ�� ����
	// => Pointcut�� ������ ���� �����ϸ� �޼ҵ��� �Ű������� Pointcut�� ���������� ���
	//value �Ӽ� : Pointcut ������ ���� ����(execution �Ǵ� within)�� �Ӽ������� ����
	@Pointcut(value = "within(site.itwill07.aop.AopAnnotationBean)")
	public void aopPointcut() {}
	
	//@Before : JoinPoint�� before�� �޼ҵ带 �����ϴ� ������̼� - Before Advice Method
	// => Bean Configuration File�� before ������Ʈ�� ������ ��Ȱ�� ����
	//value �Ӽ� : Pointcut ������ ���� ����(execution �Ǵ� within)�� �Ӽ������� ����
	//@Before(value = "within(site.itwill07.aop.AopAnnotationBean)")
	//value �Ӽ������� @Pointcut ������̼����� ������ �޼ҵ��� �Ű������� ��� ���
	@Before(value = "aopPointcut()")
	public void beforeLog() {
		logger.info("[before]�ٽɰ����ڵ� ���� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	}
	
	//@AfterReturning : JoinPoint�� after-returning�� �޼ҵ带 �����ϴ� ������̼� - AfterReturning Advice Method
	// => Bean Configuration File�� after-returning ������Ʈ�� ������ ��Ȱ�� ����
	// => value �Ӽ� ��� pointcut �Ӽ� ��� ����
	//returning �Ӽ� : �ٽɰ��ɸ���� ��ȯ���� �����Ͽ� �����ϱ� ���� �Ű��������� �Ӽ������� ����
	@AfterReturning(value = "aopPointcut()",returning = "object")
	public void afterReturningLog(Object object) {
		logger.info("[after-returning]�ٽɰ����ڵ尡 ���������� ����� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	}
	
	//@AfterThrowing : JoinPoint�� after-throwing�� �޼ҵ带 �����ϴ� ������̼� - AfterThrowing Advice Method
	// => Bean Configuration File�� after-throwing ������Ʈ�� ������ ��Ȱ�� ����
	// => value �Ӽ� ��� pointcut �Ӽ� ��� ����
	//throwing �Ӽ� : �ٽɰ��ɸ�� ����� �߻��� ���������� �����Ͽ� ������ �Ű��������� �Ӽ������� ����
	@AfterThrowing(pointcut = "aopPointcut()", throwing = "exception")
	public void afterThrowingLog(Exception exception) {
		logger.info("[after-throwing]�ٽɰ����ڵ� ����� ���ܰ� �߻��� ��� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	}

	//@After : JoinPoint�� after�� �޼ҵ带 �����ϴ� ������̼� - After Advice Method
	// => Bean Configuration File�� after ������Ʈ�� ������ ��Ȱ�� ����
	@After(value = "aopPointcut()")
	public void after() {
		logger.info("[after]�ٽɰ����ڵ� ���� �� ������ ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	}

	//@After : JoinPoint�� around�� �޼ҵ带 �����ϴ� ������̼� - Around Advice Method
	// => Bean Configuration File�� around ������Ʈ�� ������ ��Ȱ�� ����
	@Around(value = "aopPointcut()")
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("[around]�ٽɰ����ڵ� ���� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
		Object object=joinPoint.proceed();
		logger.info("[around]�ٽɰ����ڵ� ���� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
		return object;
	}
}







