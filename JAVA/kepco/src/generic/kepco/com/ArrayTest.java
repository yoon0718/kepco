package generic.kepco.com;

import java.util.Iterator;

public class ArrayTest {
	public void test() {
		//1차원 배열 선언
		int full[] = {1, 3, 5, 6};
		//1. int[] full = new int[4]; 초기값 0 으로 채워짐
		//2. int[] full = null;
		//	 full = new int[1, 3, 5, 6]; 1번과 똑같음
		//3. int[] full = {1, 3, 5, 6};
		
		//2차원 배열 선언
		// int[][] full = new int[5][5];
		// int[][] full = {{1, 1, 1, 1, 1}, {], {}, {}, {}};
		
		//2차원 배열 크기가 다를 경우
		//int[][] diff = new int [3][];
		//diff[0] = new int[2];
		//diff[1] = new int[3];
		//diff[2] = new int[4];
		
		/*
		for (int i = 0; i < full.length; i++) {
			System.out.print(full[i]+" ");
		}*/
		/*
		for (int temp : full) {
			System.out.print(temp+" ");
		}*/
		
		int[][] human = new int[5][5];
		int k = 0;
		for (int i = 0; i < human.length; i++) {
			for (int j = 0; j < human[i].length; j++) {
				human[i][j] = k;
				k++;
			}
		}
		for (int[] temp : human) {
			for (int temp1 : temp) {
				System.out.print(temp1 + " ");
			}
		}
		
	}
	public static void main(String[] args) {
		new ArrayTest().test();

	}

}
