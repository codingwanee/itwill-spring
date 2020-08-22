package site.itwill00.log;

public class HelloWorld {
	public String hello(String name) {
		System.out.println("HelloWorld 클래스의 hello 메소드 - start");
		String message="Hello. "+name+"!!!";
		System.out.println("HelloWorld 클래스의 hello 메소드 - end");
		return message;
	}
}
