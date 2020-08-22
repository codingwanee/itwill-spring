package site.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryPostProcessorBeanMain {
	public static void main(String[] args) {
		System.out.println("========== Spring Container �ʱ�ȭ �� ==========");
		ApplicationContext context=new ClassPathXmlApplicationContext("04-4_beanFactory.xml");
		System.out.println("========== Spring Container �ʱ�ȭ �� ==========");
		FactoryPostProcessorBeanOne beanOne=context.getBean
			("factoryPostProcessorBeanOne",FactoryPostProcessorBeanOne.class);
		//beanOne.setName("ȫ�浿");
		beanOne.display();
		System.out.println("================================================");
		FactoryPostProcessorBeanTwo beanTwo=context.getBean
				("factoryPostProcessorBeanTwo",FactoryPostProcessorBeanTwo.class);
		beanTwo.display();
		System.out.println("================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
