package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.itwill10.dto.Member;

@Controller
public class JoinController {
	@RequestMapping(value = "/join",method = RequestMethod.GET)
	public String join() {
		return "join_form";
	}
	
	/*
	//입력태그의 이름과 매개변수의 이름을 다르게 설정해도 400 에러 미발생
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String join(String id, String passwd, String name, String email
		, String phone1, String phone2, String phone3, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("phone1", phone1);
		model.addAttribute("phone2", phone2);
		model.addAttribute("phone3", phone3);
		return "join_result";
	}
	*/
	
	/*
	//입력태그의 이름과 매개변수의 이름을 다르게 설정한 경우 매개변수에 
	//입력값이 전달되어 저장되지 않아 400 에러 발생
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String passwd
		, @RequestParam String name, @RequestParam String email
		, @RequestParam String phone1, @RequestParam String phone2
		, @RequestParam String phone3, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("phone1", phone1);
		model.addAttribute("phone2", phone2);
		model.addAttribute("phone3", phone3);
		return "join_result";
	}
	*/
	
	/*
	//@ModelAttribute 어노테이션을 입력값을 전달받아 저장하는 매개변수에
	//선언한 경우 입력값을 뷰페이지에 자동으로 공유하는 기능 제공
	//@ModelAttribute 어노테이션의 value 속성의 속성값으로 공유속성명 설정
	// => value 속성이 생략된 경우 기본적으로 매개변수의 자료형을 공유속성명으로 자동 설정 - 첫문자는 소문자로 변환
	// => value 속성만 설정할 경우 속성값만 선언 가능
	//입력태그의 name 속성값과 @ModelAttribute 어노테이션의 value 속성값이
	//같지 않을 경우 매개변수에 값이 전달되지 않아 미저장 - 400 에러 미발생
	// => @ModelAttribute 어노테이션의 value 속성을 설정할 경우 속성값은 입력태그의 name 속성값과 동일하게 설정
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String join(@ModelAttribute(value = "id") String id
		, @ModelAttribute("passwd") String passwd, @ModelAttribute("name") String name
		, @ModelAttribute("email") String email, @ModelAttribute("phone1") String phone1
		, @ModelAttribute("phone2") String phone2, @ModelAttribute("phone3") String phone3) {
		return "join_result";
	}
	*/
	
	/*
	//입력태그의 모든 입력값을 Map 인스턴스의 요소로 자동 저장
	// => @RequestParam 어노테이션이 생략될 경우 요소가 없는 빈(Empty) Map 인스턴스만 제공
	// => 입력태그의 name 속성값이 MapKey가 되며 입력값은 MapValue로 자동 설정
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String join(@RequestParam Map<String, String> memberMap, Model model) {
		model.addAttribute("memberMap", memberMap);
		return "join_result";
	}
	*/
	
	/*
	//JavaBean 클래스를 매개변수로 선언하면 Spring Container에 의해 JavaBean 인스턴스를 생성하여 자동 저장
	// => 입력태그의 name 속성값과 같은 이름의 필드에 입력값을 자동 저장   
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String join(Member member, Model model) {
		model.addAttribute("member", member);
		return "join_result";
	}
	*/
	
	/*
	//@ModelAttribute 어노테이션을 선언하면 자동으로 뷰페이지에 인스턴스 공유
	// => @ModelAttribute 어노테이션을 선언하지 않아도 자동으로 어노테이션 설정
	// => JavaBean 클래스의 이름이 자동으로 공유속성명으로 설정 - 첫문자는 소문자로 변환
	//Command 객체 : Spring Container에 의해 자동 생성되어 입력값이 필드에 저장되는 객체
	// => Command 객체는 자동으로 뷰페이지에 공유되어 사용 가능
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String join(@ModelAttribute Member member) {
		return "join_result";
	}
	*/
	
	/*
	//@ModelAttribute 어노테이션의 value 속성의 속성값으로 공유속성명 변경 가능
	// => value 속성 대신 name 속성 사용 가능
	// => value 속성만 설정할 경우 속성값만 선언 가능
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String join(@ModelAttribute("mem") Member member) {
		return "join_result";
	}
	*/
	
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String join(@ModelAttribute("mem") Member member, Model model) {
		if(member.getId().equals("abc")) {
			model.addAttribute("message", "이미 사용중인 아이디입니다.");
			return "join_form";
		}
		return "join_result";
	}
}