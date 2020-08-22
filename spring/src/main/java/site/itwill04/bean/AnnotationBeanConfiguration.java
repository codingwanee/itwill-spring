package site.itwill04.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration : Ŭ������ Spring Bean���� ����� �� �ִ� ����� �����ϴ� ������̼�
// => Bean Configuration File�� beans ������Ʈ�� ������ ����� ����
@Configuration
public class AnnotationBeanConfiguration {
	//@Bean : Spring Bean�� �����Ͽ� ��ȯ�ϴ� ����� �޼ҵ忡 �ο��ϱ� ���� ������̼�
	// => Bean Configuration File�� bean ������Ʈ�� ������ ����� ����
	// => �޼ҵ��̸��� �ڵ����� beanName���� ����
	// => @Bean(name="beanName") �������� beanName�� ���� ���� ����
	@Bean
	public AnnotationBean annotationBean() {
		return new AnnotationBean();
	}
}
