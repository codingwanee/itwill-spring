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
		//���̺� ����� ������ �̿��Ͽ� ���ް��� ���� ��ȿ�� �˻�
		if(restBoardDAO.selectRestBoard(board.getNum())==null) {
			//�����ڰ� �ۼ��� ���� Ŭ������ ���� �߻�
			throw new Exception("�����ϰ��� �ϴ� �Խñ��� �������� �ʽ��ϴ�."); 
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
