package site.itwill10.dao;

import site.itwill10.dto.UserPoint;

public interface UserPointDAO {
	int insertUserPoint(UserPoint userPoint);
	int plusUserPoint(String id);
	int minusUserPoint(String id);
	UserPoint selectUserPoint(String id);
}
