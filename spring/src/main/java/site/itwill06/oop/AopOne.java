package site.itwill06.oop;

//�������̽��� ��ӹ޾� �ۼ��� �������̵� �޼ҵ忡 Ⱦ�ܰ����ڵ� ���Եǵ��� ���� - PointCut
public class AopOne implements AopInterface {
	@Override
	public void display1() {
		//Ⱦ�ܰ����ڵ� : �α�, ����, Ʈ������, ����ó������ �����ϱ� ���� ��� 
		//System.out.println("### �޼ҵ��� ��� ���� �� �ܼ� �α� ��� ###");
		//�ٽɰ����ڵ� : �޼ҵ� ȣ��� ���� �� �ִ� ����� �����ϱ� ���� ���
		System.out.println("*** AopOne Ŭ������ display1() �޼ҵ� ȣ�� *** ");
	}

	@Override
	public void display2() {
		//System.out.println("### �޼ҵ��� ��� ���� �� �ܼ� �α� ��� ###");
		System.out.println("*** AopOne Ŭ������ display2() �޼ҵ� ȣ�� *** ");
	}

	@Override
	public void display3() {
		//System.out.println("### �޼ҵ��� ��� ���� �� �ܼ� �α� ��� ###");
		System.out.println("*** AopOne Ŭ������ display3() �޼ҵ� ȣ�� *** ");
	}
}
