package site.itwill.mapper;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

//Provider Ŭ���� : SQL ������ �����Ͽ� ��ȯ�ϴ� �޼ҵ尡 ����� Ŭ����
// => ���� SQL ����� Java �������� ����
public class MyHewonProvider {
	public String selectDynamicHewonList(Map<String, Object> map) {
		//SQL Ŭ���� : SQL ������ �����ϱ� ���� Ŭ����
		// => SQL ���� ���� �޼ҵ带 ȣ���Ͽ� SQL ���� ����
		return new SQL() {{
			SELECT("*");
			FROM("myhewon");
			if(map.get("name")!=null && !map.get("name").equals("")) {
				WHERE("hewon_name=#{name}");
			}
			ORDER_BY("hewon_id");
		}}.toString();
	}
}






