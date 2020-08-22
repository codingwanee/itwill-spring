package site.itwill08.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataSourceMain {
	public static void main(String[] args) throws SQLException {
		ApplicationContext context=new ClassPathXmlApplicationContext("08_dao.xml");
		System.out.println("================================================================================================");
		DataSource apacheDataSource=context.getBean("apacheDataSource", DataSource.class);
		System.out.println("apacheDataSource.getConnection() = "+apacheDataSource.getConnection());
		System.out.println("================================================================================================");
		DataSource springDataSource=context.getBean("springDataSource", DataSource.class);
		System.out.println("springDataSource.getConnection() = "+springDataSource.getConnection());
		System.out.println("================================================================================================");
		((ClassPathXmlApplicationContext)context).close();
	}
}
