package site.itwill.custom;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//�±� �Ӽ��� ������ �±� ������ ���� �±� Ŭ����
public class HelloMessageTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	
	//�±� �Ӽ����� �����ϱ� ���� �ʵ� - �±� �Ӽ���� ������ �̸����� �ʵ� ����
	private String name;
	
	//�±� Ŭ������ �ʵ忡 �ʱⰪ �ο�
	public HelloMessageTag() {
		//�±� �Ӽ��� ������� ���� ��� �±� �Ӽ������� ���� �ʱⰪ �ο�
		// => �±� �Ӽ��� �ʼ��� ��� �ʱⰪ �ο� ����
		name="ȫ�浿";
	}

	public String getName() {
		return name;
	}

	//�±� �Ӽ��� ����� ��� �±� �Ӽ����� ���� �ʵ尪 ����
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int doStartTag() throws JspException {
		try {
			if(name.equals("ȫ�浿")) {
				pageContext.getOut().println("<h3>�����ڴ� �ȳ��ϼ���.</h3>");
			} else {
				pageContext.getOut().println("<h3>"+name+"�� �ȳ��ϼ���.</h3>");
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







