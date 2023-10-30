package inherit.kepco.com;
//java.lang.* 패키지에 있는 클래스들은 jvm이 디폴트로 로드함
//import java.lang.*;
public class InheritMain {

	public static void main(String[] args) {
		InheritBus ib = new InheritBus();
//		Upcasting
//		Vihicle vc = new InheritBus(); 
		InheritTaxi it = new InheritTaxi();
		InheritTruck itu = new InheritTruck();
		
		System.out.println(ib.color);
		System.out.println(it.color);
		System.out.println(itu.color);

		ib.front(50);
		ib.rear();
		
		it.front(0);
		it.rear();
		
		itu.front(0);
		itu.rear();
		
		
		

	}

}
