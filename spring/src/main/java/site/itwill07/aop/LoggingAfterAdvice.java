package site.itwill07.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAfterAdvice {
	private final static Logger logger=LoggerFactory.getLogger(LoggingAfterAdvice.class);

	public void afterReturningLog() {
		logger.info("[after-returning]핵심관심코드가 정상적으로 실행된 후 삽입되어 실행될 횡단관심코드");
	}
	
	public void afterThrowingLog() {
		logger.info("[after-throwing]핵심관심코드 실행시 예외가 발생된 경우 삽입되어 실행될 횡단관심코드");
	}
	
	public void afterLog() {
		logger.info("[after]핵심관심코드 실행후 무조건 삽입되어 실행될 횡단관심코드");
	}
}
