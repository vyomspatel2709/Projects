package Default;

import java.awt.*;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;
import com.mysql.jdbc.ResultSet;

import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
	
	JTextField username;
	JPasswordField password;
	JButton login,cancel;
	
	Login(){
		getContentPane().setBackground(Color.white);
		
		setLayout(null);
		setResizable(false);
		
		JLabel user=new JLabel("Username");
		user.setBounds(40,20,100,30);
		add(user);
		
		username =new JTextField();
		username.setBounds(150,20,150,30);
		add(username);
		
		JLabel pass=new JLabel("Password");
		pass.setBounds(40,70,100,30);
		add(pass);
		
		password =new JPasswordField();
		password.setBounds(150,70,150,30);
		add(password);
		
		login = new JButton("Login");
		login.setBounds(40,150,120,30);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		login.setFont(new Font("serif",Font.ITALIC,15));
		login.addActionListener(this);
		add(login);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(180,150,120,30);
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("serif",Font.ITALIC,15));
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(350,10,200,200);
		add(image);
		
		setBounds(500,200,600,300);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae){
		if (ae.getSource() == login) {
			String user=username.getText();
			String pass=password.getText();
			
			try {
				 Conn c=new Conn();
				 
				 String query= "select * from hotelmanagementsystem where username='"+ user + "' and password='"+ pass +"'";
				 java.sql.ResultSet rst = c.s.executeQuery(query);
				
				if(rst.next()) {
					setVisible(false);
					new Dashboard();
				}
				else {
					JOptionPane.showConfirmDialog(null,"Invalid username and password");
					setVisible(false);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		} else if(ae.getSource() == cancel) {
			setVisible(false);
		}
	}
	public static void main(String[] args) {
		new Login();
	}
	
}
