package site.itwill.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import site.itwill.dto.MyHewon;

public interface MyHewonMapper {
	int insertHewon(MyHewon hewon);
	List<MyHewon> selectHewonList();
	List<MyHewon> selectDiscriminatorHewonList();
	List<MyHewon> selectStateHewonList(int state);
	String selectBeanHewonId(MyHewon hewon);
	//Map 인스턴스의 제네릭은 Key:String, Value:Object로 설정하여 선언
	String selectMapHewonId(Map<String, Object> map);
	//추상메소드의 매개변수에 저장값을 XML 맵퍼에서 사용할 수 있도록 @Param 어노테이션 사용
	// => @Param(value="variableName") 자료형 변수명 - value 키워드 생략 가능
	String selectParamHewonId(@Param("name") String name,@Param("phone") String phone);
	int insertHewonMap(Map<String, Object> map);
	List<MyHewon> selectSearchHewonList(Map<String, Object> map);
	List<MyHewon> selectNameHewonList(String name);
	List<MyHewon> selectNameDynamicHewonList(Map<String, Object> map);
	List<MyHewon> selectDynamicHewonList(Map<String, Object> map);
	int updateHewon(MyHewon hewon);
	int updateDynamicHewon(MyHewon hewon);
	List<MyHewon> selectDynamicMultiHewonList(List<String> list);
}






