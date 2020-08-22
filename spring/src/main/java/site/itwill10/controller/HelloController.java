package site.itwill10.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Controller 클래스 : 클라이언트의 요청에 대한 처리 메소드가 선언된 클래스
//@Controller : Controller 클래스를 Spring Bean으로 등록하기 위한 엘리먼트
// => Controller 인터페이스를 상속받지 않아도 Controller 클래스로 작성 가능
//클라이언트 요청을 받아 특정 메소드로 요청 처리 가능 
// => 하나의 Controller 클래스로 클라이언트의 여러 요청을 받아 처리
// => @RequestMapping 어노테이션을 이용하여 메소드 선언
//Spring Bean의 이름(beanName)은 기본적으로 클래스명 이용
// => 어노테이션의 value 속성에 beanName을 임의대로 설정 가능
@Controller
public class HelloController {
	private final static Logger logger=LoggerFactory.getLogger(HelloController.class);
	//Front Controller에게 viewName를 전달하는 방법
	// => ViewResolver 클래스에 의해 View 페이지를 완성하여 포워드 이동하여 응답 처리
	//1.요청처리 메소드의 반환형 void로 선언하여 메소드명으로 viewName 전달 
	//2.요청처리 메소드의 반환형 String로 선언하여 반환된 문자열로 viewName 전달
	//3.요청처리 메소드의 반환형 ModelAndView로 선언하여 ModelAndView 인스턴스에 viewName를 저장하여 전달
	
	//클라이언트의 요청을 처리하기 위한 메소드
	//@RequestMapping : 클라이언트 요청정보를 제공받아 처리하는 메소드를 설정하는 어노테이션
	// => 어노테이션의 value 속성값으로 클라이언트 요청정보 설정(고유값)
	// => value 속성 대신 name 속성 사용 가능
	//다른 @RequestMapping 어노테이션의 value 속성값이 중복될 경우 Spring Bean 생성 예외 발생
	@RequestMapping(value = "/hello")
	public void hello() {
		//요청처리
		logger.info("/hello 요청 >> hello() 메소드 호출");
	}
	
	//@RequestMapping 어노테이션에 value 속성만 설정할 경우 속성값만 선언 가능
	@RequestMapping("/helloViewName")
	public String helloViewName() {
		logger.info("/helloViewName 요청 >> helloViewName() 메소드 호출");
		return "hello";
	}
	
	@RequestMapping("/helloMV")
	public ModelAndView helloModelAndView() {
		logger.info("/helloMV 요청 >> helloModelAndView() 메소드 호출");
		/*
		ModelAndView mv=new ModelAndView();
		mv.setViewName("hello");
		*/
		ModelAndView mv=new ModelAndView("hello");
		return mv;
	}
}
