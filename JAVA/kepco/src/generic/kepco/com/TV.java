package generic.kepco.com;

public class TV implements Elec{

	@Override
	public void volumeUp() {
		System.out.println("TV 볼륨 업");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("TV 볼륨 다운");
		
	}

}
