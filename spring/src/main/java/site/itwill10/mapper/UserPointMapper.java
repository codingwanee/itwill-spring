package site.itwill10.mapper;

import site.itwill10.dto.UserPoint;

public interface UserPointMapper {
	int insertUserPoint(UserPoint userPoint);
	int plusUserPoint(String id);
	int minusUserPoint(String id);
	UserPoint selectUserPoint(String id);
}
