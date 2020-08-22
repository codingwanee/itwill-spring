package site.itwill04.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component : 클래스를 Spring Bean으로 등록하는 어노테이션
// => 클래스이름이 자동으로 beanName으로 설정 - 첫문자는 대문자에서 소문자로 변환
//@Component
//@Component(value="beanName") 형식으로 beanName 직접 설정 가능 - value 키워드 생략 가능
@Component("cab")
//bean 엘리먼트 속성과 동일한 기능을 제공하는 어노테이션 사용 가능 - @Lazy, @Scope
@Lazy
@Scope("prototype")
public class ComponentAnnotationBean {
	public ComponentAnnotationBean() {
		System.out.println("### ComponentAnnotationBean 클래스의 기본 생성자 호출 ###");
	}
	
	public void display() {
		System.out.println("*** ComponentAnnotationBean 클래스의 display() 메소드 호출 ***");
	}
}
