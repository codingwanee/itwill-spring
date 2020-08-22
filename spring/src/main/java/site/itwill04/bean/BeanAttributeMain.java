package site.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAttributeMain {
	public static void main(String[] args) {
		System.out.println("========== Spring Container �ʱ�ȭ �� ==========");
		ApplicationContext context
			=new ClassPathXmlApplicationContext("04-2_beanAttribute.xml");
		System.out.println("========== Spring Container �ʱ�ȭ �� ==========");
		InitDestroyMethodBean bean
			=(InitDestroyMethodBean)context.getBean("initDestroyMethodBean");
		
		//bean.init();
		bean.display();
		//bean.destroy();
		System.out.println("================================================");
		context.getBean("lazyInitBean");
		System.out.println("================================================");
		//bean ������Ʈ�� scope �Ӽ����� singleton�� ��� �ϳ��� Spring Bean�� �����Ͽ� �����޾� ���
		ScopeBean bean1=(ScopeBean)context.getBean("singletonBean");
		ScopeBean bean2=(ScopeBean)context.getBean("singletonBean");
		ScopeBean bean3=(ScopeBean)context.getBean("singletonBean");
		
		System.out.println("bean1 = "+bean1);
		System.out.println("bean2 = "+bean2);
		System.out.println("bean3 = "+bean3);
		System.out.println("================================================");
		ScopeBean bean4=(ScopeBean)context.getBean("prototypeBean");
		ScopeBean bean5=(ScopeBean)context.getBean("prototypeBean");
		ScopeBean bean6=(ScopeBean)context.getBean("prototypeBean");
		
		System.out.println("bean4 = "+bean4);
		System.out.println("bean5 = "+bean5);
		System.out.println("bean6 = "+bean6);
		System.out.println("================================================");
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("================================================");
	}
}






