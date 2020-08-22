package site.itwill.custom;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//태그 클래스 : JSP 문서에서 커스텀 태그를 사용할 경우 원하는 기능을 제공하는 클래스
// => TagSupport, BodyTagSupport, SimpleTagSupport 클래스를 상속받아 작성

//태그 속성과 태그 내용이 없는 태그 클래스
public class HelloTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	//JSP 문서에서 커스텀 태그를 사용할 경우 태그 클래스를 인스턴스로 생성할 때 호출
	public HelloTag() {
		//System.out.println("[정보]HelloTag 클래스의 기본 생성자 호출");
	}
	
	//JSP 문서에서 커스텀 태그의 시작태그를 사용할 경우 호출되는 메소드
	@Override
	public int doStartTag() throws JspException {
		//System.out.println("[정보]HelloTag 클래스의 doStartTag() 메소드 호출");
		
		//pageContext : 커스텀 태그를 사용한 JSP 문서의 컨텍스트 정보를 저장하는 인스턴스
		// => TagSupport 클래스(부모클래스)에 선언된 필드
		// => JSP 문서에서 사용 가능한 인스턴스 제공 - request, response, out, session 등
		//pageContext.getOut() : JspWriter 인스턴스(브라우저 출력스트림)를 반환하는 메소드
		try {
			pageContext.getOut().println("<div>안녕하세요.</div>");
		} catch (IOException e) {
			e.printStackTrace();//콘솔에 예외 메세지 출력
			throw new JspException(e.getMessage());//브라우저 예외 메세지 출력
		}
		
		//doStartTag() 메소드의 반환값 : SKIP_BODY, EVAL_BODY_INCLUDE 등
		//SKIP_BODY : 태그 내용이 존재하지 않을 경우의 반환값 - 기본
		//EVAL_BODY_INCLUDE : 태그 내용이 존재할 경우의 반환값
		return SKIP_BODY;
	}

	//JSP 문서에서 커스텀 태그의 종료태그를 사용할 경우 호출되는 메소드
	@Override
	public int doEndTag() throws JspException {
		//System.out.println("[정보]HelloTag 클래스의 doEndTag() 메소드 호출");
		
		//doEndTag() 메소드의 반환값 : EVAL_PAGE, SKIP_PAGE  등
		//EVAL_PAGE : 종료태그 사용 후 JSP 문서를 계속 실행할 경우의 반환값 - 기본
		//SKIP_PAGE : 종료태그 사용 후 JSP 문서를 강제로 종료할 경우의 반환값
		return EVAL_PAGE;
		//return SKIP_PAGE;
	}
}









