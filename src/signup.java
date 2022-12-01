import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class signup extends JFrame implements ActionListener{
	JButton back,create;
	Choice accountType;
	JLabel luname,lmeterNo,lpassword,lunits;
	JTextField uname,meterNo,password,units;
	signup(){
		super("Sign Up");
	
		setLayout(null);
		
			getContentPane().setBackground(Color.pink);
		JLabel heading=new JLabel("Create Account:");
		heading.setBounds(100, 20, 150, 30);
		add(heading);
		
		
		
		accountType=new Choice();
		accountType.setBounds(300, 20, 160, 30);
		accountType.add("Admin");
		accountType.add("Custormer");
		add(accountType);
		
		
		luname=new JLabel("username");
		luname.setBounds(100, 50, 150, 30);
		add(luname);
		
		uname=new JTextField();
		uname.setBounds(300,50,160,25);
		add(uname);
		
		
		lmeterNo=new JLabel("meter");
		lmeterNo.setBounds(100,80,150,30);
		lmeterNo.setVisible(false);
		add(lmeterNo);
		
		meterNo=new JTextField();
		meterNo.setBounds(300,80,160,25);
		meterNo.setVisible(false);
		add(meterNo);
		
//		meterNo.addFocusListener(new focusListener() {
//			 
//		});
		
		lpassword=new JLabel("password");
		lpassword.setBounds(100,110,150,30);
		add(lpassword);
		
		password=new JTextField();
		password.setBounds(300, 110, 160, 25);
		add(password);
		
		lunits=new JLabel("enter units");
		lunits.setBounds(100,140,170,30);
		add(lunits);
		
		units=new JTextField();
		units.setBounds(300,140,150,30);
		add(units);
		
		//to enable meter number for customer
		accountType.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ae) {
				String user=accountType.getSelectedItem();
				if(user.equals("Custormer")) {
					lmeterNo.setVisible(true);
					meterNo.setVisible(true);
					lunits.setVisible(false);
					units.setVisible(false);
				}
				else {
					lmeterNo.setVisible(false);
					meterNo.setVisible(false);
					lunits.setVisible(true);
					units.setVisible(true);
				}
			}
		});
			
		
		
		back=new JButton("Back");
		back.setBounds(150, 300, 150, 30);
		back.addActionListener(this);
		add(back);
		
		create=new JButton("create");
		create.setBounds(400, 300, 150, 30);
		create.addActionListener(this);
		add(create);
		
		setSize(700,450);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==create) {
				
			
			//creating database objects
			String ac=accountType.getSelectedItem();
			String mno=meterNo.getText();
			String psw=password.getText();
			String name=uname.getText();
			String unit=units.getText();
		
			//database statements
			try {
				Bill con=new Bill();
				String qu="insert into str values('"+ac+"','"+mno+"','"+psw+"','"+name+"','"+unit+"')";
				con.st.executeUpdate(qu);
				JOptionPane.showMessageDialog(null, "account created");
				setVisible(false);
				new login();
							}
			catch(Exception  e1){
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==back) {
			setVisible(false);
			new signup();
			
		}
	}
public static void main(String[] args) {
	new signup();
}
}

	 
	 