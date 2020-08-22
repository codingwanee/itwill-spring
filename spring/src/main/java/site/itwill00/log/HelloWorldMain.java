package site.itwill00.log;

public class HelloWorldMain {
	public static void main(String[] args) {
		System.out.println("HelloWorldMain 클래스의 main 메소드 - start");
		HelloWorld hw=new HelloWorld();
		String message=hw.hello("홍길동");
		System.out.println("message = "+message);
		System.out.println("HelloWorldMain 클래스의 main 메소드 - end");
	}
}
