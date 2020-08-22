package site.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAroundAdvice {
	private final static Logger logger=LoggerFactory.getLogger(LoggingAfterAdvice.class);

	//Ⱦ�ܰ��ɸ���� �ٽɰ��ɸ���� ���Ŀ� ���ԵǾ� ����� ��� JoinPoint�� around�� ����
	// => Ⱦ�ܰ��ɸ��� ����� �޼ҵ�� �ݵ�� ��ȯ���� Object�� �ۼ��ϰ� �Ű������� ProceedingJoinPoint�� �ۼ��Ͽ� ����
	// => Throwable Ŭ����(�ֻ��� ����Ŭ����)�� ���޵ǵ��� ����
	//Spring Container�κ��� �ٽɰ��ɸ���� ���޹޾� �Ű������� �ڵ����� ����
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("[around]�ٽɰ��ɸ���� ����Ǳ� ���� ���ԵǾ� ����� Ⱦ�ܰ��ɸ��");
		
		//ProceedingJoinPoint �ν��Ͻ� : �ٽɰ��ɸ���� ������ �����ϴ� �ν��Ͻ�
		//ProceedingJoinPoint.proceed() : �ٽɰ��ɸ���� ȣ���Ͽ� �ٽɰ����ڵ带 �����ϴ� �޼ҵ�
		// => �ٽɰ��ɸ���� �ڵ尡 ����� �� ��ȯ�Ǵ� ����� �����޾� ����
		// => �ٽɰ��ɸ���� �ڵ忡�� ���ܰ� �߻��� ��� ���� ����
		Object object=joinPoint.proceed();

		logger.info("[around]�ٽɰ��ɸ���� ����� �Ŀ� ���ԵǾ� ����� Ⱦ�ܰ��ɸ��");
		return object;
	}
}