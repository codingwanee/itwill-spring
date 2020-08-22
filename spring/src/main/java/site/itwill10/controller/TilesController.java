package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TilesController {
	@RequestMapping("/")
	public String template() {
		//tiles.xml 파일에 선언된 definition 엘리먼트의 고유값(name 속성값)을
		//viewName으로 반환하면 설정된 템플릿 페이지(JSP 문서)를 이용하여 응답
		return "index";
	}
	
	@RequestMapping("/tiles1")
	public String tiles1() {
		return "hello_tiles";
	}
	
	@RequestMapping("/tiles2")
	public String tiles2() {
		return "tiles/hi_tiles";
	}
	
	@RequestMapping("/tiles3")
	public String tiles3() {
		return "tiles/good/bye_tiles";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@RequestMapping("/admin_hello")
	public String adminHello() {
		return "admin/hello_tiles";
	}
}







