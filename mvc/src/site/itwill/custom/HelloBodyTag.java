package site.itwill.custom;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//태그 속성과 태그 내용이 있는 태그 클래스
public class HelloBodyTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	//필수 속성으로 설정된 속성값 저장하기 위한 필드
	// => 필수 속성이므로 생성자에서 초기화 작업 생략
	private boolean test;

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}
	
	@Override
	public int doStartTag() throws JspException {
		try {
			if(test) {
				pageContext.getOut().println("<h3>");
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}
		//태그 내용을 브라우저에 전달하여 출력
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doEndTag() throws JspException {
		try {
			if(test) {
				pageContext.getOut().println("님 안녕하세요.</h3>");
			} else {
				pageContext.getOut().println("님 안녕하세요.<br>");
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}
		return EVAL_PAGE;
	}
}





