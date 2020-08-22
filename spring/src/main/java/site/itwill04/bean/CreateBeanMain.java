package site.itwill04.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

//Spring Container�κ��� Spring Bean Configuration File(XML)�� bean ������Ʈ��
//��� ������ Spring Bean�� �����޾� ����ϴ� ���
@SuppressWarnings("deprecation")
public class CreateBeanMain {
	public static void main(String[] args) {
		System.out.println("���-1.ApplicationContext �������̽��� ��ӹ��� Ŭ���� �̿�");
		//Spring Bean Configuration File(XML) �б� ��
		System.out.println("========== Spring Container �ʱ�ȭ �� ==========");
		//Spring Container�� Spring Bean Configuration File�� ������ bean ������Ʈ��
		//������ ��� Ŭ������ �ν��Ͻ�(Spring Bean)�� �̸� �����Ͽ� ����
		ApplicationContext context=new ClassPathXmlApplicationContext("04-1_beanCreate.xml");

		//Spring Bean Configuration File(XML) ���� ��
		System.out.println("========== Spring Container �ʱ�ȭ �� ==========");
		//DL(Dependency Lookup) : �����̳ʿ��� �ʿ��� ��ü�� ��ȯ�޴� ���
		//ApplicationContext.getBean(String beanName) 
		// => �Ű������� ���޵� beanName(beanId)�� Spring Bean�� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
		// => Spring Bean�� Object �������� ��ȯ�ϹǷ� ��ü ����ȯ�Ͽ� ���
		// => beanName�� Spring Bean�� �������� ���� ��� NoSuchBeanDefinitionException �߻�
		CreateBean bean1=(CreateBean)context.getBean("createBean1");
		bean1.display();
		
		//ClassPathXmlApplicationContext.close() 
		// => Spring Container�� ���� ������ ��� Spring Bean�� �����ϴ� �޼ҵ�
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("===========================================================");
		System.out.println("���-2.BeanFactory �������̽��� ��ӹ��� Ŭ���� �̿�");
		System.out.println("========== Spring Container �ʱ�ȭ �� ==========");
		//Spring Container�� Spring Bean Configuration File�� ������ bean ������Ʈ��
		//������ ��� Ŭ������ �ν��Ͻ�(Spring Bean)�� �̻���
		BeanFactory factory=new XmlBeanFactory(new FileSystemResource("src/main/resources/04-1_beanCreate.xml"));
		System.out.println("========== Spring Container �ʱ�ȭ �� ==========");
		//getBean() �޼ҵ带 ȣ���� ��� beanName�� ������Ʈ�� Spring Bean �����Ͽ� ��ȯ
		CreateBean bean2=(CreateBean)factory.getBean("createBean");
		bean2.display();
		System.out.println("===========================================================");
	}
}
