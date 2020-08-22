package site.itwill07.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Ⱦ�ܰ��ɸ��(Ⱦ�ܰ����ڵ尡 �ۼ��� �޼ҵ�)�� ����� Ŭ���� - Advice Ŭ���� 
// => �ٽɰ����ڵ� �պκп� ���Ե� Ⱦ�ܰ����ڵ尡 ����� �޼ҵ� �ۼ�
public class LoggingBeforeAdvice {
	private final static Logger logger=LoggerFactory.getLogger(LoggingBeforeAdvice.class);
	
	public void beforeLog() {
		logger.info("[before]�ٽɰ����ڵ� ������ ���ԵǾ� ����Ǵ� Ⱦ�ܰ����ڵ�");
	}
}
