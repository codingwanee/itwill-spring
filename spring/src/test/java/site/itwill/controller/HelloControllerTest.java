package site.itwill.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//���ϵ� ����(*)�� �̿��Ͽ� Bean Configuration File ����
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class HelloControllerTest {
	private final static Logger logger=LoggerFactory.getLogger(HelloControllerTest.class);
	
	//WebApplicationContext : Bean Configuration File�� ������ Ŭ������ 
	//Spring Bean���� ����ϱ� ���� �ν��Ͻ�(Spring Container)
	@Autowired
	private WebApplicationContext wac;
	
	//MockMvc : ��û�� ���� ����� �������� �����ϱ� ���� Ŭ����
	private MockMvc mvc;
	
	//@Before : �׽�Ʈ �޼ҵ� ȣ�� �� ����� ����� �ۼ��� �޼ҵ忡 �����ϴ� ������̼�  
	@Before
	public void setup() {
		//��û�� ���� ����� �����ϴ� �ν��Ͻ��� ��ȯ�޾� ����
		mvc=MockMvcBuilders.webAppContextSetup(wac).build();
		logger.info("MockMvc �ν��Ͻ� ����");
	}
	
	@Test
	public void testHello() throws Exception {
		//MockMvc.perform(RequestBuilder requestBuilder)
		// => �������� ���� �ڿ� ��û - ��ûó�� �޼ҵ� �ڵ� ȣ��
		//RequestBuilder.get(String url) : GET ������� URL ��û 
		mvc.perform(MockMvcRequestBuilders.get("/hello"));
	}
}