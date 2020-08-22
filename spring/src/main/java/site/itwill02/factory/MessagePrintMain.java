package site.itwill02.factory;

//Factory 클래스를 이용하여 인스턴스를 제공받아 처리하는 프로그램
// => 개발자가 아닌 Factory 클래스가 인터페이스를 상속받은 자식 인스턴스를 생성하여 반환 - IoC : 제어의 역행
// => 인터페이스를 상속받은 자식 인스턴스 메소드 호출 - 다형성
// => 클래스(인스턴스)의 결합도를 낮추어 유지보수의 효율성 증가
public class MessagePrintMain {
	public static void main(String[] args) {
		MessagePrint print=new MessagePrint();
		print.messagePrint();
	}
}
