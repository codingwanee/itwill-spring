package site.itwill.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//Filter Ŭ���� : Ŭ���̾�Ʈ�� Ư�� ��û�� ���� ��û����(Request)�� �����ϰų�
//��������(Response)�� �����ϱ� ���� Ŭ���� => Filter �������̽��� ��ӹ޾� �ۼ� 

//EncodingFilter : Ŭ���̾�Ʈ�� ��� ��û�� ���� ��û������ ĳ���ͼ��� �����ϴ� ���� Ŭ����
// => @WebFilter ������̼� �Ǵ� web.xml ������ �̿��Ͽ� ���� ��ϰ� ��û URL ���� ����
public class EncodingFilter implements Filter {
	//������ ĳ���ͼ¿� ���� ���ڵ� ������ �����ϱ� ���� �ʵ�
	private String encoding;
	
	//����Ŭ������ �ν��Ͻ��� ������ �� ���� ���� ȣ��Ǵ� �޼ҵ� - �ʱ�ȭ �۾�(�ѹ��� ����)
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//encoding="UTF-8";
		
		//FilterConfig.getInitParameter(String parameterName)
		// => web.xml ������ filter ������Ʈ���� �����ϴ� ���� ���� ��ȯ�ϴ� �޼ҵ�
		encoding=filterConfig.getInitParameter("encoding");
	}
	
	//Ŭ���̾�Ʈ ��û�� ���� ���۵Ǵ� ��� ȣ��Ǵ� �޼ҵ�
	// => ��û����(Request)�� �����ϰų� ��������(Response)�� �����ϴ� �޼ҵ�
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//��û���� ���� - �Է°��� ���� ĳ���ͼ� ����
		if(request.getCharacterEncoding()==null || 
				!request.getCharacterEncoding().equals(encoding)) {
			request.setCharacterEncoding(encoding);
		}
		
		//Ŭ���̾�Ʈ�� ��û�� ó���ϴ� ������(Servlet �Ǵ� JSP)�� ����
		//FilterChain.doFilter(ServletRequest request,ServletResponse response)
		// => Ŭ���̾�Ʈ�� ���� ��û������ ����ǵ��� ó���ϴ� �޼ҵ�
		chain.doFilter(request, response);
		
		//�������� ����
		//response.setCharacterEncoding("UTF-8");
	}

}
