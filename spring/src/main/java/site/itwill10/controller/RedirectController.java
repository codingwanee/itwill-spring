package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	@RequestMapping("/forward_display")
	public String forwardDisplay(Model model) {
		//Model를 이용한 인스턴스 공유(Request Scope) - 요청처리 메소드의 뷰페이지 공유
		model.addAttribute("name", "홍길동");
		
		//뷰페이지(JSP 문서)로 포워드 이동 - 뷰페이지에서 공유된 인스턴스 사용
		return "redirect/forward_display";
	}
	
	/*
	@RequestMapping("/redirect_display")
	public String redirectDisplay(Model model) {
		model.addAttribute("name", "홍길동");
		return "redirect/redirect_display";
	}
	
	@RequestMapping("/redirect")
	public String redirect() {
		//반환되는 문자열(ViewName)에 redirect 접두사(Namespace)를 이용하여 리다이렉트 이동
		// => 클라이언트에게 301 응답코드와 요청 URL을 전달하여 재요청
		// => 브라우저의 URL 주소 변경
		//return "redirect:/forward_display";
		return "redirect:/redirect_display";
	}
	*/
	
	/*
	//입력값을 매개변수로 전달받아 공유하여 뷰페이지에서 출력
	// => form 태그 또는 QueryString을 이용하여 값을 전달받아 사용
	@RequestMapping("/redirect_display")
	public String redirectDisplay(@RequestParam String name, Model model) {
		model.addAttribute("name", name);
		return "redirect/redirect_display";
	}
	
	@RequestMapping("/redirect")
	public String redirect(Model model) {
		//포워드 이동된 뷰페이지에 인스턴스 공유(Request Scope)
		model.addAttribute("name", "홍길동");
		
		//리다이렉트에 의해 실행된 요청처리 메소드의 뷰페이지에서는 공유 인스턴스 사용 불가능
		// => Request Scope로 공유된 인스턴스는 리다이렉트 이동된 페이지에서 사용 불가능
		//Model에 의해 공유된 인스턴스가 문자열인 경우 리다이렉트 페이지에
		//QueryString 형식으로 전달되어 사용할 수 있지만 문자열이 아닌 경우 전달 불가능
		return "redirect:/redirect_display";
	}
	*/
	
	@RequestMapping("/redirect_display")
	public String redirectDisplay() {
		return "redirect/redirect_display";
	}
	
	//RedirectAttributes : 리다이렉트 이동에 의해 실행된 요청처리 메소드의
	//뷰페이지에 인스턴스를 공유하기 위한 기능을 제공하는 인스턴스
	@RequestMapping("/redirect")
	public String redirect(RedirectAttributes attributes) {
		//RedirectAttributes.addFlashAttribute(String attributeName, Object attributeValue)
		// => 리다이렉트 이동에 의해 실행된 요청처리 메소드의 뷰페이지에게 인스턴스를 공유하는 메소드 
		attributes.addFlashAttribute("name", "홍길동");
		return "redirect:/redirect_display";
	}
}