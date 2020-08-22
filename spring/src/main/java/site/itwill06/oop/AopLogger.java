package site.itwill06.oop;

//횡단관심코드로 작성된 메소드가 선언된 클래스 - Advice 클래스
public class AopLogger {
	public void beforeLog() {
		System.out.println("### 메소드의 명령 실행 전 콘솔 로그 기록 ###");
	}
}
