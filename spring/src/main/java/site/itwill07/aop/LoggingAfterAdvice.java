package site.itwill07.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAfterAdvice {
	private final static Logger logger=LoggerFactory.getLogger(LoggingAfterAdvice.class);

	public void afterReturningLog() {
		logger.info("[after-returning]�ٽɰ����ڵ尡 ���������� ����� �� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	}
	
	public void afterThrowingLog() {
		logger.info("[after-throwing]�ٽɰ����ڵ� ����� ���ܰ� �߻��� ��� ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	}
	
	public void afterLog() {
		logger.info("[after]�ٽɰ����ڵ� ������ ������ ���ԵǾ� ����� Ⱦ�ܰ����ڵ�");
	}
}
