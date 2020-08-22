package site.itwill09.mvc;

import java.util.HashMap;
import java.util.Map;

//Ŭ���̾�Ʈ ��û������ ó�� Ŭ������ �ν��Ͻ��� �����ϱ� ���� �ʵ尡 ����� Ŭ����
// => Ŭ���̾�Ʈ ��û������ �̿��Ͽ� ó�� Ŭ������ �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ� ����
public class HandlerMapping {
	//Key : Ŭ���̾�Ʈ ��û����(String), Value : ó�� Ŭ������ �ν��Ͻ�(Controller)
	private Map<String, Controller> mapping;
	
	public HandlerMapping() {
		mapping=new HashMap<String, Controller>();
		initConfig();
	}
	
	//Map �ʵ忡 Ŭ���̾�Ʈ ��û�� ó�� Ŭ������ �ν��Ͻ��� �����ϱ� ���� �޼ҵ�
	private void initConfig() {
		mapping.put("/list.itwill", new ListController());
		mapping.put("/view.itwill", new ViewController());
	}
	
	//Ŭ���̾�Ʈ ��û������ ���޹޾� ó�� Ŭ������ �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
	public Controller getController(String command) {
		return mapping.get(command);
	}
}



