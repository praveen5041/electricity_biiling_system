import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
public class splash extends JFrame implements ActionListener{
	JLabel sum,month,cunits;
	JTextField meter,tunits;
	Choice meternum,cmonth;
	JButton calculate;
	splash(){
		setLayout(null);
		JLabel lname=new JLabel("Please pay the bill in time");
		lname.setBounds(10,10,200,25);
		add(lname);
		
		sum=new JLabel("meter number");
		sum.setBounds(100,80,100,20);
		add(sum);
		
//		meter=new JTextField();
//		meter.setBounds(240, 80, 100, 20);
//		add(meter);
		
		meternum=new Choice();
		
		
		try {
			Bill c=new Bill();
			String s="select *from str";
		ResultSet rs=	c.st.executeQuery(s);
		while(rs.next()) {
			meternum.add(rs.getString("mno"));
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		meternum.setBounds(240,80,100,20);
		add(meternum);
		
		month=new JLabel("Month");
		month.setBounds(100,110,100,20);
		add(month);
		
		
		
		 cmonth = new Choice();
	        cmonth.setBounds(240, 110, 100, 20);
	        cmonth.add("January");
	        cmonth.add("February");
	        cmonth.add("March");
	        cmonth.add("April");
	        cmonth.add("May");
	        cmonth.add("June");
	        cmonth.add("July");
	        cmonth.add("August");
	        cmonth.add("September");
	        cmonth.add("October");
	        cmonth.add("November");
	        cmonth.add("December");
	        add(cmonth);
	        
	        cunits=new JLabel("Consumed units");
			cunits.setBounds(100, 140, 100, 20);
			add(cunits);
			
			tunits=new JTextField();
			tunits.setBounds(240, 140, 100, 20);
			add(tunits);
	        
	        calculate=new JButton("total");
	        calculate.setBounds(120, 390, 100, 25);
	        calculate.addActionListener(this);
	        setVisible(false);
	        new showbill();
	        add(calculate);
		
		setSize(700,500);
		setVisible(true);
		//setLocation(300,200);
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==calculate) {
			
			String mn=meternum.getSelectedItem();
			String mon=cmonth.getSelectedItem();
			String m=tunits.getText();
			
			int unit_con=Integer.parseInt(m);
			
			int total_bill=0;
			String q="select *from tax";
			try {
				Bill c=new Bill();
			ResultSet rs=	c.st.executeQuery(q);
			while(rs.next()) {
			 total_bill+=unit_con*	Integer.parseInt(rs.getString("per_unit"));
			 total_bill+=Integer.parseInt(rs.getString("service_charge"));
			 total_bill+=Integer.parseInt(rs.getString("tax")); 
			//t+=(cal*unit_con);
			 JOptionPane.showMessageDialog(null, "your total bill is   "+ total_bill);
			
				
			}
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
			
			String qu="insert into tbill values('"+mn+"','"+mon+"','"+m+"','"+total_bill+"')";
			try {
				Bill c1=new Bill();
				c1.st.executeUpdate(qu);
				
				JOptionPane.showMessageDialog(null, " customer bill updated sucessfull");
				setVisible(false);
			}
			catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		else {
			setVisible(false);
		}
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new splash();
		System.out.print("jframe");
	}



	

	 

}
