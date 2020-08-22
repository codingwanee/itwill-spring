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
	//관리자가 페이지를 요청한 경우 메소드가 실행되도록 권한 설정 
	//비로그인 상태의 사용자 또는 관리자가 아닌 사용자가 회원정보 등록 페이지를 
	//요청한 경우 에러 페이지 이동
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(HttpSession session) throws Exception {
		//throw new RuntimeException();
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		if(loginUserinfo==null || !loginUserinfo.getUserid().equals("abc123")) {
			//return "userinfo/user_error";//ExceptionHandler가 없는 경우
			throw new Exception();//ExceptionHandler가 있는 경우
		}
		return "userinfo/user_write";
	}
	*/

	//인터셉터를 이용한 관리자 접근 권한 처리
	//인터셉터(Interceptor) : 요청처리 메소드 실행 전에 필요한 명령 실행 - 권한 처리
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
	
	//요청처리 메소드에서 Service 클래스의 메소드를 호출할 경우 예외 발생 가능
	// => 발생된 예외를 직접 처리하지 않고 Front Controller에게 전달
	// => ExceptionHandler 기능의 메소드를 이용하여 예외 처리
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
		//인증처리 - 예외가 발생된 경우 인증 실패
		userinfoService.loginAuth(userinfo);
			
		//인증 성공시 세션을 이용하여 인증정보(회원정보) 공유 - 권한
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
	//로그인 상태의 사용자가 페이지를 요청한 경우 메소드가 실행되도록 권한 설정
	//비로그인 상태의 사용자가 회원목록 출력페이지를 요청한 경우 로그인정보 입력페이지 이동
	// => 로그인 인증 성공 후 이전 페이지를 재요청하도록 설정하는 것을 권장 
	@RequestMapping("/list")
	public String list(Model model, HttpSession session, HttpServletRequest request) {
		//비로그인 사용자인 경우 인위적 예외을 발생하여 에러페이지로 이동
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

	//인터셉터를 이용한 로그인 사용자 접근 권한 처리
	@RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("userinfoList", userinfoService.getUserinfoList());
		return "userinfo/user_list";
	}
	
	//인터셉터를 이용한 로그인 사용자 접근 권한 처리
	@RequestMapping("/view")
	public String view(@RequestParam String userid, Model model) throws UserinfoNotFoundException {
		model.addAttribute("userinfo", userinfoService.getUserinfo(userid));
		return "userinfo/user_view";		
	}
	
	//인터셉터를 이용한 로그인 사용자 접근 권한 처리
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(@RequestParam String userid,Model model
			,HttpSession session) throws UserinfoNotFoundException {
		//인터셉터를 이용하여 처리 가능
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
	
	//@ExceptionHandler : 요청처리 메소드에서 발생하는 예외를 Front Controller에게 
	//전달받아 처리하는 메소드를 구현하기 위한 어노테이션
	// => value 속성에 처리할 예외 클래스(Clazz)를 속성값으로 설정 - value 속성만 존재할 경우 속성값만 설정
	// => 예외 관련 정보를 매개변수로 전달받아 예외 처리
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
	//Exception를 처리하는 예외 처리 메소드가 선언된 경우 생략 가능
	// => 예외 처리 명령이 동일한 경우 생략
	@ExceptionHandler(UserinfoNotFoundException.class)
	public String exceptionHandler() {
		return "userinfo/user_error";
	}
	*/
	
	/*
	//Controller 클래스의 모든 요청처리 메소드에서 발생되는 예외 처리
	@ExceptionHandler(Exception.class)
	public String exceptionHandler() {
		return "userinfo/user_error";
	}
	*/
}
