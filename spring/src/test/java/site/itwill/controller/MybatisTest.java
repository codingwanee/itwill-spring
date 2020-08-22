package site.itwill.controller;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MybatisTest {
	private final static Logger logger=LoggerFactory.getLogger(MybatisTest.class);

	@Autowired
	private SqlSessionFactoryBean sqlSessionFactoryBean;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void testMybatis() {
		logger.info("sqlSessionFactoryBean = "+sqlSessionFactoryBean);
		logger.info("SqlSession = "+sqlSession);
	}
}
