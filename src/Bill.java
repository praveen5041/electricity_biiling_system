import java.sql.*;
public class Bill {

	Connection con;
	Statement st;
		// TODO Auto-generated method stub
	Bill(){
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","system","root504");
		 st=con.createStatement();
		 System.out.print("hi");
	}catch(Exception e) {
		e.printStackTrace();
	}
		
}
	public static void main(String[] args) {
		new Bill();
		
	}
}

	


