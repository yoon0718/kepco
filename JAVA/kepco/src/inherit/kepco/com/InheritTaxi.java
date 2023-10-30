package inherit.kepco.com;

public class InheritTaxi extends Vihicle {

	@Override
	public String front(int speed) {
		System.out.println("택시의 전진입니다");
		return null;
	}

	@Override
	public void rear() {
		System.out.println("택시의 후진입니다");
	}
	

}
