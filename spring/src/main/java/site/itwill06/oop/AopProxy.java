package site.itwill06.oop;

//Proxy Ŭ���� : �ٽɰ����ڵ忡 Ⱦ�ܰ����ڵ尡 ���Ե� �޼ҵ尡 ����� Ŭ����
// => ���α׷����� ȣ���Ͽ� ����ϴ� Ŭ���� - Aspect 
public class AopProxy implements AopInterface {
	//Ⱦ�ܰ����ڵ�� �ۼ��� �޼ҵ尡 ����� Ŭ������ �ν��Ͻ��� �����ϱ� ���� �ʵ�
	private AopLogger logger;
	
	//�ٽɰ����ڵ�� �ۼ��� �żҵ尡 ����� Ŭ������ �ν��Ͻ��� �����ϱ� ���� �ʵ�
	// => �������̽��� ��ӹ��� �ڽ�Ŭ������ �ν��Ͻ� ����
	private AopInterface target;
	
	public AopProxy(AopInterface target) {
		logger=new AopLogger();
		this.target=target;
	}
	
	//�ٽɰ����ڵ忡 Ⱦ�ܰ����ڵ尡 ���Ե� �޼ҵ� �ۼ� - Weaving
	@Override
	public void display1() {
		//�ٽɰ����ڵ带 �������� ���ϴ� ��ġ�� Ⱦ�ܰ����ڵ带 ���� - JoinPoint
		logger.beforeLog();//Ⱦ�ܰ����ڵ�
		target.display1();//�ٽɰ����ڵ� - �ʵ忡 ����� �ڽ� �ν��Ͻ��� ���� �ٸ� ��� ����
	}

	@Override
	public void display2() {
		logger.beforeLog();
		target.display2();
	}

	@Override
	public void display3() {
		logger.beforeLog();
		target.display3();
	}

}
