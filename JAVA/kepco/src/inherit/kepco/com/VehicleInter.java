package inherit.kepco.com;

//interface의 구조 : 클래스의 모든 메소드가 추상메소드로 만들어져 있는 클래스를 인터페이라 부름
//: interface에 선언되는 메소드는 전부 추상메소드
//: interface에 선언되는 변수는  전부 상수 
public interface VehicleInter {
//	public static final int maxSpeed=50;
	int MAX_SPEED=50;
	
	public String front();
	public void rear();

}
