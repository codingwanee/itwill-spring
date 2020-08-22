package site.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Front Controller : Ŭ���̾�Ʈ�� ��� ��û�� �޾� ��û URL �ּҸ� �м��Ͽ�
//��û�� ���� ó���� ������ Ŭ����(Model)�� �޼ҵ� ȣ���Ͽ� ��ȯ�� �����
//JSP ����(View)�� �����ϴ� ����� �����ϴ� ���� ������ ��Ȱ�� Ŭ����(����)
// => web.xml ���Ͽ� Ŭ������ �������� ����ϰ� URL ���� ó��
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Ŭ���̾�Ʈ ��û�� ���� ���� ����� �����ϱ� ���� �޼ҵ�
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.Ŭ���̾�Ʈ�� ��û URL �ּ� �м� - Ŭ���̾�Ʈ�� �䱸���� �ľ�
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=requestURI.substring(contextPath.length());
		
		//2.��û�� ���� ó�� Ŭ����(Model)�� �ν��Ͻ��� ��ȯ�޾� �޼ҵ� ȣ��
		// => ó�� Ŭ���� : Model >> Command Controller
		/*
		Controller controller=null;
		if(command.equals("/list.itwill")) {
			controller=new ListController();
		} else if(command.equals("/view.itwill")) {
			controller=new ViewController();
		}
		*/

		HandlerMapping handlerMapping=new HandlerMapping();
		//��û������ �����Ͽ� ó�� �ν��Ͻ��� ��ȯ�޾� ����
		Controller controller=handlerMapping.getController(command);
		
		//��û ó�� Ŭ������ �޼ҵ带 ȣ���Ͽ� ���������� ������ ��ȯ�޾� ����
		String view=controller.handleRequest(request, response);
		
		//3.������������ ������ �̵��Ͽ� Ŭ���̾�Ʈ���� ������ ����
		ViewResolver viewResolver=new ViewResolver();
		String viewPage=viewResolver.getViewPage(view);
		
		request.getRequestDispatcher(viewPage).forward(request, response);
	}
	
}






