package site.itwill.dto;

//MYCOMMENT ���̺�� MYUSER ���̺��� �˻������ �����ϱ� ���� �ڹٺ� Ŭ����
//=> 1:1 ������ ���� ����� �����ϱ� ���� Ŭ����
public class MyCommentUser2 {
	//�˻����� �Խñ�����(MYCOMMENT ���̺�)�� �����ϱ� ���� �ʵ�
	// => POJO(Plain Old Java Object) : ���� �ڹٺ� Ŭ������ �����ϴ� ���
	private MyComment1 comment;//���� �ν��Ͻ�
	
	//�˻����� ȸ������(MYUSER ���̺�)�� �����ϱ� ���� �ʵ�
	private MyUser user;
	
	public MyCommentUser2() {
		// TODO Auto-generated constructor stub
	}

	public MyComment1 getComment() {
		return comment;
	}

	public void setComment(MyComment1 comment) {
		this.comment = comment;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}	
}
