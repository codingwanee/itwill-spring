package site.itwill02.factory;

public class MessagePrint {
	public void messagePrint() {
		//Factory 클래스로부터 인터페이스를 상속받은 자식 인스턴스를 반환받아 저장
		MessageObject object=MessageObjectFactory.getFactory().getMessageObject();
		//참조변수에 저장된 자식 인스턴스에 따라 다른 클래스의 메소드 호출 - 오버라이드에 의해 다형성
		String message=object.getMessage();
		System.out.println("message = "+message);
	}
}
