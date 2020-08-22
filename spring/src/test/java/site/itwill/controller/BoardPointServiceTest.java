package site.itwill.controller;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import site.itwill10.dto.BoardPoint;
import site.itwill10.dto.UserPoint;
import site.itwill10.service.BoardPointService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
//테스트 메소드가 여러 개 선언된 경우 테스트 메소드의 실행 순서 지정
//@FixMethodOrder(MethodSorters sorter) : 테스트 메소드의 실행 순서를 설정하는 어노테이션
// => MethodSorters.DEFAULT(기본) : 테스트 메소드의 HashCode(메모리 주소)를 이용하여 실행 순서 결정(예측 불가능)
// => MethodSorters.JVM : JVM에 의해 테스트 메소드가 메모리에 저장된 순서대로 실행 순서가 결정
// => MethodSorters.NAME_ASCENDING : 테스트 메소드의 이름순으로 실행 순서가 결정
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardPointServiceTest {
	private final static Logger logger=LoggerFactory.getLogger(BoardPointServiceTest.class);
	
	/*
	@Autowired
	private UserPointService userPointService;
	
	@Test
	public void testAddUserPoint() {
		UserPoint userPoint=new UserPoint();
		userPoint.setId("xyz");
		userPoint.setName("임꺽정");
		
		UserPoint searchUserPoint=userPointService.addUserPoint(userPoint);
		
		logger.info("아이디 = "+searchUserPoint.getId()+", 이름 = "
			+searchUserPoint.getName()+", 포인트 = "+searchUserPoint.getPoint());
	}
	*/
	
	@Autowired
	private BoardPointService boardPointService;
	
	/*
	@Test
	public void testAddBoardPoint() {
		BoardPoint boardPoint=new BoardPoint();
		boardPoint.setSubject("연습-7");
		boardPoint.setWriter("aaa");
		
		UserPoint userPoint=boardPointService.addBoardPoint(boardPoint);
		logger.info("아이디 = "+userPoint.getId()+", 이름 = "
				+userPoint.getName()+", 포인트 = "+userPoint.getPoint());
	}

	@Test
	public void testEraseBoardPoint() {
		UserPoint userPoint=boardPointService.removeBoardPoint(2);
		logger.info("아이디 = "+userPoint.getId()+", 이름 = "
			+userPoint.getName()+", 포인트 = "+userPoint.getPoint());
	}
	 */
	
	@Test
	public void testGetBoardPointList() {
		List<BoardPoint> boardPointList=boardPointService.getBoardPointList();
		for(BoardPoint boardPoint:boardPointList) {
			logger.info("글번호 = "+boardPoint.getNum()+", 제목 = "
				+boardPoint.getSubject()+", 작성자 = "+boardPoint.getWriter());
		}
	}
}
