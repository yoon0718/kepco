package stream.kepco.com;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class streamTest {
	public void test() {
		int temp;
		FileInputStream fi = null;
		FileOutputStream fo = null;
		try {
			fi = new FileInputStream("c:/kepco_humen/fasdf.txt");
			fo = new FileOutputStream("c:/kepco_humen/fasdfa.txt");
			while((temp = fi.read())!= -1) {
				System.out.print((char)temp);
				fo.write((char)temp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fi.close();
				fo.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	public void test1() {
		int temp;
		FileReader fr = null;
		FileWriter fw = null;
		try {
			fr = new FileReader("c:/kepco_humen/fasdf.txt");
			fw = new FileWriter("c:/kepco_humen/fasdfc.txt");
			while((temp = fr.read())!= -1) {
				System.out.print((char)temp);
				fw.write((char)temp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fr.close();
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	public void test2() {
		int temp;
		try( FileReader fr = new FileReader("c:/kepco_humen/fasdf.txt");
				FileWriter fw = new FileWriter("c:/kepco_humen/fasdfc.txt")){
			while((temp = fr.read())!= -1) {
				System.out.print((char)temp);
				fw.write((char)temp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void test3() throws Exception{
		int temp;
		FileReader fr = new FileReader("c:/kepco_humen/fasdf.txt");
		FileWriter fw = new FileWriter("c:/kepco_humen/fasdfc.txt");
		try(fr;fw ){
			while((temp = fr.read())!= -1) {
				System.out.print((char)temp);
				fw.write((char)temp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void test4() throws Exception{
		long start=System.currentTimeMillis();
		//1.9버전 이후부터는 아래와 같이 사용 가능
		int temp;
		FileReader fr = new FileReader("c:/kepco_humen/fasdf.txt");
		FileWriter fw = new FileWriter("c:/kepco_humen/fasdfc.txt");
		try(fr;fw ){
			while((temp = fr.read())!= -1) {
				System.out.print((char)temp);
				fw.write((char)temp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis() - start;
		System.out.println("메서드 실행 시간은" + end + " 입니다");
	}

	public static void main(String[] args) {
		new streamTest().test1();

	}

}
