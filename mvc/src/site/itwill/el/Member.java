package site.itwill.el;

public class Member {
	private String irum;
	private Car car;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String irum, Car car) {
		super();
		this.irum = irum;
		this.car = car;
	}

	public String getIrum() {
		return irum;
	}

	public void setIrum(String irum) {
		this.irum = irum;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
