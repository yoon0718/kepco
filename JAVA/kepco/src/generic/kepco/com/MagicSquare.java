package generic.kepco.com;

public class MagicSquare {
	int num;
	public MagicSquare(int num) {
		this.num=num;
	}	
	public void make() {
		int[][] mabAry = new int[num][num];
		int x = 0;
		int y = num/2;
		mabAry[x][y] = 1;
		for(int i = 2; i <= num*num; i++) {
			x -= 1;
			y -= 1;
			if( x < 0 && y < 0) {
				x += 2;
				y += 1;
			}
			else if( x < 0 || y < 0) {
				if(x < 0) {
					x += num;
				}
				if(y < 0){
					y += num;
				}
			}
			if(mabAry[x][y] != 0) {
				x += 2;
				y += 1;
			}
			mabAry[x][y] = i;
		}
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < num; j++) {
				System.out.print(mabAry[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		MagicSquare mb=new MagicSquare(9);		
		mb.make();

	}

}
