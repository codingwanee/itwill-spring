package site.itwill.custom;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//태그 속성이 있으며 태그 내용이 없는 태그 클래스
public class HelloMessageTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	
	//태그 속성값을 저장하기 위한 필드 - 태그 속성명과 동일한 이름으로 필드 선언
	private String name;
	
	//태그 클래스의 필드에 초기값 부여
	public HelloMessageTag() {
		//태그 속성을 사용하지 않을 경우 태그 속성값으로 사용될 초기값 부여
		// => 태그 속성이 필수인 경우 초기값 부여 생략
		name="홍길동";
	}

	public String getName() {
		return name;
	}

	//태그 속성을 사용할 경우 태그 속성값을 얻어와 필드값 변경
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int doStartTag() throws JspException {
		try {
			if(name.equals("홍길동")) {
				pageContext.getOut().println("<h3>관리자님 안녕하세요.</h3>");
			} else {
				pageContext.getOut().println("<h3>"+name+"님 안녕하세요.</h3>");
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}
	
	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
}







