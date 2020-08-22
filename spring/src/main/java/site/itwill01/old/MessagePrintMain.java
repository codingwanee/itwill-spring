package site.itwill01.old;

//모듈에서 제공되는 기능을 이용하여 작성된 프로그램
//전통적인 프로그램 작성 방법
// => 개발자가 인스턴스를 생성하여 메소드 호출
// => 클래스(인스턴스)의 결합도가 높기 때문에 유지보수의 효율성이 낮다.
public class MessagePrintMain {
	public static void main(String[] args) {
		/*
		HelloMessagePrint print=new HelloMessagePrint();
		print.helloMessagePrint();
		*/
		
		/*
		HiMessagePrint print=new HiMessagePrint();
		print.hiMessagePrint();
		*/
		
		GoodbyeMessagePrint print=new GoodbyeMessagePrint();
		print.goodbyeMessagePrint();
	}
}
