package site.itwill10.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResultController {
	//요청처리 메소드에서 뷰페이지(JSP 문서)에 처리결과를 공유하는 방법
	//1.ModelAndView 인스턴스를 이용하여 처리결과 공유 - 요청처리 메소드의 반환형 : ModelAndView
	//2.HttpServletRequest 인스턴스를 이용하여 처리결과 공유 - 요청처리 메소드의 반환형 : String
	//3.Model 인스턴스를 이용하여 처리결과 공유 - 요청처리 메소드의 반환형 : String
	//4.ModelMap 인스턴스를 이용하여 처리결과 공유 - 요청처리 메소드의 반환형 : String
	
	/*
	@RequestMapping("/resultMV")
	public ModelAndView modelAnaView() {
		//ModelAndView : 뷰페이지에 처리결과를 공유하거나 viewName를 저장하여 전달하는 기능의 클래스
		//ModelAndView mv=new ModelAndView();
		//ModelAndView.setViewName(String viewName) : viewName를 변경하는 메소드
		//mv.setViewName("result_display");
		
		//ModelAndView 클래스의 생성자로 viewName을 초기화 설정
		ModelAndView mv=new ModelAndView("result_display");
		
		//ModelAndView.addObject(String attributeName, Object attributeValue)
		// => 뷰페이지에 인스턴스(처리결과)를 공유하는 메소드
		// => attributeName이 생략된 경우 공유 인스턴스의 클래스이름이 자동으로 공유속성명으로 설정
		// => attributeName를 다르게 설정하여 여러 개의 인스턴스 공유 가능
		mv.addObject("mv", "홍길동");
		
		return mv;
	}
	*/
	
	//클라이언트 요청에 의해 요청처리 메소드는 Spring Container에 의해 자동 호출
	//요청처리 메소드에 매개변수를 선언하면 Spring Container가 매개변수에 
	//인스턴스를 생성하거나 제공받아 자동으로 전달하여 저장 
	@RequestMapping("/resultMV")
	public ModelAndView modelAnaView(ModelAndView mv) {
		mv.setViewName("result_display");
		mv.addObject("mv", "홍길동");
		return mv;
	}
	
	@RequestMapping("/resultRequest")
	public String request(HttpServletRequest request) {
		request.setAttribute("request", "임꺽정");
		return "result_display";
	}
	
	//Model : 인스턴스(처리결과) 공유을 목적으로 Spring Framework에서 제공하는 인스턴스 - 인터페이스
	@RequestMapping("/resultModel")
	public String model(Model model) {
		//Model.addAttribute(String attributeName, Object attributeValue)
		// => 뷰페이지에 인스턴스를 공유하는 메소드
		model.addAttribute("model", "전우치");
		return "result_display";
	}
	
	//ModelMap : 인스턴스(처리결과) 공유을 목적으로 Spring Framework에서 제공하는 인스턴스 - 클래스
	@RequestMapping("/resultMap")
	public String modelMap(ModelMap map) {
		//ModelMap.addAttribute(String attributeName, Object attributeValue)
		// => 뷰페이지에 인스턴스를 공유하는 메소드
		map.addAttribute("map", "일지매");
		return "result_display";
	}
}