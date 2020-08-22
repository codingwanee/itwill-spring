package site.itwill.controller;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(JUnit4ClassRunner.class) : 테스트 프로그램을 실행하기 위한 클래스(Clazz)를 설정하는 어노테이션
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"URL", "URL", ...}) : 테스트 프로그램 작성에  
//필요한 Spring Bean을 제공받기 위한 Bean Configuration File을 설정하는 어노테이션
// => ApplicationContext 인스턴스(Spring Container)를 이용하여 Bean Configuration File에 설정된 클래스를 Spring Bean으로 등록
// => locations 속성 : Bean Configuration File의 경로를 배열 형식으로 { } 안에 나열하여 등록
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DataSourceTest {
	private final static Logger logger=LoggerFactory.getLogger(DataSourceTest.class);
	
	//Bean Configuration File에서 등록된 DataSource 관련 Spring Bean을 이용하여 인젝션 처리 - DI
	@Autowired
	private DataSource ds;
	
	//@Test : 테스트 목적의 메소드를 설정하기 위한 어노테이션
	@Test
	public void testDataSource() throws SQLException {
		logger.info("DataSource = "+ds);
		logger.info("Connection = "+ds.getConnection());
	}
}





