package site.itwill06.oop;

public class OopOne {
	//�޼ҵ忡 �ߺ��� ���(�ڵ�)�� ������ ��� �ߺ��ڵ尡 ����� �޼ҵ带 
	//�����Ͽ� �ߺ��ڵ� ��� �޼ҵ带 ȣ���Ͽ� ���
	// => �ߺ��ڵ带 �ּ�ȭ�Ͽ� ���������� ȿ���� ����
	/*
	public void beforeLog() {
		System.out.println("### �޼ҵ��� ��� ���� �� �ܼ� �α� ��� ###");
	}
	*/
	
	private OopLogger logger=new OopLogger();//����
	
	public void display1() {
		//System.out.println("### �޼ҵ��� ��� ���� �� �ܼ� �α� ��� ###");
		//beforeLog();
		logger.beforeLog();		
		System.out.println("*** OopOne Ŭ������ display1() �޼ҵ� ȣ�� *** ");
	}
	
	public void display2() {
		//System.out.println("### �޼ҵ��� ��� ���� �� �ܼ� �α� ��� ###");
		//beforeLog();
		logger.beforeLog();		
		System.out.println("*** OopOne Ŭ������ display2() �޼ҵ� ȣ�� *** ");
	}
	
	public void display3() {
		//System.out.println("### �޼ҵ��� ��� ���� �� �ܼ� �α� ��� ###");
		//beforeLog();
		logger.beforeLog();		
		System.out.println("*** OopOne Ŭ������ display3() �޼ҵ� ȣ�� *** ");
	}
}
