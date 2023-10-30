package inherit.kepco.com;

public class Taxi {
	private int speed;
	String color ="Red";	
	public String money="1000원";	

	public String front1(int speed) {
		this.speed= speed;
		
//		return을 만나면 해당 메소드는 종료함
		return null;		
	}

	public void rear1() {
		System.out.println("후진 속도도 " + speed+"입니다");

	}

}
