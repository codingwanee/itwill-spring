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
	//HttpSession �Ű������� ������ ��� �ڵ����� ������ ���ε� �Ǿ� ����  
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String id
			, @RequestParam String passwd, Model model, HttpSession session) {
		//���� ���� - ���������� ������ �� �Է������� �̵�(Request Scope)
		if(!id.equals("abc") || !passwd.equals("1234")) {
			model.addAttribute("id", id);
			model.addAttribute("message", "���̵� �Ǵ� ��й�ȣ�� ���� �ʽ��ϴ�.");
			return "session/login_form";			
		}
		
		//���� ���� - ���������� ���� �� ��������� �̵�(Session Scope)
		session.setAttribute("loginId", id);
		
		return "session/login_result";
	}
	*/

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Hewon hewon, Model model, HttpSession session) {
		if(!hewon.getId().equals("abc") || !hewon.getPasswd().equals("1234")) {
			model.addAttribute("message", "���̵� �Ǵ� ��й�ȣ�� ���� �ʽ��ϴ�.");
			return "session/login_form";			
		}

		session.setAttribute("loginId", hewon.getId());
		return "session/login_result";
	}
}




