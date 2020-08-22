package site.itwill10.service;

import java.util.List;

import site.itwill10.dto.BoardPoint;
import site.itwill10.dto.UserPoint;

public interface BoardPointService {
	UserPoint addBoardPoint(BoardPoint boardPoint);
	UserPoint eraseBoardPoint(int num);
	List<BoardPoint> getBoardPointList();
}
