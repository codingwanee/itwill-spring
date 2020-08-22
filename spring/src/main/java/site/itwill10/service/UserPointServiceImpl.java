package site.itwill10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.itwill10.dao.UserPointDAO;
import site.itwill10.dto.UserPoint;

@Service
public class UserPointServiceImpl implements UserPointService {
	@Autowired
	private UserPointDAO userPointDAO;

	//사용자 정보를 전달받아 USERPOINT 테이블에 저장하고 저장된 사용자 정보를 검색하여 반환하는 메소드
	@Override
	public UserPoint addUserPoint(UserPoint userPoint) {
		//전달된 사용자 정보의 아이디 중복 유무 검사 => 중복된 경우 예외발생
		if(userPointDAO.selectUserPoint(userPoint.getId())!=null) {
			throw new RuntimeException("이미 사용중인 아이디 입니다.");
		}
		//예외가 발생된 경우 아래에 존재하는 명령 미실행
		userPointDAO.insertUserPoint(userPoint);
		return userPointDAO.selectUserPoint(userPoint.getId());
	}

}






