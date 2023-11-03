package dbconn.kepco.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnTest {
	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	public void connectDB() throws Exception{
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hr", "hr", "1234");
	}
	
	public void select() throws Exception{
		conn = DBconnSingeTon.getInstance().getConnection();
		String query = "SELECT EMPLOYEE_ID, FIRST_NAME, EMAIL, HIRE_DATE FROM EMPLOYEES";
		pstm = conn.prepareStatement(query);
		//1. 실행하는 퀴리문이 select문일 경우 executeQuery()
		//2. insert, update, delete문일 경우 executeUpdate()
		rs = pstm.executeQuery();
		while(rs.next()) {
			int emplyeeId = rs.getInt("employee_id");
			String firstName = rs.getString("first_name");
			String email = rs.getString("email");
			String hireDate = rs.getString("hire_date");
			System.out.println(emplyeeId + " " + firstName + " " + email + " " + hireDate );
			System.out.println();
		}
	}
	public void insert() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO EMPLOYEES VALUES");
		sb.append("(302,'A', 'A','A','A',NOW(), 'AD_VP', 6000, NULL, 110, 30)");
		pstm = conn.prepareStatement(sb.toString());
		pstm.executeUpdate();
		
	}
	public static void main(String[] args) throws Exception {
		DBConnTest dt = new DBConnTest();
//		dt.connectDB();
		dt.select();
		dt.insert();
	}

}
