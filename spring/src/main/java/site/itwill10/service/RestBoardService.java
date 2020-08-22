package site.itwill10.service;

import java.util.List;
import java.util.Map;

import site.itwill10.dto.RestBoard;

public interface RestBoardService {
	void addRestBoard(RestBoard board);
	void modifyRestBoard(RestBoard board);
	void eraseRestBoard(int num);
	RestBoard getRestBoard(int num);
	List<RestBoard> getRestBoardList(Map<String , Object> map);
	int getCountRestBoard();
}
