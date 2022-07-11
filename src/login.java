import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class login extends JFrame implements ActionListener {
	JButton submit,cancel;
	JLabel lableusername,lpsw;
	JTextField username,password;
	login(){
		super("Login Page");
		getContentPane().setBackground(Color.gray);
		setLayout(null);
		
		 lableusername=new JLabel("UserName:");
		
		lableusername.setBounds(200, 20, 100, 20);
		
		add(lableusername); 
		
		 username=new JTextField();
		username.setBounds(300, 20, 100, 20);
		add(username);
		
		JLabel lpsw=new JLabel("Password");
		lpsw.setBounds(200, 50, 100, 20);
		add(lpsw);
		
		 password=new JTextField();
		password.setBounds(300, 50,100, 20);
		add(password);
		
		
		 submit=new JButton("Login");
		
		submit.setBounds(250, 100, 80, 25);
		//adding action listener to handle button event
		submit.addActionListener(this);
		add(submit);
		
		cancel=new JButton("cancel");
		cancel.addActionListener(this);
		add(cancel);
		
		
		setSize(500,200);
		setLocation(450,200);
		setVisible(true);
	}
	//create method to handle events
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit) {
			String uname=username.getText();
			String psw=password.getText();
			
			try {
			Bill con =new Bill();
			String qu="select * from str where uname='"+uname+"' and  psw='"+psw+"'";
			ResultSet rs=con.st.executeQuery(qu);
			if(rs.next()) {
				//System.out.println(rs.getString(5));
				setVisible(false);
				new splash();
			}
			else {
				JOptionPane.showMessageDialog(null, "invalid details");
			}
			}
			catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==cancel) {
			setVisible(false);
			new signup();
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new login();
	}

}
