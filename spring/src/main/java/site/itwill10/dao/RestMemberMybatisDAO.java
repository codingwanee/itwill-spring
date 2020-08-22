package site.itwill10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import site.itwill10.dto.RestMemberJSON;
import site.itwill10.dto.RestMemberXML;
import site.itwill10.mapper.RestMemberMapper;

@Repository
public class RestMemberMybatisDAO implements RestMemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<RestMemberXML> selectAllRestMemberXML() {
		return sqlSession.getMapper(RestMemberMapper.class).selectAllRestMemberXML();
	}

	@Override
	public List<RestMemberJSON> selectAllRestMemberJSON() {
		return sqlSession.getMapper(RestMemberMapper.class).selectAllRestMemberJSON();
	}

}





