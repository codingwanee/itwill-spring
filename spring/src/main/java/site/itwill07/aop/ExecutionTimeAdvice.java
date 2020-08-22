package site.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

public class ExecutionTimeAdvice {
	private final static Logger logger=LoggerFactory.getLogger(ExecutionTimeAdvice.class);
	
	//�ٽɰ��ɸ��(Ÿ�ٸ޼ҵ�)�� ����� ����� ��� ó���ð�(ms)�� ����Ͽ� ����ϱ� ���� �޼ҵ� - around
	public Object timeWatch(ProceedingJoinPoint joinPoint) throws Throwable {
		/*
		//�ٽɰ��ɸ�� ��� ���� ���� �ý����� ���� �ð�����(Timestamp : ms)�� ��ȯ�޾� ����
		long startTime=System.currentTimeMillis();
		
		//�ٽɰ��ɸ�� ȣ�� - Ÿ�ٸ޼ҵ��� ��� ����
		Object object=joinPoint.proceed();
		
		//�ٽɰ��ɸ�� ��� ���� �Ŀ� �ý����� ���� �ð������� ��ȯ�޾� ����
		long stopTime=System.currentTimeMillis();
		
		//�ٽɰ��ɸ�� ó���ð� ���
		logger.info("����ð� = "+(stopTime-startTime)+"ms");
		*/

		//StopWatch : �ð��� �����ϱ� ���� ����� �����ϴ� Ŭ����
		StopWatch stopWatch=new StopWatch();
		
		//StopWatch.start() : �ð� ���� ���� �޼ҵ�
		stopWatch.start();
		
		Object object=joinPoint.proceed();

		//StopWatch.stop() : �ð� ���� ���� �޼ҵ�
		stopWatch.stop();
		
		//StopWatch.getTotalTimeMillis() : ������ �ð��� ms ������ ��ȯ�ϴ� �޼ҵ�
		logger.info("����ð� = "+stopWatch.getTotalTimeMillis()+"ms");
		
		//�ٽɰ��ɸ�� ó����� ��ȯ
		return object;
	}
}




