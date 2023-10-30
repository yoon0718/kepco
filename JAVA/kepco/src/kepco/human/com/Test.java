package kepco.human.com;

public class Test {
	
	int j =10;
	
	public void test() {
		System.out.println("fsajfklsdjfa");
	}
	
//	모든 클래스는 메모리에 올라가야지만 실행됨 : 인스턴스(instance)화 한다
//	인스턴스화 하는 방법
//	1. new 연산자를 이용하는 방법
//	2. 리플렉션 사용
	public static void main(String[] args) {
		int i = 11;
//		Test tt = new Test();
//		System.out.println(i);
//		System.out.println(tt);
//		tt.test();		
		Result rs = new Result();
		rs.human();
	}

}
