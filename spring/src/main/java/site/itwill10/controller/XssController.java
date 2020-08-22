package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lyncode.jtwig.functions.util.HtmlUtils;

@Controller
public class XssController {
	@RequestMapping(value = "/xss", method = RequestMethod.GET)
	public String xss() {
		return "xss/input";
	}
	
	//XSS : 입력태그에 비정상적인 코드를 입력하여 프로그램을 공격하는 기술
	// => XSS 공격에 대한 방어를 위해 보안 코딩 필요
	
	//1.뷰페이지에서의 처리 방법 >> 태그 관련 문자를 Escape 문자로 변환
	// => 요청처리 메소드에서 사용한 태그도 Escape 문자로 변환
	// 1) Core 태그 라이브러리의 out 태그를 사용하여 출력하는 방법
	// 2) Functions 태그 라이브러리의 escapeXml() EL 함수를 사용하여 출력하는 방법
	
	//2.요청처리 메소드에서의 처리 방법
	// 1) Spring Framework에서 제공하는 HtmlUtils 클래스의 htmlEscape() 메소드 사용
	// 2) Apache 그룹에서 제공하는 HtmlUtils 클래스의 stripTag() 메소드 사용
	@RequestMapping(value = "/xss", method = RequestMethod.POST)
	public String xss(@RequestParam String subject
			, @RequestParam String content,Model model) {
		/*
		model.addAttribute("subject", subject);
		//model.addAttribute("content", content);
		model.addAttribute("content", content.replace("\n", "<br>"));
		*/
		
		//HtmlUtils.htmlEscape(String text) : 전달된 문자열에 존재하는
		//태그 관련 문자를 Escape 문자로 변환하여 반환하는 메소드
		/*
		model.addAttribute("subject", HtmlUtils.htmlEscape(subject));
		model.addAttribute("content", HtmlUtils.htmlEscape(content).replace("\n", "<br>"));
		*/
		
		//HtmlUtils.stripTags(String text) : 전달된 문자열에 존재하는
		//태그 관련 문자를 모두 제거하여 반환하는 메소드
		model.addAttribute("subject", HtmlUtils.stripTags(subject));
		model.addAttribute("content", HtmlUtils.stripTags(content).replace("\n", "<br>"));
		return "xss/result";
	}
}








