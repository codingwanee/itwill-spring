package site.itwill10.dao;

import java.util.List;

import site.itwill10.dto.BoardPoint;

public interface BoardPointDAO {
	int insertBoardPoint(BoardPoint boardPoint);
	int deleteBoardPoint(int num);
	BoardPoint selectBoardPoint(int num);
	List<BoardPoint> selectAllBoardPoint();
}
