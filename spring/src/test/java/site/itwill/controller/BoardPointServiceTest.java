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
//�׽�Ʈ �޼ҵ尡 ���� �� ����� ��� �׽�Ʈ �޼ҵ��� ���� ���� ����
//@FixMethodOrder(MethodSorters sorter) : �׽�Ʈ �޼ҵ��� ���� ������ �����ϴ� ������̼�
// => MethodSorters.DEFAULT(�⺻) : �׽�Ʈ �޼ҵ��� HashCode(�޸� �ּ�)�� �̿��Ͽ� ���� ���� ����(���� �Ұ���)
// => MethodSorters.JVM : JVM�� ���� �׽�Ʈ �޼ҵ尡 �޸𸮿� ����� ������� ���� ������ ����
// => MethodSorters.NAME_ASCENDING : �׽�Ʈ �޼ҵ��� �̸������� ���� ������ ����
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
		userPoint.setName("�Ӳ���");
		
		UserPoint searchUserPoint=userPointService.addUserPoint(userPoint);
		
		logger.info("���̵� = "+searchUserPoint.getId()+", �̸� = "
			+searchUserPoint.getName()+", ����Ʈ = "+searchUserPoint.getPoint());
	}
	*/
	
	@Autowired
	private BoardPointService boardPointService;
	
	/*
	@Test
	public void testAddBoardPoint() {
		BoardPoint boardPoint=new BoardPoint();
		boardPoint.setSubject("����-7");
		boardPoint.setWriter("aaa");
		
		UserPoint userPoint=boardPointService.addBoardPoint(boardPoint);
		logger.info("���̵� = "+userPoint.getId()+", �̸� = "
				+userPoint.getName()+", ����Ʈ = "+userPoint.getPoint());
	}

	@Test
	public void testEraseBoardPoint() {
		UserPoint userPoint=boardPointService.removeBoardPoint(2);
		logger.info("���̵� = "+userPoint.getId()+", �̸� = "
			+userPoint.getName()+", ����Ʈ = "+userPoint.getPoint());
	}
	 */
	
	@Test
	public void testGetBoardPointList() {
		List<BoardPoint> boardPointList=boardPointService.getBoardPointList();
		for(BoardPoint boardPoint:boardPointList) {
			logger.info("�۹�ȣ = "+boardPoint.getNum()+", ���� = "
				+boardPoint.getSubject()+", �ۼ��� = "+boardPoint.getWriter());
		}
	}
}
