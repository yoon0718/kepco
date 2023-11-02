package generic.kepco.com;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapTest {
	private HashMap<String, Elec> hm=null;
	public void test() {
		hm = new HashMap<String, Elec>();
		hm.put("1st", new TV());
		hm.put("2st", new MP3());
		hm.put("3st", new Radio());

		hm.get("1st").volumeDown();
		hm.get("1st").volumeUp();

		//hashMap의 key값만 리턴받는 경우

		Set<String> set=hm.keySet();

		for(String key:set) {
			System.out.println(key);
		}
		Collection<Elec> ct = hm.values();
		for(Elec elec:ct) {
			elec.volumeDown();
			elec.volumeUp();
		}
		Set<Entry<String, Elec>> entrySet=hm.entrySet();
		for(Entry<String, Elec> temp:entrySet) {
			System.out.println(temp.getKey());
			System.out.println(temp.getValue());
		}
	}

	public static void main(String[] args) {
		new HashMapTest().test();

	}

}
