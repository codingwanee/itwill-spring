package site.itwill03.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Spring Container�� �̿��Ͽ� �ν��Ͻ��� �����޾� ó���ϴ� ���α׷�
// => �����ڰ� �ƴ� Spring Container�� �ν��Ͻ��� �����Ͽ� ��ȯ - IoC : ������ ����
// => XML ������ �̿��Ͽ� �ν��Ͻ� ���� �� Ŭ����(�ν��Ͻ�)�� ���� ���� ����
public class MessagePrintMain {
	public static void main(String[] args) {
		/*
		HelloMessageObject object=new HelloMessageObject();
		MessagePrint print=new MessagePrint();
		print.setObject(object);
		print.messagePrint();
		*/
		
		//Spring Container�� �̿��Ͽ� �ν��Ͻ� ���� - XML ���Ͽ� �ν��Ͻ� ���� �� ���� ����
		ApplicationContext context=new ClassPathXmlApplicationContext("03_message.xml");
		
		//Spring Container�� ���� ������ �ν��Ͻ� �� ���ϴ� �ν��Ͻ��� ��ȯ�޾� ����
		MessagePrint print=(MessagePrint)context.getBean("messagePrint");
		print.messagePrint();
		
		//Spring Container�� ���� ������ �ν��Ͻ� ����
		((ClassPathXmlApplicationContext)context).close();
	}
}






