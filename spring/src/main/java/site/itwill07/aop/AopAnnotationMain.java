package site.itwill07.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopAnnotationMain {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("07-5_aopAnnotation.xml");
		System.out.println("====================================================================================");
		AopAnnotationBean bean=context.getBean("aopBean",AopAnnotationBean.class);
		bean.display1();
		System.out.println("====================================================================================");
		bean.display2();
		System.out.println("====================================================================================");
		bean.display3();
		System.out.println("====================================================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
