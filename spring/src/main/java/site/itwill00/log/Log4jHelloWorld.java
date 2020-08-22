package site.itwill00.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jHelloWorld {
	private final static Logger logger=LoggerFactory.getLogger(Log4jHelloWorld.class);

	public String hello(String name) {
		logger.info("start");
		String message="Hello. "+name+"!!!";
		logger.info("end");
		return message;
	}
}
