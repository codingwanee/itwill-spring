package site.itwill10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.itwill10.dao.BoardPointDAO;
import site.itwill10.dao.UserPointDAO;
import site.itwill10.dto.BoardPoint;
import site.itwill10.dto.UserPoint;

//���� Ŭ������ �޼ҵ忡�� ���ܰ� �߻��� ��� �̹� ����� DAO Ŭ������
//�޼ҵ忡 SQL ���(INSERT, DELETE, UPDATE)�� �ݵ�� ��� ROLLBACK ó���ǵ��� �ۼ�
// => Spring Framework���� �����ϴ� TransactionManager�� �̿��Ͽ� �ϰ��� �ִ� Ʈ������ ó��
@Service
public class BoardPointServiceImpl implements BoardPointService {
	@Autowired
	private BoardPointDAO boardPointDAO;	
	
	@Autowired
	private UserPointDAO userPointDAO;
	
	
	//�Խñ� ������ ���޹޾� BOARDPOINT ���̺� �����ϰ� USERPOINT ���̺�
	//����� �Խñ� �ۼ����� ����Ʈ�� ������ �� �ۼ��� ������ �˻��Ͽ� ��ȯ
	//�ϴ� �޼ҵ�
	//@Transactional : �޼ҵ忡�� ���ܰ� �߻��� ��� ROLLBACK ó���ǵ��� �����ϴ� ������̼�
	@Transactional
	@Override
	public UserPoint addBoardPoint(BoardPoint boardPoint) {
		/*
		if(userPointDAO.selectUserPoint(boardPoint.getWriter())==null) {
			throw new RuntimeException("���̵� �������� �ʴ� �ۼ����Դϴ�.");
		}
		*/
		boardPointDAO.insertBoardPoint(boardPoint);
		if(userPointDAO.selectUserPoint(boardPoint.getWriter())==null) {
			throw new RuntimeException("���̵� �������� �ʴ� �ۼ����Դϴ�.");
		}		
		userPointDAO.plusUserPoint(boardPoint.getWriter());
		return userPointDAO.selectUserPoint(boardPoint.getWriter());
	}

	//�Խñ� ��ȣ�� ���޹޾� BOARDPOINT ���̺� ����� �Խñ��� �����ϰ� 
	//USERPOINT ���̺� ����� �Խñ� �ۼ����� ����Ʈ�� ������ �� �ۼ��� 
	//������ �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	@Transactional
	@Override
	public UserPoint eraseBoardPoint(int num) {
		if(boardPointDAO.selectBoardPoint(num)==null) {
			throw new RuntimeException("�������� �ʴ� �Խñ۹�ȣ�Դϴ�.");
		}
		String writer=boardPointDAO.selectBoardPoint(num).getWriter();		
		boardPointDAO.deleteBoardPoint(num);
		userPointDAO.minusUserPoint(writer);
		return userPointDAO.selectUserPoint(writer);
	}

	//BOARDPOINT ���̺� ����� ��� �Խñ��� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	@Override
	public List<BoardPoint> getBoardPointList() {
		return boardPointDAO.selectAllBoardPoint();
	}
}