package site.itwill02.factory;

public class MessagePrint {
	public void messagePrint() {
		//Factory Ŭ�����κ��� �������̽��� ��ӹ��� �ڽ� �ν��Ͻ��� ��ȯ�޾� ����
		MessageObject object=MessageObjectFactory.getFactory().getMessageObject();
		//���������� ����� �ڽ� �ν��Ͻ��� ���� �ٸ� Ŭ������ �޼ҵ� ȣ�� - �������̵忡 ���� ������
		String message=object.getMessage();
		System.out.println("message = "+message);
	}
}
