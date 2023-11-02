package generic.kepco.com;

public class StringTest {
	public void test() {
		String a = "test";
		String b = "test";
		String c = a;
		String d = new String("test");
		//private 타입이면 값이 저장 아니면 주소가 복사
		System.out.println(a);
		//Object 클래스에 선언되어 있는 equals()는 == 과 같음(참조값을 비교함)
		//String 클래스의 equals()는 오버라이딩 되어서 문자열 내용 비교
		System.out.println(a.equals(c));
		System.out.println(a.equals(b));
		System.out.println(a.equals(d));
		System.out.println(a==c);
		System.out.println(a==d);
		
		//StringBuffer sb = new StringBuffer(); 동기화 기능이 있음
		StringBuilder sb = new StringBuilder("select * ");
		sb.append(" from emp ");
		sb.append(" where...");
	}

	public static void main(String[] args) {
		new StringTest().test();

	}

}
