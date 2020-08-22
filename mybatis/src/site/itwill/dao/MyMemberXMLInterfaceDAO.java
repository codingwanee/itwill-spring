package site.itwill.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import site.itwill.dto.MyMemberDTO;
import site.itwill.mapper.MyMemberXMLInterfaceMapper;

//XML Mapper와 Interface Mapper를 같이 이용하여 작성된 DAO 클래스
public class MyMemberXMLInterfaceDAO {
private static MyMemberXMLInterfaceDAO _dao;
	
	private MyMemberXMLInterfaceDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new MyMemberXMLInterfaceDAO();
	}
	
	public static MyMemberXMLInterfaceDAO getDAO() {
		return _dao;
	}
	
	private SqlSessionFactory getSqlSessionFactory() {
		String resource="mybatis-config.xml";
		InputStream inputStream=null;
		try {
			inputStream=Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	//회원정보를 전달받아 MYMEMBER 테이블에 저장하고 삽입행의 갯수를 반환하는 메소드
	public int addMember(MyMemberDTO member) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			//SqlSession.getMapper(Class<T> clazz)
			// => 메모리에 저장된 Interface Mapper 파일에 직접 접근하여 Mapper 인스턴스를 반환하는 메소드
			//Mapper 인스턴스를 이용하여 추상메소드를 호출하면 추상메소드에 등록된 SQL 명령을 전달하여 실행
			return sqlSession.getMapper(MyMemberXMLInterfaceMapper.class).insertMember(member);
		} finally {
			sqlSession.close();
		}
	}
	
	//회원정보를 전달받아 MYMEMBER 테이블에 저장된 회원정보를 변경하고 변경행의 갯수를 반환하는 메소드
	public int modifyMember(MyMemberDTO member) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			 return sqlSession.getMapper(MyMemberXMLInterfaceMapper.class).updateMember(member);
		} finally {
			sqlSession.close();
		}	
	}
	
	//아이디를 전달받아 MYMEMBER 테이블에 저장된 회원정보를 삭제하고 삭제행의 갯수를 반환하는 메소드
	public int removeMember(String id) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			 return sqlSession.getMapper(MyMemberXMLInterfaceMapper.class).deleteMember(id);
		} finally {
			sqlSession.close();
		}	
	}
	
	//아이디를 전달받아 MYMEMBER 테이블에 저장된 회원정보를 검색하여 반환하는 메소드
	public MyMemberDTO getMember(String id) {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			 return sqlSession.getMapper(MyMemberXMLInterfaceMapper.class).selectMember(id);
		} finally {
			sqlSession.close();
		}
	}
	
	//MYMEMBER 테이블에 저장된 모든 회원정보를 검색하여 반환하는 메소드
	public List<MyMemberDTO> getMemberList() {
		SqlSession sqlSession=getSqlSessionFactory().openSession(true);
		try {
			 return sqlSession.getMapper(MyMemberXMLInterfaceMapper.class).selectAllMember();
		} finally {
			sqlSession.close();
		}
	}
}
