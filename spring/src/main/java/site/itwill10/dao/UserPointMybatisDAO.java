package site.itwill10.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import site.itwill10.dto.UserPoint;
import site.itwill10.mapper.UserPointMapper;

@Repository
public class UserPointMybatisDAO implements UserPointDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insertUserPoint(UserPoint userPoint) {
		return sqlSession.getMapper(UserPointMapper.class).insertUserPoint(userPoint);
	}

	@Override
	public int plusUserPoint(String id) {
		return sqlSession.getMapper(UserPointMapper.class).plusUserPoint(id);
	}

	@Override
	public int minusUserPoint(String id) {
		return sqlSession.getMapper(UserPointMapper.class).minusUserPoint(id);
	}

	@Override
	public UserPoint selectUserPoint(String id) {
		return sqlSession.getMapper(UserPointMapper.class).selectUserPoint(id);
	}

}
