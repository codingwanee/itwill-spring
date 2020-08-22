package site.itwill04.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration : 클래스를 Spring Bean으로 등록할 수 있는 기능을 제공하는 어노테이션
// => Bean Configuration File의 beans 엘리먼트와 동일한 기능을 제공
@Configuration
public class AnnotationBeanConfiguration {
	//@Bean : Spring Bean를 생성하여 반환하는 기능을 메소드에 부여하기 위한 어노테이션
	// => Bean Configuration File의 bean 엘리먼트와 동일한 기능을 제공
	// => 메소드이름이 자동으로 beanName으로 설정
	// => @Bean(name="beanName") 형식으로 beanName를 직접 설정 가능
	@Bean
	public AnnotationBean annotationBean() {
		return new AnnotationBean();
	}
}
