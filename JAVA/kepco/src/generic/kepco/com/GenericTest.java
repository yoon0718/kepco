package generic.kepco.com;
import java.util.ArrayList;
public class GenericTest {
	ArrayList<Elec> human;
	public void test() {
		human = new ArrayList ();
		//제네릭을 이용하여 Upcasting
		human.add(new MP3());
		human.add(new Radio());
		human.add(new TV());
		//System.out.println(human);
		human.add(new Elec() {
			//익명 클래스 활용
		
			@Override
			public void volumeUp() {
				System.out.println("cell 볼륨 업");
				
			}

			@Override
			public void volumeDown() {
				System.out.println("cell 볼륨 다운");
				
			}
			
		});
	}
	public void result() {
		/*for ( int i = 0; i < human.size(); i++) {
			human.get(i).volumeUp();
			human.get(i).volumeDown();
		}*/
		
		/*for(Elec temp : human) {
			temp.volumeUp();
			temp.volumeDown();
		}*/
		
		int i = 0;
		while(i  < human.size()) {
			human.get(i).volumeUp();
			human.get(i).volumeDown();
			i++;
		}
	}
}
