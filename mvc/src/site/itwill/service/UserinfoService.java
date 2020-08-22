package site.itwill.service;

import java.sql.SQLException;
import java.util.List;

import site.itwill.dao.UserinfoModelTwoDAO;
import site.itwill.dto.UserinfoDTO;
import site.itwill.exception.ExistsUserinfoException;
import site.itwill.exception.PasswordMissMatchException;
import site.itwill.exception.UserinfoNotFoundException;

//Service 클래스 : DAO 클래스의 메소드를 호출하여 모델 클래스의 요청 처리
//메소드에서 원하는 기능을 제공하기 위한 클래스 - 컴퍼넌트 클래스(모듈)
// => 어플리케이션에서 호출되어 사용하기 위한 메소드 선언
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
	
	//회원정보를 전달받아 USERINFO 테이블에 저장하는 메소드
	// => 전달된 회원정보 중 아이디가 중복될 경우 예외 발생
	public void insertUserinfo(UserinfoDTO userinfo) throws SQLException, ExistsUserinfoException {
		//전달받은 회원정보 중 아이디가 USERINFO 테이블에 이미 저장된 경우 
		if(UserinfoModelTwoDAO.getDAO().getUserinfo(userinfo.getUserid())!=null) {
			//사용자 정의 예외클래스의 인위적 예외 발생 - 아이디 중복 처리
			throw new ExistsUserinfoException("이미 사용중인 아이디를 입력 하였습니다.");
		}
		UserinfoModelTwoDAO.getDAO().addUserinfo(userinfo);
	}
	
	//회원정보를 전달받아 USERINFO 테이블에 저장된 회원정보를 변경하는 메소드
	// => 전달된 회원정보 중 아이디가 USERINFO 테이블에 저장되지 않은 경우 예외 발생
	public void updateUserinfo(UserinfoDTO userinfo) throws SQLException, UserinfoNotFoundException {
		selectUserinfo(userinfo.getUserid());
		UserinfoModelTwoDAO.getDAO().modifyUserinfo(userinfo);
	}
	
	//아이디를 전달받아 USERINFO 테이블에 저장된 회원정보를 삭제하는 메소드
	// => 전달된 아이디가 USERINFO 테이블에 저장되지 않은 경우 예외 발생
	public void deleteUserinfo(String userid) throws SQLException, UserinfoNotFoundException {
		selectUserinfo(userid);
		UserinfoModelTwoDAO.getDAO().removeUserinfo(userid);
	}
	
	//아이디를 전달받아 USERINFO 테이블에 저장된 회원정보를 검색하여 반환하는 메소드
	// => 전달된 아이디가 USERINFO 테이블에 저장되지 않은 경우 예외 발생
	public UserinfoDTO selectUserinfo(String userid) throws SQLException, UserinfoNotFoundException {
		UserinfoDTO userinfo=UserinfoModelTwoDAO.getDAO().getUserinfo(userid);
		//전달받은 아이디가 USERINFO 테이블에 저장된 회원정보가 아닌 경우 
		if(userinfo==null) {
			throw new UserinfoNotFoundException("아이디의 회원정보가 존재하지 않습니다.");
		} 
		return userinfo;
	}
	
	//USERINFO 테이블에 저장된 모든 회원정보를 검색하여 반환하는 메소드
	public List<UserinfoDTO> selectAllUserinfo() throws SQLException {
		return UserinfoModelTwoDAO.getDAO().getUserinfoList();
	}
	
	//아이디와 비밀번호를 전달받아 USEINFO 테이블에 저장된 회원정보를 이용하여 인증 처리하는 메소드
	// => 인증 실패시 인위적 예외 발생 - 예외가 발생되지 않은 경우 인증 성공
	public void login(String userid,String password) throws SQLException, UserinfoNotFoundException, PasswordMissMatchException {
		//아이디에 대한 인증 처리 => 인증 실패 : UserinfoNotFoundException 발생
		UserinfoDTO userinfo=selectUserinfo(userid);
		
		//비밀번호에 대한 인증 처리 => 인증 실패 : PasswordMissMatchException 발생
		if(!userinfo.getPassword().equals(password)) {
			throw new PasswordMissMatchException("입력한 아이디가 잘못 되었거나 비밀번호가 맞지 않습니다.");
		}
	}
	
}







