package site.itwill02.factory;

//Factory ������ ������ ����� Ŭ���� - Factory Ŭ���� �Ǵ� Provider Ŭ����
// => Ư�� �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ尡 ������ Ŭ����
// => �̱��� Ŭ������ �ۼ��ϴ� ���� ����
public class MessageObjectFactory {
	private static MessageObjectFactory _factory;
	
	private MessageObjectFactory() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_factory=new MessageObjectFactory();
	}
	
	public static MessageObjectFactory getFactory() {
		return _factory;
	}
	
	//���ϴ� ������ �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	//�������̽��� ��ȯ������ ������ ��� �������̽��� ��ӹ޾� �ڽ� �ν��Ͻ� ��ȯ
	public MessageObject getMessageObject() {
		//MessageObject object=new HelloMessageObject();
		//MessageObject object=new HiMessageObject();
		MessageObject object=new GoodbyeMessageObject();
		return object;
	}
}








