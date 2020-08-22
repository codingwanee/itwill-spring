package site.itwill01.old;

public class GoodbyeMessagePrint {
	public void goodbyeMessagePrint() {
		GoodbyeMessageObject object=new GoodbyeMessageObject();
		String message=object.getGoodbyeMessage();
		System.out.println("message = "+message);
	}
}
