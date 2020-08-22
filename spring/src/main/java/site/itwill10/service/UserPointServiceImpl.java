package site.itwill10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.itwill10.dao.UserPointDAO;
import site.itwill10.dto.UserPoint;

@Service
public class UserPointServiceImpl implements UserPointService {
	@Autowired
	private UserPointDAO userPointDAO;

	//����� ������ ���޹޾� USERPOINT ���̺� �����ϰ� ����� ����� ������ �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	@Override
	public UserPoint addUserPoint(UserPoint userPoint) {
		//���޵� ����� ������ ���̵� �ߺ� ���� �˻� => �ߺ��� ��� ���ܹ߻�
		if(userPointDAO.selectUserPoint(userPoint.getId())!=null) {
			throw new RuntimeException("�̹� ������� ���̵� �Դϴ�.");
		}
		//���ܰ� �߻��� ��� �Ʒ��� �����ϴ� ��� �̽���
		userPointDAO.insertUserPoint(userPoint);
		return userPointDAO.selectUserPoint(userPoint.getId());
	}

}






