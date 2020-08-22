package site.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropertiesBeanMain {
	public static void main(String[] args) {
		System.out.println("========== Spring Container �ʱ�ȭ �� ==========");
		ApplicationContext context=new ClassPathXmlApplicationContext("04-5_beanProperties.xml");
		System.out.println("========== Spring Container �ʱ�ȭ �� ==========");		
		PropertiesBean bean=context.getBean("propertiesBean", PropertiesBean.class);
		System.out.println(bean);
		System.out.println("================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
