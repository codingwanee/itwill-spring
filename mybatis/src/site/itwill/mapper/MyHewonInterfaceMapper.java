package site.itwill.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import site.itwill.dto.MyHewon;

public interface MyHewonInterfaceMapper {
	//@Results : �˻����� �÷����� �ڹٺ� �ʵ尪���� ������ �� �ִ� ������ �����ϴ� ������̼�
	// => XML Mapper ������ resultMap ������Ʈ�� ������ ����� ����
	// => �ٸ� �߻�޼ҵ忡�� @Results ������̼� ���� �Ұ���
	@Results(value={
		//@Result : �˻����� �÷����� �ڹݺ� �ʵ尩���� �����ϴ� ������̼�
		// => XML Mapper ������ id ������Ʈ �Ǵ� result ������Ʈ�� ������ ����� ����	
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
	//@SelectProvider : SELECT ����� ��ȯ�Ǵ� Ŭ������ �޼ҵ带 ȣ���Ͽ� ����ϴ� ������̼�
	// => ���� SQL ����� Ŭ������ �޼ҵ� ������� �����Ͽ� ���
	//type �Ӽ� : SELECT ����� ��ȯ�ϴ� �޼ҵ��� Ŭ����(Clazz)�� �Ӽ������� ����
	//method �Ӽ� : SELECT ����� ��ȯ�ϴ� �޼ҵ���� �Ӽ������� ����
	@SelectProvider(type = MyHewonProvider.class, method = "selectDynamicHewonList")
	List<MyHewon> selectDynamicHewonList(Map<String, Object> map);
}







