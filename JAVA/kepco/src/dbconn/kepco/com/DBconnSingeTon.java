package dbconn.kepco.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class DBconnSingeTon {
	//singleton 객체는 메모리에 1개만 인스턴스화 하여 사용하는 방법
	//그래서 ...이렇게 만들어야 해요
	//1. 외부에서 new 해서 못만들도록 해야함
	//생성자(DBconnSingeTon())를 private으로 선언
	
	//1개만 인스턴스화하기 해 static으로 불러오고 바로 접근할 수 없도록 private로 막음
	private static DBconnSingeTon dst = new DBconnSingeTon();
	Connection conn;
	private DBconnSingeTon(){
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "hr", "1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static DBconnSingeTon getInstance() {
		if(dst == null) {
			dst = new DBconnSingeTon();
		}
		return dst;
	}
	public Connection getConnection() {
		return conn;
	}
}
