package dbconn.kepco.com;

import java.sql.Timestamp;

public class EmployeeDTO {
	// 데이터베이스에서 가져오는 데이터이기 때문에 보안 중요 private
	private int employeeId;
	
	private String firstName;
	private String email;
	private Timestamp hireDate;
	//java.sql timestamp
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getHireDate() {
		return hireDate;
	}
	public void setHireDate(Timestamp hireDate) {
		this.hireDate = hireDate;
	}
	@Override //값을 확인
	public String toString() {
		return "EmployeeDTO [employeeId=" + employeeId + ", firstName=" + firstName + ", email=" + email + ", hireDate="
				+ hireDate + "]";
	}
	
}

