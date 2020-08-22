package site.itwill00.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jHelloWorldMain {
	//Logger 인스턴스 : 로그 전달을 위한 인스턴스
	//LoggerFactory.getLogger(Class<T> clazz) : 메모리에 저장된 클래스(Clazz)의
	//기록 관련 정보를 전달하는 Logger 인스턴스를 반환하는 메소드 
	private final static Logger logger=LoggerFactory.getLogger(Log4jHelloWorldMain.class);
	
	public static void main(String[] args) {
		//Logger.info(String message) : 로그이벤트를 발생하여 메세지를 전달하는 메소드
		logger.info("start");
		Log4jHelloWorld hw=new Log4jHelloWorld();
		String message=hw.hello("홍길동");
		System.out.println("message = "+message);
		logger.info("end");
	}
}
