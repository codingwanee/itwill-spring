package site.itwill10.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.itwill10.dao.UserinfoDAO;
import site.itwill10.dto.Userinfo;
import site.itwill10.exception.LoginAuthFailException;
import site.itwill10.exception.UserinfoExistsException;
import site.itwill10.exception.UserinfoNotFoundException;

@Service
public class UserinfoServiceImpl implements UserinfoService {
	@Autowired
	private UserinfoDAO userinfoDAO;
	
	@Transactional
	@Override
	public void addUserinfo(Userinfo userinfo) throws UserinfoExistsException {
		//전달받은 회원정보의 아이디 중복 유무 검사
		// => 아이디의 회원정보가 존재할 경우 인위적 예외 발생 - Controller에게 예외 전달
		if(userinfoDAO.selectUserinfo(userinfo.getUserid())!=null) {
			throw new UserinfoExistsException(userinfo, "이미 사용중인 아이디를 입력 하였습니다.");
		}
		
		//입력된 회원정보의 비밀번호는 암호화 처리하여 변경
		// => JavaBean 클래스의 Setter 메소드에서 작업할 경우 생략
		//BCrypt.hashpw(String password, String salt) : 전달받은 비밀번호에
		//첨가물(Salt)을 이용하여 암호화 처리 후 반환하는 메소드
		//BCrypt.gensalt(int log_rounds) : 첨가물의 길이를 전달하여 복합적인 첨가물을 생성하여 반환하는 메소드
		// => 매개변수 전달값 생략 가능 - 기본값 : 10
		userinfo.setPassword(BCrypt.hashpw(userinfo.getPassword(), BCrypt.gensalt(10)));
		
		userinfoDAO.insertUserinfo(userinfo);
	}

	@Transactional
	@Override
	public void modifyUserinfo(Userinfo userinfo) throws UserinfoNotFoundException {
		if(userinfoDAO.selectUserinfo(userinfo.getUserid())==null) {
			throw new UserinfoNotFoundException("아이디의 회원정보가 존재하지 않습니다.");
		}
		
		if(userinfo.getPassword()!=null && !userinfo.getPassword().equals("")) {//비밀번호를 변경할 경우
			userinfo.setPassword(BCrypt.hashpw(userinfo.getPassword(), BCrypt.gensalt(10)));
		}
		
		userinfoDAO.updateUserinfo(userinfo);
	}

	@Transactional
	@Override
	public void eraseUserinfo(String userid) throws UserinfoNotFoundException {
		if(userinfoDAO.selectUserinfo(userid)==null) {
			throw new UserinfoNotFoundException("아이디의 회원정보가 존재하지 않습니다.");
		}
		userinfoDAO.deleteUserinfo(userid);
	}

	@Override
	public Userinfo getUserinfo(String userid) throws UserinfoNotFoundException {
		Userinfo userinfo=userinfoDAO.selectUserinfo(userid);
		if(userinfo==null) {
			throw new UserinfoNotFoundException("아이디의 회원정보가 존재하지 않습니다.");
		}
		return userinfo;
	}

	@Override
	public List<Userinfo> getUserinfoList() {
		return userinfoDAO.selectAllUserinfo();
	}

	@Override
	public void loginAuth(Userinfo userinfo) throws LoginAuthFailException {
		Userinfo authUserinfo=userinfoDAO.selectUserinfo(userinfo.getUserid());
		
		if(authUserinfo==null) {
			throw new LoginAuthFailException(userinfo.getUserid(), "아이디의 회원정보가 존재하지 않습니다.");
		}
		
		//BCrypt.checkpw(String plantText, String hashed)
		// => 일반 문자열과 암호화된 문자열을 비교하여 같은 경우 true를 반환하는 메소드
		if(!BCrypt.checkpw(userinfo.getPassword(), authUserinfo.getPassword())) {
			throw new LoginAuthFailException(userinfo.getUserid(), "아이디가 없거나 비밀번호가 맞지 않습니다.");
		}
	}

}
