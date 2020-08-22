package site.itwill00.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jHelloWorldMain {
	//Logger �ν��Ͻ� : �α� ������ ���� �ν��Ͻ�
	//LoggerFactory.getLogger(Class<T> clazz) : �޸𸮿� ����� Ŭ����(Clazz)��
	//��� ���� ������ �����ϴ� Logger �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ� 
	private final static Logger logger=LoggerFactory.getLogger(Log4jHelloWorldMain.class);
	
	public static void main(String[] args) {
		//Logger.info(String message) : �α��̺�Ʈ�� �߻��Ͽ� �޼����� �����ϴ� �޼ҵ�
		logger.info("start");
		Log4jHelloWorld hw=new Log4jHelloWorld();
		String message=hw.hello("ȫ�浿");
		System.out.println("message = "+message);
		logger.info("end");
	}
}
