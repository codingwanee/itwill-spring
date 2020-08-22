package site.itwill.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import site.itwill.dto.MyHewon;

public interface MyHewonInterfaceMapper {
	//@Results : 검색행의 컬럼값을 자바빈 필드값으로 매핑할 수 있는 정보를 제공하는 어노테이션
	// => XML Mapper 파일의 resultMap 엘리먼트와 유사한 기능을 제공
	// => 다른 추상메소드에서 @Results 어노테이션 재사용 불가능
	@Results(value={
		//@Result : 검색행의 컬럼값을 자반빈 필드갑스오 매핑하는 어노테이션
		// => XML Mapper 파일의 id 엘리먼트 또는 result 엘리먼트와 유사한 기능을 제공	
		@Result(column = "hewon_id", property = "id")	
		,@Result(column = "hewon_name", property = "name")	
		,@Result(column = "hewon_phone", property = "phone")	
		,@Result(column = "hewon_email", property = "email")	
		,@Result(column = "hewon_state", property = "state")	
	})
	@Select("select * from myhewon order by hewon_id")
	List<MyHewon> selectHewonList();
	
	@Results(value={
		@Result(column = "hewon_id", property = "id")	
		,@Result(column = "hewon_name", property = "name")	
		,@Result(column = "hewon_phone", property = "phone")	
		,@Result(column = "hewon_email", property = "email")	
		,@Result(column = "hewon_state", property = "state")	
	})
	@Select("select * from myhewon where hewon_name=#{name} order by hewon_id")
	List<MyHewon> selectNameHewonList(String name);
	
	
	@Results(value={
		@Result(column = "hewon_id", property = "id")	
		,@Result(column = "hewon_name", property = "name")	
		,@Result(column = "hewon_phone", property = "phone")	
		,@Result(column = "hewon_email", property = "email")	
		,@Result(column = "hewon_state", property = "state")	
	})
	//@SelectProvider : SELECT 명령이 반환되는 클래스의 메소드를 호출하여 등록하는 어노테이션
	// => 동적 SQL 기능을 클래스의 메소드 명령으로 구현하여 사용
	//type 속성 : SELECT 명령을 반환하는 메소드의 클래스(Clazz)를 속성값으로 설정
	//method 속성 : SELECT 명령을 반환하는 메소드명을 속성값으로 설정
	@SelectProvider(type = MyHewonProvider.class, method = "selectDynamicHewonList")
	List<MyHewon> selectDynamicHewonList(Map<String, Object> map);
}







