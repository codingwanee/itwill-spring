package site.itwill04.bean;

public class InitDestroyMethodBean {
	public InitDestroyMethodBean() {
		System.out.println("### InitDestroyMethodBean Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	//�ν��Ͻ� ���� �� �ѹ��� �ڵ� ȣ��Ǿ� �ʱ�ȭ �۾��� �����ϴ� �޼ҵ�
	public void init() {
		System.out.println("*** InitDestroyMethodBean Ŭ������ init() �޼ҵ� ȣ�� ***");
	}
	
	public void destroy() {
		System.out.println("*** InitDestroyMethodBean Ŭ������ destroy() �޼ҵ� ȣ�� ***");
	}
	
	//�ν��Ͻ� �Ҹ� �� �ѹ��� �ڵ� ȣ��Ǿ� ������ �۾��� �����ϴ� �޼ҵ�
	public void display() {
		System.out.println("*** InitDestroyMethodBean Ŭ������ display() �޼ҵ� ȣ�� ***");
	}
}
