package site.itwill04.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

//BeanFactoryPostProcessor �������̽��� ��ӹ޾� �ۼ��� �ڽ�Ŭ����
// => Spring Bean ���� �� BeanFactoryPostProcessor �������̽��� �߻� �޼ҵ� �ڵ� ȣ��
// => ConfigurableListableBeanFactory �ν��Ͻ��� ���޹޾� getBean() �޼ҵ�� Spring Bean�� �����޾� �ʱ�ȭ �۾�
// => �ٸ� Spring Bean �ʵ尪���� ���� Ŭ������ �ʵ尪 ����
public class FactoryPostProcessorBeanTwo implements BeanFactoryPostProcessor {
	private String name;
	
	public FactoryPostProcessorBeanTwo() {
		System.out.println("### FactoryPostProcessorBeanTwo Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	public void display() {
		System.out.println("*** FactoryPostProcessorBeanTwo Ŭ������ display() �޼ҵ� ȣ�� ###");
		System.out.println("FactoryPostProcessorBeanTwo Ŭ������ name �ʵ尪 = "+name);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("### FactoryPostProcessorBeanTwo Ŭ������ postProcessBeanFactory() �޼ҵ� ȣ�� ###");
		FactoryPostProcessorBeanOne bean=beanFactory.getBean
			("factoryPostProcessorBeanOne", FactoryPostProcessorBeanOne.class);
		name=bean.getName();
	}
}
