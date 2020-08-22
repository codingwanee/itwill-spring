package site.itwill07.aop;

import org.aspectj.lang.JoinPoint;

public class JoinPointAdvice {
	//before, after-returning, after-throwing, after ��ġ�� ���Ե� Ⱦ�ܰ��ɸ��(�޼ҵ�)�� 
	//�Ϲ������� ��ȯ���� void�� �����ϰ� �Ű������� �������� �ʰ� �ۼ�
	// => ���������� JoinPoint �Ű������� �����Ͽ� �ڵ����� ������ �����޾� ���
	// => ��ġ(JoinPoint)�� ���� �Ű������� �ٸ��� �����Ͽ� �ڵ����� ������ �����޾� ���
	
	//around ��ġ�� ���Ե� Ⱦ�ܰ��ɸ���� ��ȯ���� Object�� �����ϰ� ProceedingJointPoint
	//�Ű������� �����Ͽ� �ٽɰ��ɸ�� ������ �ڵ����� �����޾� ���
	// => �ٽɰ��ɸ�⿡�� �߻��Ǵ� ���ܸ� �ܺη� �����ϵ��� ����
	
	//�ٽɰ��ɸ���� ����� ����Ǳ� ���� ���ԵǾ� ����� �޼ҵ� - before
	// => JoinPoint �Ű������� �����Ͽ� �ٽɰ��ɸ�� ������ ���޹޾� ���
	public void displayTarget(JoinPoint joinPoint) {
		//System.out.println("[before]�ٽɰ����ڵ� ���� ���� ���ԵǾ� ���۵� Ⱦ�ܰ����ڵ�");
		
		//JoinPoint.getTarget() : �ٽɰ��ɸ���� ����� Ŭ������ Object Ÿ������ ��ȯ�ϴ� �޼ҵ�
		//Object.getClass() : �޸𸮿� ����� Ŭ����(Clazz)�� ��ȯ�ϴ� �޼ҵ� - ���÷��� ���
		//Class.getName() : �޸𸮿� ����� Ŭ����(Clazz)�� ��Ű���� ���Ե� Ŭ�����̸��� ��ȯ�ϴ� �޼ҵ�
		//String className=joinPoint.getTarget().getClass().getName();
		//Class.getSimpleName() : �޸𸮿� ����� Ŭ����(Clazz)�� Ŭ�����̸��� ��ȯ�ϴ� �޼ҵ�
		//String className=joinPoint.getTarget().getClass().getSimpleName();
		//System.out.println("[before]�ٽɰ��ɸ���� ����� Ŭ���� = "+className);
		
		//JoinPoint.getSignature() : Signature �ν��Ͻ�(�ٽɰ��ɸ�� Ư¡����)�� ��ȯ�޴� �޼ҵ�
		//Signature.getName() : �ٽɰ��ɸ���� �̸��� ��ȯ�ϴ� �޼ҵ�
		//String methodName=joinPoint.getSignature().getName();
		//System.out.println("[before]�ٽɰ��ɸ���� �̸� = "+methodName);
		
		//JoinPoint.getArgs() : �ٽɰ��ɸ���� �Ű��������� Object �迭�� ��ȯ�ϴ� �޼ҵ�
		Object[] objects=joinPoint.getArgs();
		System.out.println("[before]�ٽɰ��ɸ���� �Ű����� ���� = "+objects.length);
	}
	
	//�ٽɰ��ɸ���� ����� ���������� ����� �� ���ԵǾ� ����� �޼ҵ� - after-returning
	// => JoinPoint �Ű������� �����Ͽ� �ٽɰ��ɸ�� ������ ���޹޾� ���
	// => Object �Ű������� �����Ͽ� �ٽɰ��ɸ���� ��ȯ���� ���޹޾� ��� 
	// => after-returning ������Ʈ�� returning �Ӽ��� �ݵ�� �����Ͽ� ��ȯ���� ���޹޾� ����
	public void displayName(Object object) {
		//System.out.println("[after-returning]�ٽɰ����ڵ尡 ���������� ����� �� ���ԵǾ� ���۵� Ⱦ�ܰ����ڵ�");
		
		if(object instanceof String) {
			String name=(String)object;
			System.out.println("[after-returning]"+name+"�� ȯ���մϴ�.");
		}
	}
	
	//�ٽɰ��ɸ���� ��� ����� ���ܰ� �߻��� ��� ���ԵǾ� ����� �޼ҵ� - after-throwing
	// => JoinPoint �Ű������� �����Ͽ� �ٽɰ��ɸ�� ������ ���޹޾� ���
	// => Excption �Ű������� �����Ͽ� ���������� ���޹޾� ��� - throwing �Ӽ�
	// => after-throwing ������Ʈ�� throwing �Ӽ��� �ݵ�� �����Ͽ� ���ܸ� ���޹޾� ����
	public void displayException(Exception exception) {
		//System.out.println("[after-throwing]�ٽɰ����ڵ� ����� ���ܰ� �߻��� ��� ���ԵǾ� ���۵� Ⱦ�ܰ����ڵ�");
		
		System.out.println("[after-throwing]���� �߻� = "+exception.getMessage());
	}
}
