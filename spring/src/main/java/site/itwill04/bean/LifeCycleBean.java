package site.itwill04.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

//Spring Bean 생성 후 초기화 작업 또는 소멸 전 마무리 작업 관련 기능은 
//인터페이스를 상속받아 추상메소드를 오버라이스 선언하여 작업 가능
// => Spring Container로부터 인터페이스 추상메소드의 파라메터에 값을 전달받아 작업
public class LifeCycleBean implements BeanNameAware,BeanClassLoaderAware
	,BeanFactoryAware,ResourceLoaderAware,ApplicationEventPublisherAware
	,MessageSourceAware,ApplicationContextAware,InitializingBean,DisposableBean {
	public LifeCycleBean() {
		System.out.println("### LifeCycleBean 클래스의 기본 생성자 호출 ###");
	}
	
	public void display() {
		System.out.println("*** LifeCycleBean 클래스의 display() 메소드 호출 ***");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("### LifeCycleBean 클래스의 setBeanName() 메소드 호출 ###");
		//System.out.println("benaName = "+name);
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("### LifeCycleBean 클래스의 setBeanClassLoader() 메소드 호출 ###");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("### LifeCycleBean 클래스의 setBeanFactory() 메소드 호출 ###");
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		System.out.println("### LifeCycleBean 클래스의 setResourceLoader() 메소드 호출 ###");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		System.out.println("### LifeCycleBean 클래스의 setApplicationEventPublisher() 메소드 호출 ###");
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		System.out.println("### LifeCycleBean 클래스의 setMessageSource() 메소드 호출 ###");
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("### LifeCycleBean 클래스의 setApplicationContext() 메소드 호출 ###");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("### LifeCycleBean 클래스의 afterPropertiesSet() 메소드 호출 ###");
	}
	
	public void initMethod() {
		System.out.println("### LifeCycleBean 클래스의 initMethod() 메소드 호출 ###");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("### LifeCycleBean 클래스의 destroy() 메소드 호출 ###");
	}
	
	public void destroyMethod() {
		System.out.println("### LifeCycleBean 클래스의 destroyMethod() 메소드 호출 ###");
	}
}
