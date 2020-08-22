package site.itwill07.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExecutionTimeMain {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("07-4_timer.xml");
		System.out.println("=========================================================================");
		context.getBean("executionTimeBean", ExecutionTimeBean.class).run();
		System.out.println("=========================================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
