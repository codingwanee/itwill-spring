package site.itwill10.mapper;

import java.util.List;

import site.itwill10.dto.BoardPoint;

public interface BoardPointMapper {
	int insertBoardPoint(BoardPoint boardPoint);
	int deleteBoardPoint(int num);
	BoardPoint selectBoardPoint(int num);
	List<BoardPoint> selectAllBoardPoint();
}
