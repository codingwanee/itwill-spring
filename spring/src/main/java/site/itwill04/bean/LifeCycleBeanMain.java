package site.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Spring Container는 Spring Bean의 생성,사용,소멸에 대한 생명주기(LifeCycle) 관리

//Spring Bean 생성 후에 대한 초기화 작성 순서
//1.생성자(Constructor) 호출 : 인스턴스를 생성할 때 XML 파일로부터 값(인스턴스)을 전달받아 필드값 변경 - Constructor Injection
//2.Setter 메소드 호출 : 인스턴스 생성 후 XML 파일로부터 값(인스턴스)을 전달받아 필드값 변경 - Setter Injection
//3.BeanNameAware 인터페이스의 setBeanName() 메소드 호출 : 인스턴스 생성 후 Spring Container로부터 beaeName을 전달받아 필드값 변경 
//4.BeanClassLoaderAware 인터페이스의 setBeanClassLoader() 메소드 호출 : 인스턴스 생성 후 Spring Container로부터 ClassLoader를 전달받아 필드값 변경 
//5.BeanFactoryAware 인터페이스의 setBeanFactory() 메소드 호출 : 인스턴스 생성 후 Spring Container로부터 BeanFactory를 전달받아 필드값 변경
//6.ResourceLoaderAware 인터페이스의 setResourceLoader() 메소드 호출 : 인스턴스 생성 후 Spring Container로부터 ResourceLoader를 전달받아 필드값 변경
//7.ApplicationEventPublisherAware 인터페이스의 setApplicationEventPublisher() 메소드 호출 : 인스턴스 생성 후 Spring Container로부터 ApplicationEventPublisher를 전달받아 필드값 변경
//8.MessageSourceAware 인터페이스의 setMessageSource() 메소드 호출 : 인스턴스 생성 후 Spring Container로부터 MessageSource를 전달받아 필드값 변경
//9.ApplicationContextAware 인터페이스의 setApplicationContext() 메소드 호출 : 인스턴스 생성 후 Spring Container로부터 ApplicationContext를 전달받아 필드값 변경
//10.BeanPostProcessor 인스페이스의 postProcessBeforeInitialization() 메소드 호출 : 모든 Spring Bean에 대한 초기화 작업
//11.InitializingBean 인터페이스의 afterPropertiesSet() 메소드 호출 : 인스턴스 생성 후 Properties 파일을 읽어 필드값 변경
//12.bean 엘리먼트의 init-method 속성값으로 설정된 메소드 호출
//13.BeanPostProcessor 인스페이스의 postProcessAfterInitialization() 메소드 호출 : 모든 Spring Bean에 대한 초기화 작업

//Spring Bean 소멸 전에 대한 마무리 작성 순서
//1.DisposableBean 인터페이스의 destroy() 메소드 호출
//2.bean 엘리먼트의 destroy-method 속성값으로 설정된 메소드 호출
public class LifeCycleBeanMain {
	public static void main(String[] args) {
		System.out.println("========== Spring Container 초기화 전 ==========");
		ApplicationContext context=new ClassPathXmlApplicationContext("04-3_beanLifeCycle.xml");
		System.out.println("========== Spring Container 초기화 후 ==========");
		//LifeCycleBean bean=(LifeCycleBean)context.getBean("lifeCycleBean");
		
		//ApplicationContext.getBean(String beanName,Class<T> clazz)
		// => Spring Bean 제공 받아 강제 형변환 후 반환하는 메소드
		LifeCycleBean bean=context.getBean("lifeCycleBean",LifeCycleBean.class);
		
		bean.display();
		System.out.println("========== Spring Container 마무리 전 ==========");
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("========== Spring Container 마무리 후 ==========");
	}
}
