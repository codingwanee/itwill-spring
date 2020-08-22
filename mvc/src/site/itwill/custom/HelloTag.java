package site.itwill.custom;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

//�±� Ŭ���� : JSP �������� Ŀ���� �±׸� ����� ��� ���ϴ� ����� �����ϴ� Ŭ����
// => TagSupport, BodyTagSupport, SimpleTagSupport Ŭ������ ��ӹ޾� �ۼ�

//�±� �Ӽ��� �±� ������ ���� �±� Ŭ����
public class HelloTag extends TagSupport {
	private static final long serialVersionUID = 1L;

	//JSP �������� Ŀ���� �±׸� ����� ��� �±� Ŭ������ �ν��Ͻ��� ������ �� ȣ��
	public HelloTag() {
		//System.out.println("[����]HelloTag Ŭ������ �⺻ ������ ȣ��");
	}
	
	//JSP �������� Ŀ���� �±��� �����±׸� ����� ��� ȣ��Ǵ� �޼ҵ�
	@Override
	public int doStartTag() throws JspException {
		//System.out.println("[����]HelloTag Ŭ������ doStartTag() �޼ҵ� ȣ��");
		
		//pageContext : Ŀ���� �±׸� ����� JSP ������ ���ؽ�Ʈ ������ �����ϴ� �ν��Ͻ�
		// => TagSupport Ŭ����(�θ�Ŭ����)�� ����� �ʵ�
		// => JSP �������� ��� ������ �ν��Ͻ� ���� - request, response, out, session ��
		//pageContext.getOut() : JspWriter �ν��Ͻ�(������ ��½�Ʈ��)�� ��ȯ�ϴ� �޼ҵ�
		try {
			pageContext.getOut().println("<div>�ȳ��ϼ���.</div>");
		} catch (IOException e) {
			e.printStackTrace();//�ֿܼ� ���� �޼��� ���
			throw new JspException(e.getMessage());//������ ���� �޼��� ���
		}
		
		//doStartTag() �޼ҵ��� ��ȯ�� : SKIP_BODY, EVAL_BODY_INCLUDE ��
		//SKIP_BODY : �±� ������ �������� ���� ����� ��ȯ�� - �⺻
		//EVAL_BODY_INCLUDE : �±� ������ ������ ����� ��ȯ��
		return SKIP_BODY;
	}

	//JSP �������� Ŀ���� �±��� �����±׸� ����� ��� ȣ��Ǵ� �޼ҵ�
	@Override
	public int doEndTag() throws JspException {
		//System.out.println("[����]HelloTag Ŭ������ doEndTag() �޼ҵ� ȣ��");
		
		//doEndTag() �޼ҵ��� ��ȯ�� : EVAL_PAGE, SKIP_PAGE  ��
		//EVAL_PAGE : �����±� ��� �� JSP ������ ��� ������ ����� ��ȯ�� - �⺻
		//SKIP_PAGE : �����±� ��� �� JSP ������ ������ ������ ����� ��ȯ��
		return EVAL_PAGE;
		//return SKIP_PAGE;
	}
}









