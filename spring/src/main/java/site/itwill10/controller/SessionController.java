package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import site.itwill10.dto.Hewon;

@Controller
//@SessionAttributes : 컨트롤러에 선언된 모든 요청처리 메소드와 뷰 
//페이지에서 공유하여 사용할 인스턴스를 설정하기 위한 어노테이션
// => Model를 이용하여 인스턴스를 공유할 경우 Request Scope로 공유하는 것이 아닌 Session Scope로 공유
// => 다른 페이지 처리에 필요한 정보를 전달하는 작업을 제거 - 변경 처리시 사용
//value 속성 : Session Scope로 공유될 인스턴스의 공유속성명을 속성값으로 설정
@SessionAttributes(value = "hewon")
public class SessionController {
	//아이디를 전달받아 회원정보를 검색하여 공유하는 요청처리 메소드
	// => JSP 문서로 공유된 회원정보 출력
	@RequestMapping("/hewon_view")
	public String hewonView(Model model) {
		//아이디를 전달하여 해당 아이디의 회원정보를 반환하는 Service 클래스의 메소드 호출
		Hewon hewon=getHewon("abc");
		
		//Model를 이용하여 인스턴스를 공유할 경우 기본적으로 Request Scope로 사용  
		//model.addAttribute("hewon", hewon);
		//공유속성명을 생략하면 공유 인스턴스의 클래스명을 공유속성명으로 자동 설정
		// => 클래스명의 첫문자는 소문자로 변환되어 사용
		//@SessionAttributes 어노테이션에 의해 Session Scope로 인스턴스 공유
		model.addAttribute(hewon);
		
		//응답 JSP 문서 이동
		return "session/hewon_view";
	}
	
	/*
	//아이디를 전달받아 회원정보를 검색하여 공유하는 요청처리 메소드
	// => JSP 문서로 공유된 회원정보를 입력태그에 출력
	@RequestMapping(value = "/hewon_update", method = RequestMethod.GET)
	public String hewonUpdate(@RequestParam String id,Model model) {
		//아이디를 전달하여 해당 아이디의 회원정보를 반환하는 Service 클래스의 메소드 호출		Hewon hewon=getHewon(id);
		Hewon hewon=getHewon(id);
		
		model.addAttribute(hewon);
		
		//응답 JSP 문서 이동
		return "session/hewon_update";
	}
	*/
	
	@RequestMapping(value = "/hewon_update", method = RequestMethod.GET)
	public String hewonUpdate() {
		//@SessionAttributes 어노테이션에 의해 공유된 인스턴스를 뷰페이지에서 사용
		return "session/hewon_update";
	}
	
	//입력된 변경회원정보를 전달받아 회원정보을 변경하는 요청처리 메소드
	//매개변수에 Command 객체를 사용한 경우 @SessionAttributes 어노테이션에
	//의해 공유된 인스턴스가 존재하면 매개변수에 전달하여 저장
	// => 입력값이 전달되면 Setter 메소드를 자동 호출하여 필드값 변경
	//SessionStatus : @SessionAttributes 어노테이션에 의해 공유된 인스턴스의 
	//상태정보를 제공받아 사용하기 위한 인스턴스
	@RequestMapping(value = "/hewon_update", method = RequestMethod.POST)
	public String hewonUpdate(@ModelAttribute Hewon hewon, SessionStatus status) {
		//회원정보를 전달하여 변경하는 Service 클래스의 메소드 호출 - 생략
		
		//입력값이 없어도 @SessionAttributes 어노테이션에 의해 공유된 인스턴스의 필드값 사용
		System.out.println("아이디 = "+hewon.getId());
		
		//SessionStatus.setComplete() : @SessionAttributes 어노테이션에 
		//의해 공유된 인스턴스를 제거하는 메소드
		status.setComplete();
		
		//응답 JSP 문서 이동
		return "session/hewon_view";
	}
	
	private Hewon getHewon(String id) {
		Hewon hewon=new Hewon();
		hewon.setId(id);
		hewon.setPasswd("123456");
		hewon.setName("홍길동");
		hewon.setEmail("abc@itwill.site");
		hewon.setGender("남자");
		return hewon;
	}
}