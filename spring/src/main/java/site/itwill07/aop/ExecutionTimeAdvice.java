package site.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

public class ExecutionTimeAdvice {
	private final static Logger logger=LoggerFactory.getLogger(ExecutionTimeAdvice.class);
	
	//핵심관심모듈(타겟메소드)의 명령이 실행될 경우 처리시간(ms)을 계산하여 기록하기 위한 메소드 - around
	public Object timeWatch(ProceedingJoinPoint joinPoint) throws Throwable {
		/*
		//핵심관심모듈 명령 실행 전에 시스템의 현재 시간정보(Timestamp : ms)를 반환받아 저장
		long startTime=System.currentTimeMillis();
		
		//핵심관심모듈 호출 - 타겟메소드의 명령 실행
		Object object=joinPoint.proceed();
		
		//핵심관심모듈 명령 실행 후에 시스템의 현재 시간정보를 반환받아 저장
		long stopTime=System.currentTimeMillis();
		
		//핵심관심모듈 처리시간 기록
		logger.info("실행시간 = "+(stopTime-startTime)+"ms");
		*/

		//StopWatch : 시간을 측정하기 위한 기능을 제공하는 클래스
		StopWatch stopWatch=new StopWatch();
		
		//StopWatch.start() : 시간 측정 시작 메소드
		stopWatch.start();
		
		Object object=joinPoint.proceed();

		//StopWatch.stop() : 시간 측정 종료 메소드
		stopWatch.stop();
		
		//StopWatch.getTotalTimeMillis() : 측정된 시간을 ms 단위로 반환하는 메소드
		logger.info("실행시간 = "+stopWatch.getTotalTimeMillis()+"ms");
		
		//핵심관심모듈 처리결과 반환
		return object;
	}
}




