package site.itwill10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.itwill10.dao.BoardPointDAO;
import site.itwill10.dao.UserPointDAO;
import site.itwill10.dto.BoardPoint;
import site.itwill10.dto.UserPoint;

//서비스 클래스의 메소드에서 예외가 발생될 경우 이미 실행된 DAO 클래스의
//메소드에 SQL 명령(INSERT, DELETE, UPDATE)은 반드시 모두 ROLLBACK 처리되도록 작성
// => Spring Framework에서 제공하는 TransactionManager를 이용하여 일관성 있는 트렌젝션 처리
@Service
public class BoardPointServiceImpl implements BoardPointService {
	@Autowired
	private BoardPointDAO boardPointDAO;	
	
	@Autowired
	private UserPointDAO userPointDAO;
	
	
	//게시글 정보를 전달받아 BOARDPOINT 테이블에 저장하고 USERPOINT 테이블에
	//저장된 게시글 작성자의 포인트를 증가한 후 작성자 정보를 검색하여 반환
	//하는 메소드
	//@Transactional : 메소드에서 예외가 발생될 경우 ROLLBACK 처리되도록 설정하는 어노테이션
	@Transactional
	@Override
	public UserPoint addBoardPoint(BoardPoint boardPoint) {
		/*
		if(userPointDAO.selectUserPoint(boardPoint.getWriter())==null) {
			throw new RuntimeException("아이디가 존재하지 않는 작성자입니다.");
		}
		*/
		boardPointDAO.insertBoardPoint(boardPoint);
		if(userPointDAO.selectUserPoint(boardPoint.getWriter())==null) {
			throw new RuntimeException("아이디가 존재하지 않는 작성자입니다.");
		}		
		userPointDAO.plusUserPoint(boardPoint.getWriter());
		return userPointDAO.selectUserPoint(boardPoint.getWriter());
	}

	//게시글 번호를 전달받아 BOARDPOINT 테이블에 저장된 게시글을 삭제하고 
	//USERPOINT 테이블에 저장된 게시글 작성자의 포인트를 감소한 후 작성자 
	//정보를 검색하여 반환하는 메소드
	@Transactional
	@Override
	public UserPoint eraseBoardPoint(int num) {
		if(boardPointDAO.selectBoardPoint(num)==null) {
			throw new RuntimeException("존재하지 않는 게시글번호입니다.");
		}
		String writer=boardPointDAO.selectBoardPoint(num).getWriter();		
		boardPointDAO.deleteBoardPoint(num);
		userPointDAO.minusUserPoint(writer);
		return userPointDAO.selectUserPoint(writer);
	}

	//BOARDPOINT 테이블에 저장된 모든 게시글을 검색하여 반환하는 메소드
	@Override
	public List<BoardPoint> getBoardPointList() {
		return boardPointDAO.selectAllBoardPoint();
	}
}