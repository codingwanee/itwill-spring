package site.itwill06.oop;

public class AopMain {
	public static void main(String[] args) {
		/*
		AopOne one=new AopOne();
		AopTwo two=new AopTwo();
		
		one.display1();
		one.display2();
		one.display3();
		
		two.display1();
		two.display2();
		two.display3();
		*/
		
		AopProxy proxyOne=new AopProxy(new AopOne());
		AopProxy proxyTwo=new AopProxy(new AopTwo());
		
		proxyOne.display1();
		proxyOne.display2();
		proxyOne.display3();
		
		proxyTwo.display1();
		proxyTwo.display2();
		proxyTwo.display3();
	}
}





