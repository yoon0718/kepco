package ch02.sec02;

public class PromotionExample {

	public static void main(String[] args) {
		//자동 타입 변환
		byte byteValue = 10;
		int intValue = byteValue;
		System.out.println("intValue: "+ intValue);
		
		char charValue = '가';
		intValue = charValue;
		System.out.println("가의 유니코드: " + intValue);
		}

}
