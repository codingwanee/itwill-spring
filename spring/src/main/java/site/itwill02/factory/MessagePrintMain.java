package site.itwill02.factory;

//Factory Ŭ������ �̿��Ͽ� �ν��Ͻ��� �����޾� ó���ϴ� ���α׷�
// => �����ڰ� �ƴ� Factory Ŭ������ �������̽��� ��ӹ��� �ڽ� �ν��Ͻ��� �����Ͽ� ��ȯ - IoC : ������ ����
// => �������̽��� ��ӹ��� �ڽ� �ν��Ͻ� �޼ҵ� ȣ�� - ������
// => Ŭ����(�ν��Ͻ�)�� ���յ��� ���߾� ���������� ȿ���� ����
public class MessagePrintMain {
	public static void main(String[] args) {
		MessagePrint print=new MessagePrint();
		print.messagePrint();
	}
}
