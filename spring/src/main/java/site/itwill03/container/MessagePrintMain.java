package site.itwill03.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Spring Container를 이용하여 인스턴스를 제공받아 처리하는 프로그램
// => 개발자가 아닌 Spring Container가 인스턴스를 생성하여 반환 - IoC : 제어의 역행
// => XML 파일을 이용하여 인스턴스 생성 및 클래스(인스턴스)의 의존 관계 설정
public class MessagePrintMain {
	public static void main(String[] args) {
		/*
		HelloMessageObject object=new HelloMessageObject();
		MessagePrint print=new MessagePrint();
		print.setObject(object);
		print.messagePrint();
		*/
		
		//Spring Container를 이용하여 인스턴스 생성 - XML 파일에 인스턴스 생성 및 관계 설정
		ApplicationContext context=new ClassPathXmlApplicationContext("03_message.xml");
		
		//Spring Container에 의해 생성된 인스턴스 중 원하는 인스턴스를 반환받아 저장
		MessagePrint print=(MessagePrint)context.getBean("messagePrint");
		print.messagePrint();
		
		//Spring Container에 의해 생성된 인스턴스 제거
		((ClassPathXmlApplicationContext)context).close();
	}
}






