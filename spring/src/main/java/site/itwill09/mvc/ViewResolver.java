package site.itwill09.mvc;

//������������ ��ȯ�ϴ� ����� �����ϴ� Ŭ����
public class ViewResolver {
	//���ڿ��� ���޹޾� ���� ������ ������(JSP ����)�� ��ȯ�ϴ� ��ȯ�ϴ� �޼ҵ�
	public String getViewPage(String view) {
		return "/WEB-INF/mvc/"+view+".jsp";
	}
}
