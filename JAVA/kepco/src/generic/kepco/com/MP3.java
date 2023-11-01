package generic.kepco.com;

public class MP3 implements Elec{

	@Override
	public void volumeUp() {
		System.out.println("MP3 볼륨 업");
		
	}

	@Override
	public void volumeDown() {
		System.out.println("MP3 볼륨 다운");
		
	}
	
}
