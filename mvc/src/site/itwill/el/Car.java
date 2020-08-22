package site.itwill.el;

//값 저장이 목적인 클래스 - VO 클래스, DTO 클래스, Bean 클래스
public class Car {
	private String name;
	private String color;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
