package site.itwill01.old;

//���α׷��� �ʿ��� ����� �޼ҵ�� �����ϱ� ���� Ŭ���� - ���
public class HelloMessagePrint {
	public void helloMessagePrint() {
		HelloMessageObject object=new HelloMessageObject();
		String message=object.getHelloMessage();
		System.out.println("message = "+message);
	}
}
