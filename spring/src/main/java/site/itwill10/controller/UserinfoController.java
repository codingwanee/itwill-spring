package site.itwill10.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import site.itwill10.dto.Userinfo;
import site.itwill10.exception.LoginAuthFailException;
import site.itwill10.exception.UserinfoExistsException;
import site.itwill10.exception.UserinfoNotFoundException;
import site.itwill10.service.UserinfoService;

@Controller
@RequestMapping("/userinfo")
public class UserinfoController {
	@Autowired
	private UserinfoService userinfoService;
	
	/*
	//�����ڰ� �������� ��û�� ��� �޼ҵ尡 ����ǵ��� ���� ���� 
	//��α��� ������ ����� �Ǵ� �����ڰ� �ƴ� ����ڰ� ȸ������ ��� �������� 
	//��û�� ��� ���� ������ �̵�
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(HttpSession session) throws Exception {
		//throw new RuntimeException();
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		if(loginUserinfo==null || !loginUserinfo.getUserid().equals("abc123")) {
			//return "userinfo/user_error";//ExceptionHandler�� ���� ���
			throw new Exception();//ExceptionHandler�� �ִ� ���
		}
		return "userinfo/user_write";
	}
	*/

	//���ͼ��͸� �̿��� ������ ���� ���� ó��
	//���ͼ���(Interceptor) : ��ûó�� �޼ҵ� ���� ���� �ʿ��� ��� ���� - ���� ó��
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "userinfo/user_write";
	}
	
	/*
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute Userinfo userinfo, Model model) {
		try {
			userinfoService.addUserinfo(userinfo);
		} catch (UserinfoExistsException e) {
			model.addAttribute("message", e.getMessage());
			return "userinfo/user_write";
		} catch (Exception e) {
			return "userinfo/user_error";
		}
		return "redirect:/userinfo/login";
	}
	*/
	
	//��ûó�� �޼ҵ忡�� Service Ŭ������ �޼ҵ带 ȣ���� ��� ���� �߻� ����
	// => �߻��� ���ܸ� ���� ó������ �ʰ� Front Controller���� ����
	// => ExceptionHandler ����� �޼ҵ带 �̿��Ͽ� ���� ó��
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute Userinfo userinfo) throws UserinfoExistsException {
		userinfoService.addUserinfo(userinfo);
		return "redirect:/userinfo/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "userinfo/user_login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Userinfo userinfo, HttpSession session)
			throws LoginAuthFailException, UserinfoNotFoundException {
		//����ó�� - ���ܰ� �߻��� ��� ���� ����
		userinfoService.loginAuth(userinfo);
			
		//���� ������ ������ �̿��Ͽ� ��������(ȸ������) ���� - ����
		session.setAttribute("loginUserinfo", userinfoService.getUserinfo(userinfo.getUserid()));
		
		if(session.getAttribute("destURI")!=null) {
			String destURI=(String)session.getAttribute("destURI");
			session.removeAttribute("destURI");
			return "redirect:"+destURI;
		}
		
		return "userinfo/user_login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/userinfo/login";
	}
	
	/*
	//�α��� ������ ����ڰ� �������� ��û�� ��� �޼ҵ尡 ����ǵ��� ���� ����
	//��α��� ������ ����ڰ� ȸ����� ����������� ��û�� ��� �α������� �Է������� �̵�
	// => �α��� ���� ���� �� ���� �������� ���û�ϵ��� �����ϴ� ���� ���� 
	@RequestMapping("/list")
	public String list(Model model, HttpSession session, HttpServletRequest request) {
		//��α��� ������� ��� ������ ������ �߻��Ͽ� ������������ �̵�
		//if(session.getAttribute("loginUserinfo")==null) {
		//	throw new RuntimeException();
		//}
		
		if(session.getAttribute("loginUserinfo")==null) {
			String uri=request.getRequestURI().substring(request.getContextPath().length());
			String query=request.getQueryString();
			if(query==null) {
				query="";
			} else {
				query="?"+query;
			}
			
			if(request.getMethod().equals("GET")) {
				session.setAttribute("destURI",uri+query);
			}
				
			return "redirect:/userinfo/login";	
		}
		
		model.addAttribute("userinfoList", userinfoService.getUserinfoList());
		return "userinfo/user_list";
	}
	*/

	//���ͼ��͸� �̿��� �α��� ����� ���� ���� ó��
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("userinfoList", userinfoService.getUserinfoList());
		return "userinfo/user_list";
	}
	
	//���ͼ��͸� �̿��� �α��� ����� ���� ���� ó��
	@RequestMapping("/view")
	public String view(@RequestParam String userid, Model model) throws UserinfoNotFoundException {
		model.addAttribute("userinfo", userinfoService.getUserinfo(userid));
		return "userinfo/user_view";		
	}
	
	//���ͼ��͸� �̿��� �α��� ����� ���� ���� ó��
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(@RequestParam String userid,Model model
			,HttpSession session) throws UserinfoNotFoundException {
		//���ͼ��͸� �̿��Ͽ� ó�� ����
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		if(!loginUserinfo.getUserid().equals("abc123") && !loginUserinfo.getUserid().equals(userid)) {
			return "userinfo/user_error";
		}
		
		model.addAttribute("userinfo", userinfoService.getUserinfo(userid));
		return "userinfo/user_modify";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(@ModelAttribute Userinfo userinfo, HttpSession session) throws UserinfoNotFoundException {
		userinfoService.modifyUserinfo(userinfo);
		session.setAttribute("loginUserinfo", userinfoService.getUserinfo(userinfo.getUserid()));
		return "redirect:/userinfo/view?userid="+userinfo.getUserid();
	}
	
	@RequestMapping(value = "/remove")
	public String remove(@RequestParam String userid) throws UserinfoNotFoundException {
		if(userid.equals("abc123")) {
			return "userinfo/user_error";
		}
		userinfoService.eraseUserinfo(userid);
		return "redirect:/userinfo/list";
	}
	
	//@ExceptionHandler : ��ûó�� �޼ҵ忡�� �߻��ϴ� ���ܸ� Front Controller���� 
	//���޹޾� ó���ϴ� �޼ҵ带 �����ϱ� ���� ������̼�
	// => value �Ӽ��� ó���� ���� Ŭ����(Clazz)�� �Ӽ������� ���� - value �Ӽ��� ������ ��� �Ӽ����� ����
	// => ���� ���� ������ �Ű������� ���޹޾� ���� ó��
	@ExceptionHandler(UserinfoExistsException.class)
	public String exceptionHandler(UserinfoExistsException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		model.addAttribute("userinfo", exception.getUserinfo());
		return "userinfo/user_write";
	}
	
	@ExceptionHandler(LoginAuthFailException.class)
	public String exceptionHandler(LoginAuthFailException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		model.addAttribute("userid", exception.getUserid());
		return "userinfo/user_login";
	}
	
	/*
	//Exception�� ó���ϴ� ���� ó�� �޼ҵ尡 ����� ��� ���� ����
	// => ���� ó�� ����� ������ ��� ����
	@ExceptionHandler(UserinfoNotFoundException.class)
	public String exceptionHandler() {
		return "userinfo/user_error";
	}
	*/
	
	/*
	//Controller Ŭ������ ��� ��ûó�� �޼ҵ忡�� �߻��Ǵ� ���� ó��
	@ExceptionHandler(Exception.class)
	public String exceptionHandler() {
		return "userinfo/user_error";
	}
	*/
}
