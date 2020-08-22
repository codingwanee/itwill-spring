package site.itwill.custom;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//�±� �Ӽ��� �±� ������ �ִ� �±� Ŭ����
public class HelloBodyTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	//�ʼ� �Ӽ����� ������ �Ӽ��� �����ϱ� ���� �ʵ�
	// => �ʼ� �Ӽ��̹Ƿ� �����ڿ��� �ʱ�ȭ �۾� ����
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
		//�±� ������ �������� �����Ͽ� ���
		return EVAL_BODY_INCLUDE;
	}
	
	@Override
	public int doEndTag() throws JspException {
		try {
			if(test) {
				pageContext.getOut().println("�� �ȳ��ϼ���.</h3>");
			} else {
				pageContext.getOut().println("�� �ȳ��ϼ���.<br>");
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}
		return EVAL_PAGE;
	}
}





