package site.itwill10.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.itwill10.dto.Hewon;

@Controller
public class LoginController {
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "session/login_form";
	}
	
	/*
	//HttpSession 매개변수를 선언한 경우 자동으로 세션이 바인딩 되어 전달  
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String id
			, @RequestParam String passwd, Model model, HttpSession session) {
		//인증 실패 - 에러정보를 공유한 후 입력페이지 이동(Request Scope)
		if(!id.equals("abc") || !passwd.equals("1234")) {
			model.addAttribute("id", id);
			model.addAttribute("message", "아이디 또는 비밀번호가 맞지 않습니다.");
			return "session/login_form";			
		}
		
		//인증 성공 - 인증정보를 공유 후 출력페이지 이동(Session Scope)
		session.setAttribute("loginId", id);
		
		return "session/login_result";
	}
	*/

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Hewon hewon, Model model, HttpSession session) {
		if(!hewon.getId().equals("abc") || !hewon.getPasswd().equals("1234")) {
			model.addAttribute("message", "아이디 또는 비밀번호가 맞지 않습니다.");
			return "session/login_form";			
		}

		session.setAttribute("loginId", hewon.getId());
		return "session/login_result";
	}
}




