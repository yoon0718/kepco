package generic.kepco.com;

import java.util.Random;
import java.util.TreeSet;

public class TreeSetLotto {
	private Random rd = new Random();
	
	public void makeLotto() {
		TreeSet<Integer> ts = new TreeSet();
		ts.add(rd.nextInt(45)+1);
		while(ts.size() < 7) {
			ts.add(new Random().nextInt(45)+1);
		}
		System.out.println(ts);
	}
	
	public static void main(String[] args) {
		new TreeSetLotto().makeLotto();

	}

}
