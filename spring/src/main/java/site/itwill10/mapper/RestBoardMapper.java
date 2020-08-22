package site.itwill10.mapper;

import java.util.List;
import java.util.Map;

import site.itwill10.dto.RestBoard;

public interface RestBoardMapper {
	int insertRestBoard(RestBoard board);
	int updateRestBoard(RestBoard board);
	int deleteRestBoard(int num);
	RestBoard selectRestBoard(int num);
	List<RestBoard> selectPageRestBoard(Map<String, Object> map);
	int selectCountRestBoard();
}
