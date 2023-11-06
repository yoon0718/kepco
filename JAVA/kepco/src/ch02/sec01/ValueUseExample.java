package ch02.sec01;

public class ValueUseExample {
	int hour = 3;
	int minute = 5;
	public static void main(String[] args) {
		ValueUseExample val = new ValueUseExample();
		int hour = val.hour;
		int minute = val.minute;
		System.out.println(hour + "시간 " + minute + "분");
	}
}
