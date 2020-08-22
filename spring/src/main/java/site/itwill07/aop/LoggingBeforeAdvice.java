package site.itwill07.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//횡단관심모듈(횡단관심코드가 작성된 메소드)이 선언된 클래스 - Advice 클래스 
// => 핵심관심코드 앞부분에 삽입될 횡단관심코드가 선언된 메소드 작성
public class LoggingBeforeAdvice {
	private final static Logger logger=LoggerFactory.getLogger(LoggingBeforeAdvice.class);
	
	public void beforeLog() {
		logger.info("[before]핵심관심코드 실행전 삽입되어 실행되는 횡단관심코드");
	}
}
