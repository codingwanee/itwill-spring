package site.itwill10.dto;

/*
�̸�      ��?       ����           
------- -------- ------------ 
NUM     NOT NULL NUMBER       
SUBJECT          VARCHAR2(50) 
WRITER           VARCHAR2(20)
*/

//BOARDPOINT ���̺��� ����(�Խñ� ����)�� �����ϱ� ���� Ŭ����
public class BoardPoint {
	private int num;
	private String subject;
	private String writer;
	
	public BoardPoint() {
		// TODO Auto-generated constructor stub
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
}
