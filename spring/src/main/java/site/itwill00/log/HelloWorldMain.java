package site.itwill00.log;

public class HelloWorldMain {
	public static void main(String[] args) {
		System.out.println("HelloWorldMain Ŭ������ main �޼ҵ� - start");
		HelloWorld hw=new HelloWorld();
		String message=hw.hello("ȫ�浿");
		System.out.println("message = "+message);
		System.out.println("HelloWorldMain Ŭ������ main �޼ҵ� - end");
	}
}
