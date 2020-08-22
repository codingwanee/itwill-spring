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
//와일드 문자(*)를 이용하여 Bean Configuration File 설정
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class HelloControllerTest {
	private final static Logger logger=LoggerFactory.getLogger(HelloControllerTest.class);
	
	//WebApplicationContext : Bean Configuration File에 설정된 클래스를 
	//Spring Bean으로 등록하기 위한 인스턴스(Spring Container)
	@Autowired
	private WebApplicationContext wac;
	
	//MockMvc : 요청과 응답 기능을 가상으로 제공하기 위한 클래스
	private MockMvc mvc;
	
	//@Before : 테스트 메소드 호출 전 실행될 명령이 작성된 메소드에 설정하는 어노테이션  
	@Before
	public void setup() {
		//요청과 응답 기능을 제공하는 인스턴스를 반환받아 저장
		mvc=MockMvcBuilders.webAppContextSetup(wac).build();
		logger.info("MockMvc 인스턴스 생성");
	}
	
	@Test
	public void testHello() throws Exception {
		//MockMvc.perform(RequestBuilder requestBuilder)
		// => 가상으로 서버 자원 요청 - 요청처리 메소드 자동 호출
		//RequestBuilder.get(String url) : GET 방식으로 URL 요청 
		mvc.perform(MockMvcRequestBuilders.get("/hello"));
	}
}