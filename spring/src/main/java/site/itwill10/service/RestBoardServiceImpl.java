package site.itwill10.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.itwill10.dao.RestBoardDAO;
import site.itwill10.dto.RestBoard;

@Service
public class RestBoardServiceImpl implements RestBoardService {
	@Autowired
	private RestBoardDAO restBoardDAO;

	@Transactional
	@Override
	public void addRestBoard(RestBoard board) {
		restBoardDAO.insertRestBoard(board);
	}

	@Transactional
	@Override
	public void modifyRestBoard(RestBoard board) {
		/*
		//테이블에 저장된 정보를 이용하여 전달값에 대한 유효성 검사
		if(restBoardDAO.selectRestBoard(board.getNum())==null) {
			//개발자가 작성한 예외 클래스로 예외 발생
			throw new Exception("변경하고자 하는 게시글이 존재하지 않습니다."); 
		}
		*/
		restBoardDAO.updateRestBoard(board);
	}

	@Transactional
	@Override
	public void eraseRestBoard(int num) {
		restBoardDAO.deleteRestBoard(num);
	}

	@Override
	public RestBoard getRestBoard(int num) {
		return restBoardDAO.selectRestBoard(num);
	}

	@Override
	public List<RestBoard> getRestBoardList(Map<String, Object> map) {
		return restBoardDAO.selectPageRestBoard(map);
	}

	@Override
	public int getCountRestBoard() {
		return restBoardDAO.selectCountRestBoard();
	}

}
