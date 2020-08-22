package site.itwill02.factory;

//Factory 디자인 패턴이 적용된 클래스 - Factory 클래스 또는 Provider 클래스
// => 특정 인스턴스를 생성하여 반환하는 메소드가 구현된 클래스
// => 싱글톤 클래스로 작성하는 것을 권장
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
	
	//원하는 형태의 인스턴스를 생성하여 반환하는 메소드
	//인터페이스를 반환형으로 설정한 경우 인터페이스를 상속받아 자식 인스턴스 반환
	public MessageObject getMessageObject() {
		//MessageObject object=new HelloMessageObject();
		//MessageObject object=new HiMessageObject();
		MessageObject object=new GoodbyeMessageObject();
		return object;
	}
}








