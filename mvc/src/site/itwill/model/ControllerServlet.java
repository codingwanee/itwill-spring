package site.itwill.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��Ʈ�ѷ�(Controller) : Ŭ���̾�Ʈ(������)�� ��� ��û�� �޾� �ʿ��� ��(Model)��
//�̿��Ͽ� ��û ó�� �� ó������� ��(View)�� �����ϴ� ����� ����

//1.Ŭ���̾�Ʈ�� ��� ��û�� ���� �� �ִ� ���� ������ ��� ����
//@WebServlet(String url) : ���� ��ϰ� URL ���� ����� ������̼�
// => URL �ּ� ��� ����(Pattern - * �Ǵ� ?)�� �̿��Ͽ� ���� ����
//Ŭ���̾�Ʈ���� "~.do" ������ URL �ּҷ� ��û�� ��� ����Ǵ� ����
//@WebServlet("*.do")
//@WebServlet ������̼� ��� web.xml ������ �����Ͽ� ���� ��ϰ� URL ����
// => �ҽ����� ���� ���� �پ��� ȯ�漳�� ����
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//��û����(Key)�� Model �ν��Ͻ�(Value)�� �������� �����ϱ� ���� �ʵ�
	private Map<String, Action> actionMap;
	
	//���� Ŭ������ �ν��Ͻ��� �����ϱ� ���� ������ - �ʱ�ȭ �۾�
	/*
	public ControllerServlet() {
		//actionMap=new HashMap<String, Action>();
		System.out.println("# ControllerServlet Ŭ������ ������ ȣ�� #");
	}
	*/
	
	//���� Ŭ������ �ν��Ͻ��� ������ �� ���� ���� ȣ��Ǵ� �޼ҵ� - 1���� ȣ��
	// => �����ں��� �پ��� ������ �ʱ�ȭ �۾� ����
	@Override
	public void init(ServletConfig config) throws ServletException {
		//HashMap �ν��Ͻ��� �����Ͽ� actionMap �ʵ忡 ����
		actionMap=new HashMap<String, Action>();
		
		//��û������ ��û�� ���� �� Ŭ������ �ν��Ͻ��� actionMap �ʵ忡 ����
		// => Ŭ���̾�Ʈ ��û���� �̸� Map �ν��Ͻ��� ��û������ Model �ν��Ͻ� ����
		// => ��û�� ���� Model �ν��Ͻ��� �޼ҵ� ���� �ӵ� ����
		/*
		actionMap.put("/loginForm.do", new LoginFormModel());
		actionMap.put("/login.do", new LoginModel());
		actionMap.put("/logout.do", new LogoutModel());
		actionMap.put("/writeForm.do", new WriteFormModel());
		actionMap.put("/write.do", new WriteModel());
		actionMap.put("/list.do", new ListModel());
		actionMap.put("/view.do", new ViewModel());
		actionMap.put("/modifyForm.do", new ModifyFormModel());
		actionMap.put("/modify.do", new ModifyModel());
		actionMap.put("/remove.do", new RemoveModel());
		actionMap.put("/error.do", new ErrorModel());
		*/
		
		//Properties ���Ͽ� ����� ������ �̿��Ͽ� ��û������ Model �ν��Ͻ��� actionMap �ʵ忡 �߰�
		// => Properties File(~.properties) : ���α׷� ���࿡ �ʿ��� ������ �����ϱ� ���� �ؽ�Ʈ ����
		
		//Properties ������ �̸��� web.xml ���Ͽ��� �����޾� ����
		//ServletConfig.getInitParameter(String parameterName) 
		// => web.xml ���Ͽ� ��ϵǾ� �����ϴ� ������ ��ȯ�ϴ� �޼ҵ�
		// => Properties ������ ��ΰ� ����ŵ� ��Ʈ�ѷ� �̺���
		String configFile=config.getInitParameter("configFile");
		
		//Properties ������ ���� ���� �ý����� �����θ� ��ȯ�޾� ����
		//ServletConfig.getServletContext() : ServletContext �ν��Ͻ�(���ؽ�Ʈ ����)�� ��ȯ�ϴ� �޼ҵ�
		//ServletContext.getRealPath(String filePath) :  ���ؽ�Ʈ�� �����ϴ� ������ ���� �ý��� ��θ� ��ȯ�ϴ� �޼ҵ�
		//String configFilePath=config.getServletContext().getRealPath("/WEB-INF/model.properties");
		String configFilePath=config.getServletContext().getRealPath(configFile);
		//System.out.println("configFilePath = "+configFilePath);
		
		//Properties �ν��Ͻ� ���� - Properties ������ �������� �����Ͽ� �����ϱ� ���� �ν��Ͻ�
		Properties properties=new Properties();
		
		try {
			//Properties ������ ������ �б� ���� �Է½�Ʈ�� ����
			FileInputStream fin=new FileInputStream(configFilePath);
			
			//Properties ������ ������ �о� Properties �ν��Ͻ��� ����
			//Properties.load(InputStrean in) : �Է½�Ʈ���� �̿��Ͽ� Properties �ν��Ͻ��� ���� �����ϴ� �޼ҵ�
			properties.load(fin);
			
			//�Է½�Ʈ�� ����
			fin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Properties �ν��Ͻ��� ����� ������ �̿��Ͽ� Map �ν��Ͻ��� ���� - �ϰ�ó��
		//Properties.keySet() : Properties �ν��Ͻ��� ����� ��� Ű���� ��ȯ�ϴ� �޼ҵ�
		for(Object key:properties.keySet()) {
			//Properties �ν��Ͻ��� ����� Ű(��û����)�� ��ȯ�޾� ����
			String actionCommand=(String)key;
			
			//Properties �ν��Ͻ��� ����� ��(Model Ŭ���� �̸�)�� ��ȯ�޾� ����
			//Properties.get(String key) : Ű�� ���� ����� ���� ��ȯ�ϴ� �޼ҵ�
			String actionClassName=(String)properties.get(key);
			//System.out.println(actionCommand+" = "+actionClassName);
			
			try {
				//Model Ŭ���� �̸��� �̿��Ͽ� Model �ν��Ͻ� ���� - ���÷��� ��� �̿�
				//Class.forName(String className) : Ŭ������ �о� �޸𸮿� �����ϴ� �޼ҵ�
				// => Class �ν��Ͻ�(Clazz) ��ȯ
				//Class.newInstance() : �޸𸮿� ����� Ŭ������ �⺻ �����ڸ� �̿��Ͽ� �ν��Ͻ� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
				Action actionObject=(Action)Class.forName(actionClassName).newInstance();
				
				//Map �ν��Ͻ��� ��û������ Model �ν��Ͻ��� ����
				actionMap.put(actionCommand, actionObject);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//Ŭ���̾�Ʈ�� ��� ����� ��û�� ���� ó���� ������ ���� �ڵ� ȣ��Ǵ� �޼ҵ� - �ݺ� ȣ��
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("# ControllerServlet Ŭ������ service() �޼ҵ� ȣ��");
		
		//2.Ŭ���̾�Ʈ�� ��û �м� => http://localhost:8000/mvc/XXX.do
		
		//HttpServletRequest.getRequestURI() : ��û URL �ּ��� URI ���� ��ȯ�ϴ� �޼ҵ� => /mvc/XXX.do
		String requestURI=request.getRequestURI();
		//System.out.println("requestURI = "+requestURI);
	
		//HttpServletRequest.getContextPath() : ��û URL �ּ��� ���ؽ�Ʈ ��θ� ��ȯ�ϴ� �޼ҵ� => /mvc
		String contentPath=request.getContextPath();
		//System.out.println("contentPath = "+contentPath);
		
		//URI ������ ���ؽ�Ʈ ��θ� ������ ���ڿ��� �и��Ͽ� ���� => /XXX.do
		String command=requestURI.substring(contentPath.length());
		//System.out.println("command = "+command);
		
		//3.��û������ ���� �ʿ��� ��(Model) Ŭ������ �ν��Ͻ��� �����Ͽ� ó�� �޼ҵ� ȣ��
		// => �� Ŭ������ ó�� �޼ҵ��� ȣ�� ���(�̵���İ� URL �ּ�)�� ��ȯ�޾� ����
		//�α��� �Է������� : /loginForm.do - Model : LoginFormModel >> ������ �̵�(View : user_login.jsp) 
		//�α��� ó�������� : /login.do - Model : LoginModel >> �����̷�Ʈ �̵�(/loginForm.do)
		//�α׾ƿ� ó�������� : /logout.do - Model : LogoutModel >> �����̷�Ʈ �̵�(/loginForm.do)
		//ȸ����� �Է������� : /writeForm.do - Model : WriteFormModel >> ������ �̵�(View : user_write.jsp)
		//ȸ����� ó�������� : /write.do - Model : WriteModel >> �����̷�Ʈ �̵�(/loginForm.do)
		//ȸ����� ��������� : /list.do - Model : ListModel >> ������ �̵�(View : user_list.jsp)
		//ȸ���� ��������� : /view.do - Model : ViewModel >> ������ �̵�(View : user_view.jsp)
		//ȸ������ �Է������� : /modifyForm.do - Model : ModifyFormModel >> ������ �̵�(View : user_modify.jsp)
		//ȸ������ ó�������� : /modify.do - Model : ModifyModel >> �����̷�Ʈ �̵�(/view.do)
		//ȸ������ ó�������� : /remove.do - Model : RemoveModel >> �����̷�Ʈ �̵�(/list.do)
		//�����޼��� ��������� : /error.do - Model : ErrorModel >> ������ �̵�(View : user_error.jsp)
		
		/*
		//�� Ŭ����(�ڽ�)�� �ν��Ͻ��� �����ϱ� ���� �������̽�(�θ�)�� �������� ����
		Action action=null;
		
		//��û������ ���Ͽ� �� Ŭ������ �ν��Ͻ� �����Ͽ� ���������� ����
		if(command.equals("/loginForm.do")) {
			action=new LoginFormModel();	
		} else if(command.equals("/login.do")) {
			action=new LoginModel();		
		} else if(command.equals("/logout.do")) {
			action=new LogoutModel();	
		} else if(command.equals("/writeForm.do")) {
			action=new WriteFormModel();
		} else if(command.equals("/write.do")) {
			action=new WriteModel();
		} else if(command.equals("/list.do")) {
			action=new ListModel();
		} else if(command.equals("/view.do")) {
			action=new ViewModel();
		} else if(command.equals("/modifyForm.do")) {
			action=new ModifyFormModel();
		} else if(command.equals("/modify.do")) {
			action=new ModifyModel();
		} else if(command.equals("/remove.do")) {
			action=new RemoveModel();
		} else if(command.equals("/error.do")) {
			action=new ErrorModel();
		} else {//��û������ �������� ���� ��� - ���������� ��û
			action=new ErrorModel();
		}
		*/
		
		//��û����(Key)�� �̿��Ͽ� actionMap �ʵ忡 ����� Model �ν��Ͻ�(Value)�� ��ȯ�޾� ����
		Action action=actionMap.get(command);
	
		//��û����(Key)�� �������� ���� ��� ���������� ����
		if(action==null) {
			action=actionMap.get("/error.do");
		}
		
		//���������� ����� �� �ν��Ͻ��� ��û ó�� �޼ҵ� ȣ���Ͽ� ���(�̵�����)�� ��ȯ�޾� ����
		ActionForward actionForward=action.execute(request, response);
		
		//4.��ȯ���� ����� �̿��Ͽ� ������ �̵� ó��
		if(actionForward.isForward()) {//������ �̵� 
			//�ٸ� �����ø����̼����� ������(���α׷��� �帧)�� �̵� - ����� �̵�
			// => Ŭ���̾�Ʈ �������� �ּ�â�� ��ȭ�� ������ request scope�� ��ü ���� ����
			//HttpServletRequest.getRequestDispatcher(String path) 
			// => ������� �̵��ϱ� ���� RequestDispatcher �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ� 
			//RequestDispatcher.forward(ServletRequest Request, ServletResponse response)
			// => RequestDispatcher �ν��Ͻ��� ������� �̵��ϴ� �޼ҵ� 
			request.getRequestDispatcher(actionForward.getPath()).forward(request, response);
		} else {//�����̷�Ʈ �̵�
			//Ŭ���̾�Ʈ���� URL �ּҸ� �����Ͽ� ���û �ϵ��� ����
			// => Ŭ���̾�Ʈ �������� �ּ�â�� ��ȭ�� ������ request scope�� ��ü ���� �Ұ���
			response.sendRedirect(actionForward.getPath());
		}
	}
}
