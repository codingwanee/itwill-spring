package site.itwill04.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

//Spring Container로부터 Spring Bean Configuration File(XML)의 bean 엘리먼트로
//등록 설정된 Spring Bean를 제공받아 사용하는 방법
@SuppressWarnings("deprecation")
public class CreateBeanMain {
	public static void main(String[] args) {
		System.out.println("방법-1.ApplicationContext 인터페이스를 상속받은 클래스 이용");
		//Spring Bean Configuration File(XML) 읽기 전
		System.out.println("========== Spring Container 초기화 전 ==========");
		//Spring Container가 Spring Bean Configuration File를 읽으면 bean 엘리먼트로
		//설정된 모든 클래스를 인스턴스(Spring Bean)로 미리 생성하여 관리
		ApplicationContext context=new ClassPathXmlApplicationContext("04-1_beanCreate.xml");

		//Spring Bean Configuration File(XML) 읽은 후
		System.out.println("========== Spring Container 초기화 후 ==========");
		//DL(Dependency Lookup) : 컨테이너에게 필요한 객체를 반환받는 방법
		//ApplicationContext.getBean(String beanName) 
		// => 매개변수에 전달된 beanName(beanId)의 Spring Bean를 검색하여 반환하는 메소드
		// => Spring Bean를 Object 형식으로 반환하므로 객체 형변환하여 사용
		// => beanName의 Spring Bean이 존재하지 않을 경우 NoSuchBeanDefinitionException 발생
		CreateBean bean1=(CreateBean)context.getBean("createBean1");
		bean1.display();
		
		//ClassPathXmlApplicationContext.close() 
		// => Spring Container에 의해 생성된 모든 Spring Bean를 제거하는 메소드
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("===========================================================");
		System.out.println("방법-2.BeanFactory 인터페이스를 상속받은 클래스 이용");
		System.out.println("========== Spring Container 초기화 전 ==========");
		//Spring Container가 Spring Bean Configuration File를 읽으면 bean 엘리먼트로
		//설정된 모든 클래스를 인스턴스(Spring Bean)로 미생성
		BeanFactory factory=new XmlBeanFactory(new FileSystemResource("src/main/resources/04-1_beanCreate.xml"));
		System.out.println("========== Spring Container 초기화 후 ==========");
		//getBean() 메소드를 호출할 경우 beanName의 엘리먼트로 Spring Bean 생성하여 반환
		CreateBean bean2=(CreateBean)factory.getBean("createBean");
		bean2.display();
		System.out.println("===========================================================");
	}
}
