package site.itwill06.oop;

//인스턴스의 메소드를 호출할 경우 메소드의 명령 실행 전에 로그로 기록되도록 설정
public class OopMain {
	public static void main(String[] args) {
		OopOne one=new OopOne();
		OopTwo two=new OopTwo();
		
		one.display1();
		one.display2();
		one.display3();
		
		two.display1();
		two.display2();
		two.display3();
	}
}
