package generic.kepco.com;

public class RhombusStar {
	public void Star() { 
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(i+j == 4 ||  i-j == 4 || j-i == 4 || i+j == 12) {
					System.out.print("★");
				}
				else {
					System.out.print("☆");
				}
				
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		new RhombusStar().Star();

	}

}
