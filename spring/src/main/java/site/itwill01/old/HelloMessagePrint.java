package site.itwill01.old;

//프로그램에 필요한 기능을 메소드로 제공하기 위한 클래스 - 모듈
public class HelloMessagePrint {
	public void helloMessagePrint() {
		HelloMessageObject object=new HelloMessageObject();
		String message=object.getHelloMessage();
		System.out.println("message = "+message);
	}
}
