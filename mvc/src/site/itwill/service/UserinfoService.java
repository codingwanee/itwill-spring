package site.itwill.service;

import java.sql.SQLException;
import java.util.List;

import site.itwill.dao.UserinfoModelTwoDAO;
import site.itwill.dto.UserinfoDTO;
import site.itwill.exception.ExistsUserinfoException;
import site.itwill.exception.PasswordMissMatchException;
import site.itwill.exception.UserinfoNotFoundException;

//Service Ŭ���� : DAO Ŭ������ �޼ҵ带 ȣ���Ͽ� �� Ŭ������ ��û ó��
//�޼ҵ忡�� ���ϴ� ����� �����ϱ� ���� Ŭ���� - ���۳�Ʈ Ŭ����(���)
// => ���ø����̼ǿ��� ȣ��Ǿ� ����ϱ� ���� �޼ҵ� ����
public class UserinfoService {
	private static UserinfoService _service;
	
	private UserinfoService() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_service=new UserinfoService();
	}
	
	public static UserinfoService getService() {
		return _service;
	}
	
	//ȸ�������� ���޹޾� USERINFO ���̺� �����ϴ� �޼ҵ�
	// => ���޵� ȸ������ �� ���̵� �ߺ��� ��� ���� �߻�
	public void insertUserinfo(UserinfoDTO userinfo) throws SQLException, ExistsUserinfoException {
		//���޹��� ȸ������ �� ���̵� USERINFO ���̺� �̹� ����� ��� 
		if(UserinfoModelTwoDAO.getDAO().getUserinfo(userinfo.getUserid())!=null) {
			//����� ���� ����Ŭ������ ������ ���� �߻� - ���̵� �ߺ� ó��
			throw new ExistsUserinfoException("�̹� ������� ���̵� �Է� �Ͽ����ϴ�.");
		}
		UserinfoModelTwoDAO.getDAO().addUserinfo(userinfo);
	}
	
	//ȸ�������� ���޹޾� USERINFO ���̺� ����� ȸ�������� �����ϴ� �޼ҵ�
	// => ���޵� ȸ������ �� ���̵� USERINFO ���̺� ������� ���� ��� ���� �߻�
	public void updateUserinfo(UserinfoDTO userinfo) throws SQLException, UserinfoNotFoundException {
		selectUserinfo(userinfo.getUserid());
		UserinfoModelTwoDAO.getDAO().modifyUserinfo(userinfo);
	}
	
	//���̵� ���޹޾� USERINFO ���̺� ����� ȸ�������� �����ϴ� �޼ҵ�
	// => ���޵� ���̵� USERINFO ���̺� ������� ���� ��� ���� �߻�
	public void deleteUserinfo(String userid) throws SQLException, UserinfoNotFoundException {
		selectUserinfo(userid);
		UserinfoModelTwoDAO.getDAO().removeUserinfo(userid);
	}
	
	//���̵� ���޹޾� USERINFO ���̺� ����� ȸ�������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	// => ���޵� ���̵� USERINFO ���̺� ������� ���� ��� ���� �߻�
	public UserinfoDTO selectUserinfo(String userid) throws SQLException, UserinfoNotFoundException {
		UserinfoDTO userinfo=UserinfoModelTwoDAO.getDAO().getUserinfo(userid);
		//���޹��� ���̵� USERINFO ���̺� ����� ȸ�������� �ƴ� ��� 
		if(userinfo==null) {
			throw new UserinfoNotFoundException("���̵��� ȸ�������� �������� �ʽ��ϴ�.");
		} 
		return userinfo;
	}
	
	//USERINFO ���̺� ����� ��� ȸ�������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	public List<UserinfoDTO> selectAllUserinfo() throws SQLException {
		return UserinfoModelTwoDAO.getDAO().getUserinfoList();
	}
	
	//���̵�� ��й�ȣ�� ���޹޾� USEINFO ���̺� ����� ȸ�������� �̿��Ͽ� ���� ó���ϴ� �޼ҵ�
	// => ���� ���н� ������ ���� �߻� - ���ܰ� �߻����� ���� ��� ���� ����
	public void login(String userid,String password) throws SQLException, UserinfoNotFoundException, PasswordMissMatchException {
		//���̵� ���� ���� ó�� => ���� ���� : UserinfoNotFoundException �߻�
		UserinfoDTO userinfo=selectUserinfo(userid);
		
		//��й�ȣ�� ���� ���� ó�� => ���� ���� : PasswordMissMatchException �߻�
		if(!userinfo.getPassword().equals(password)) {
			throw new PasswordMissMatchException("�Է��� ���̵� �߸� �Ǿ��ų� ��й�ȣ�� ���� �ʽ��ϴ�.");
		}
	}
	
}







