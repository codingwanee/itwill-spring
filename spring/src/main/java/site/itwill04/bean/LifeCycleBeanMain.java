package site.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Spring Container�� Spring Bean�� ����,���,�Ҹ꿡 ���� �����ֱ�(LifeCycle) ����

//Spring Bean ���� �Ŀ� ���� �ʱ�ȭ �ۼ� ����
//1.������(Constructor) ȣ�� : �ν��Ͻ��� ������ �� XML ���Ϸκ��� ��(�ν��Ͻ�)�� ���޹޾� �ʵ尪 ���� - Constructor Injection
//2.Setter �޼ҵ� ȣ�� : �ν��Ͻ� ���� �� XML ���Ϸκ��� ��(�ν��Ͻ�)�� ���޹޾� �ʵ尪 ���� - Setter Injection
//3.BeanNameAware �������̽��� setBeanName() �޼ҵ� ȣ�� : �ν��Ͻ� ���� �� Spring Container�κ��� beaeName�� ���޹޾� �ʵ尪 ���� 
//4.BeanClassLoaderAware �������̽��� setBeanClassLoader() �޼ҵ� ȣ�� : �ν��Ͻ� ���� �� Spring Container�κ��� ClassLoader�� ���޹޾� �ʵ尪 ���� 
//5.BeanFactoryAware �������̽��� setBeanFactory() �޼ҵ� ȣ�� : �ν��Ͻ� ���� �� Spring Container�κ��� BeanFactory�� ���޹޾� �ʵ尪 ����
//6.ResourceLoaderAware �������̽��� setResourceLoader() �޼ҵ� ȣ�� : �ν��Ͻ� ���� �� Spring Container�κ��� ResourceLoader�� ���޹޾� �ʵ尪 ����
//7.ApplicationEventPublisherAware �������̽��� setApplicationEventPublisher() �޼ҵ� ȣ�� : �ν��Ͻ� ���� �� Spring Container�κ��� ApplicationEventPublisher�� ���޹޾� �ʵ尪 ����
//8.MessageSourceAware �������̽��� setMessageSource() �޼ҵ� ȣ�� : �ν��Ͻ� ���� �� Spring Container�κ��� MessageSource�� ���޹޾� �ʵ尪 ����
//9.ApplicationContextAware �������̽��� setApplicationContext() �޼ҵ� ȣ�� : �ν��Ͻ� ���� �� Spring Container�κ��� ApplicationContext�� ���޹޾� �ʵ尪 ����
//10.BeanPostProcessor �ν����̽��� postProcessBeforeInitialization() �޼ҵ� ȣ�� : ��� Spring Bean�� ���� �ʱ�ȭ �۾�
//11.InitializingBean �������̽��� afterPropertiesSet() �޼ҵ� ȣ�� : �ν��Ͻ� ���� �� Properties ������ �о� �ʵ尪 ����
//12.bean ������Ʈ�� init-method �Ӽ������� ������ �޼ҵ� ȣ��
//13.BeanPostProcessor �ν����̽��� postProcessAfterInitialization() �޼ҵ� ȣ�� : ��� Spring Bean�� ���� �ʱ�ȭ �۾�

//Spring Bean �Ҹ� ���� ���� ������ �ۼ� ����
//1.DisposableBean �������̽��� destroy() �޼ҵ� ȣ��
//2.bean ������Ʈ�� destroy-method �Ӽ������� ������ �޼ҵ� ȣ��
public class LifeCycleBeanMain {
	public static void main(String[] args) {
		System.out.println("========== Spring Container �ʱ�ȭ �� ==========");
		ApplicationContext context=new ClassPathXmlApplicationContext("04-3_beanLifeCycle.xml");
		System.out.println("========== Spring Container �ʱ�ȭ �� ==========");
		//LifeCycleBean bean=(LifeCycleBean)context.getBean("lifeCycleBean");
		
		//ApplicationContext.getBean(String beanName,Class<T> clazz)
		// => Spring Bean ���� �޾� ���� ����ȯ �� ��ȯ�ϴ� �޼ҵ�
		LifeCycleBean bean=context.getBean("lifeCycleBean",LifeCycleBean.class);
		
		bean.display();
		System.out.println("========== Spring Container ������ �� ==========");
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("========== Spring Container ������ �� ==========");
	}
}
