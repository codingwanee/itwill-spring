package site.itwill10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import site.itwill10.dto.BoardPoint;
import site.itwill10.mapper.BoardPointMapper;

@Repository
public class BoardPointMybatisDAO implements BoardPointDAO {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insertBoardPoint(BoardPoint boardPoint) {
		return sqlSession.getMapper(BoardPointMapper.class).insertBoardPoint(boardPoint);
	}

	@Override
	public int deleteBoardPoint(int num) {
		return sqlSession.getMapper(BoardPointMapper.class).deleteBoardPoint(num);
	}

	@Override
	public BoardPoint selectBoardPoint(int num) {
		return sqlSession.getMapper(BoardPointMapper.class).selectBoardPoint(num);
	}

	@Override
	public List<BoardPoint> selectAllBoardPoint() {
		return sqlSession.getMapper(BoardPointMapper.class).selectAllBoardPoint();
	}

}
