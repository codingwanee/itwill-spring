package site.itwill10.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelController {
	@RequestMapping("/display1")
	public String display1(Model model) {
		model.addAttribute("name","홍길동");
		//model.addAttribute("now", new SimpleDateFormat
		//	("yyyy년 MM원 dd일 HH시 mm분 ss초").format(new Date()));
		return "model_display1";
	}
	
	@RequestMapping("/display2")
	public String display2(Model model) {
		model.addAttribute("name", "임꺽정");
		//model.addAttribute("now", new SimpleDateFormat
		//	("yyyy년 MM원 dd일 HH시 mm분 ss초").format(new Date()));
		return "model_display2";
	}
	
	@RequestMapping("/display3")
	public String display3(Model model) {
		model.addAttribute("name", "전우치");
		//model.addAttribute("now", new SimpleDateFormat
		//	("yyyy년 MM원 dd일 HH시 mm분 ss초").format(new Date()));
		return "model_display3";
	}
	
	//@ModelAttribute : 메소드에 선언된 경우에는 메소드의 반환값(인스턴스)를
	//현재 Controller 클래스의 모든 요청처리 메소드에서 설정된 뷰페이지에 공유
	//되도록 설정하는 어노테이션 - 공유을 목적으로 선언된 메소드에 설정
	// => 어노테이션의 name 속성을 설정하여 속성값으로 attributeName 설정 - 속성값만 설정 가능
	@ModelAttribute(name="now")
	public String getNow() {
		return new SimpleDateFormat("yyyy년 MM원 dd일 HH시 mm분 ss초").format(new Date());
	}
}







