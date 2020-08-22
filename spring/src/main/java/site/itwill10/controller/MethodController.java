package site.itwill10.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodController {
	//입력페이지 요청 >> 값을 입력받아 처리(출력)페이지에 전달하여 요청
	@RequestMapping("/input1")
	public String input1() {
		return "method_input";
	}
	
	//처리(출력)페이지 요청 >> 전달값을 반환받아 출력
	@RequestMapping("/input2")
	public String output1(HttpServletRequest request) throws UnsupportedEncodingException {
		//전달값에 대한 캐릭터셋(인코딩) 변경
		// => UnsupportedEncodingException 예외 발생 - 예외처리
		request.setCharacterEncoding("UTF-8");
		
		//전달값을 반환받아 저장
		String name=request.getParameter("name");
		
		//반환받은 전달값 공유
		request.setAttribute("name", name);
		
		return "method_output";
	}
	
	//입력페이지와 처리(출력)페이지의 요청에 대한 URL 주소를 동일하게 설정(권장)
	// => 클라이언트 요청에 대한 URL 주소가 동일한 경우 에러 발생
	// => 클라이언트 요청방식을 다르게 선언하여 설정
	//value 속성에 요청 URL 주소를 속성값으로 설정하고 method 속성에 요청방식을 속성값으로 설정
	// => method 속성이 생략된 경우 기본적으로 요청방식은 GET 방식으로 처리 
	// => method 속성값은 RequestMethod(Enum)의 상수필드(ContentField) 사용 
	
	//입력페이지 요청(GET)
	@RequestMapping(value="/input",method=RequestMethod.GET)
	public String input2() {
		return "method_input";
	}
	
	//처리(출력)페이지 요청(POST)
	@RequestMapping(value="/input",method=RequestMethod.POST)
	public String output2(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		request.setAttribute("name", name);
		return "method_output";
	}
}




