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

//@RunWith(JUnit4ClassRunner.class) : �׽�Ʈ ���α׷��� �����ϱ� ���� Ŭ����(Clazz)�� �����ϴ� ������̼�
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"URL", "URL", ...}) : �׽�Ʈ ���α׷� �ۼ���  
//�ʿ��� Spring Bean�� �����ޱ� ���� Bean Configuration File�� �����ϴ� ������̼�
// => ApplicationContext �ν��Ͻ�(Spring Container)�� �̿��Ͽ� Bean Configuration File�� ������ Ŭ������ Spring Bean���� ���
// => locations �Ӽ� : Bean Configuration File�� ��θ� �迭 �������� { } �ȿ� �����Ͽ� ���
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DataSourceTest {
	private final static Logger logger=LoggerFactory.getLogger(DataSourceTest.class);
	
	//Bean Configuration File���� ��ϵ� DataSource ���� Spring Bean�� �̿��Ͽ� ������ ó�� - DI
	@Autowired
	private DataSource ds;
	
	//@Test : �׽�Ʈ ������ �޼ҵ带 �����ϱ� ���� ������̼�
	@Test
	public void testDataSource() throws SQLException {
		logger.info("DataSource = "+ds);
		logger.info("Connection = "+ds.getConnection());
	}
}





