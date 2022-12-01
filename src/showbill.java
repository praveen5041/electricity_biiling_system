import java.sql.*;
import javax.swing.*;
public class showbill extends JFrame{
	
		JLabel total_bill;
		JTextField total;
		
		showbill(){
			setLayout(null);
		total_bill=new JLabel("Total is");
		total_bill.setBounds(100, 100, 100, 30);
		add(total_bill);
		
		JLabel metr=new JLabel("meterno");
		metr.setBounds(100, 200, 100, 30);
		add(metr);
		
		JTextField no=new JTextField();
		no.setBounds(200, 200, 100, 30);
		add(no);
		
		try {
			Bill b=new Bill();
			String s=no.getText();
			String q="select * from tbill where meter=='"+s+"'";
			ResultSet rs=b.st.executeQuery(q);
			while(rs.next()) {
				System.out.println(rs.getString("meter"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
//		total =new JTextField();
//		total.setBounds(300,100,40,30);
//		add(total);
		
		setSize(700,500);
	
		setVisible(true);
		}
		 
		 


		
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
			new showbill();

}
}
