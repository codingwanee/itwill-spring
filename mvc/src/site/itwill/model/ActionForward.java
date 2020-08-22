package site.itwill.model;

//��(View) ������(JSP ����)�� ������ �̵��ϰų� �ٸ� �������� ��û�ǵ��� 
//�����̷�Ʈ �̵��� �� �ִ� ������ �����ϱ� ���� Ŭ����
public class ActionForward {
	//������ �̵� �Ǵ� �����̷�Ʈ �̵��� ���� ������ �����Ͽ� �����ϱ� ���� �ʵ�
	// => false : �����̷�Ʈ �̵�, true : ������ �̵�
	private boolean forward;
	//�̵� JSP ����(������) �Ǵ� ��û �������� URL �ּ�(�����̷�Ʈ)�� �����ϱ� ���� �ʵ�
	private String path;
	
	public ActionForward() {
		// TODO Auto-generated constructor stub
	}

	public boolean isForward() {
		return forward;
	}

	public void setForward(boolean forward) {
		this.forward = forward;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
