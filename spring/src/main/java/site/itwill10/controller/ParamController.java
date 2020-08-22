package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {
	//입력페이지 요청 >> 값을 입력하여 처리(출력)페이지에 전달하여 요청
	@RequestMapping(value = "/param", method = RequestMethod.GET)
	public String form() {
		return "param_form";
	}
	
	/*
	//처리(출력)페이지 요청
	//요청처리 메소드는 오버로드 선언 가능
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		request.setAttribute("name", name);
		return "param_result";
	}
	*/
	
	/*
	//매개변수를 선언하면 전달값을 Spring Container로부터 자동으로 전달받아 저장
	// => 입력태그의 name 속성값과 매개변수의 이름이 같은 경우에만 저장
	// => 입력태그의 name 속성값과 매개변수의 이름이 다른 경우 매개변수에는 기본값(NULL) 저장
	//입력값을 자동으로 전달받아 저장하기 전에 입력값에 대한 캐릭터셋 변경
	// => 인코딩 필터를 사용하여 요청처리 전 미리 캐릭터셋 변경 가능 - web.xml 설정
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(String name,Model model) {
		model.addAttribute("name",name);
		return "param_result";
	}
	*/
	
	/*
	//@RequestParam : 요청처리 메소드에서 입력값을 전달받아 저장하는 매개변수에 사용하는 어노테이션
	// => 입력태그의 name 속성값과 매개변수의 이름이 같지 않은 경우 400 에러 발생
	// => 반드시 입력값을 전달받아 저장해야 되는 매개변수를 설정하기 위해 사용
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam String name,Model model) {
		model.addAttribute("name",name);
		return "param_result";
	}
	*/
	
	/*
	//@RequestParam 어노테이션에 value 속성의 속성값으로 입력태그의 name 속성값을 설정
	// => 입력태그의 name 속성값과 매개변수의 이름이 틀린 경우에도 입력값을 전달받아 저장할 때 사용
	// => value 속성만 설정할 경우 속성값만 선언 가능
	// => value 속성 대신 name 속성 사용 가능
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam("userName") String name,Model model) {
		model.addAttribute("name",name);
		return "param_result";
	}
	*/
	
	/*
	//@RequestParam 어노테이션에 defaultValue 속성의 속성값으로 매개변수에 저장될 초기값 설정
	// => 입력값이 없거나 입력태그의 name 속성값과 같은 이름의 매개변수가 아닌 경우 사용
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam(defaultValue="임꺽정") String name,Model model) {
		model.addAttribute("name",name);
		return "param_result";
	}
	*/
	
	//@RequestParam 어노테이션에 required 속성의 속성값으로 false를 설정할 경우
	//입력값이 전달되지 않아도 400 에러 미발생(필수 입력요소가 아닌 경우 설정)
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam(required = false) String name,Model model) {
		model.addAttribute("name",name);
		return "param_result";
	}
}





