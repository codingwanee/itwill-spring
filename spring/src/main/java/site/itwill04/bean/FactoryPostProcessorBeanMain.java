package site.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryPostProcessorBeanMain {
	public static void main(String[] args) {
		System.out.println("========== Spring Container 초기화 전 ==========");
		ApplicationContext context=new ClassPathXmlApplicationContext("04-4_beanFactory.xml");
		System.out.println("========== Spring Container 초기화 후 ==========");
		FactoryPostProcessorBeanOne beanOne=context.getBean
			("factoryPostProcessorBeanOne",FactoryPostProcessorBeanOne.class);
		//beanOne.setName("홍길동");
		beanOne.display();
		System.out.println("================================================");
		FactoryPostProcessorBeanTwo beanTwo=context.getBean
				("factoryPostProcessorBeanTwo",FactoryPostProcessorBeanTwo.class);
		beanTwo.display();
		System.out.println("================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
