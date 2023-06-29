package Default;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{

	
	JTextField tfname,tage,tsalary,tphone,temail,taadhar;
	JRadioButton rbmale,rbfemale;
	JButton submit;
	JComboBox cbjob;	
	 AddEmployee() {
		 setLayout(null);
		 
		 JLabel lblname = new JLabel("Name");
		 lblname.setBounds(60,30,120,30);
		 lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
		 add(lblname);
		 
		  tfname = new  JTextField();
		 tfname.setBounds(200,30,150,30);
		 add(tfname);
		 
		 JLabel lblage = new JLabel("Age");
		 lblage.setBounds(60,80,120,30);
		 lblage.setFont(new Font("Tahoma",Font.PLAIN,17));
		 add(lblage);
		 
		  tage = new  JTextField();
		 tage.setBounds(200,80,150,30);
		 add(tage);
		 
		 JLabel lblgender = new JLabel("Gender");
		 lblgender.setBounds(60,130,120,30);
		 lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
		 add(lblgender);
		 
		  rbmale = new JRadioButton("Male");
		 rbmale.setBounds(200,130,70,30);
		 rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
		 rbmale.setBackground(Color.white);
		 add(rbmale);
		 
		  rbfemale = new JRadioButton("Female");
		 rbfemale.setBounds(280,130,70,30);
		 rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
		 rbfemale.setBackground(Color.white);
		 add(rbfemale);

		 ButtonGroup bg=new ButtonGroup();
		 bg.add(rbmale);
		 bg.add(rbfemale);
		 
		 JLabel lbljob = new JLabel("Job");
		 lbljob.setBounds(60,180,120,30);
		 lbljob.setFont(new Font("Tahoma",Font.PLAIN,17));
		 add(lbljob);
		 
		 String str[] = { "Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiter/Waiteress","Accountant"};
		  cbjob=new JComboBox(str);
		 cbjob.setBounds(200,180,150,30);
		 cbjob.setFont(new Font("Tahoma",Font.PLAIN,14));
		 cbjob.setBackground(Color.white);
		 add(cbjob);
		 
		 JLabel lblsalary = new JLabel("Salary");
		 lblsalary.setBounds(60,230,120,30);
		 lblsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
		 add(lblsalary);
		 
		  tsalary = new  JTextField();
		 tsalary.setBounds(200,230,150,30);
		 add(tsalary);
		 
		 JLabel lblphone = new JLabel("Phone");
		 lblphone.setBounds(60,280,120,30);
		 lblphone.setFont(new Font("Tahoma",Font.PLAIN,17));
		 add(lblphone);
		 
		  tphone = new  JTextField();
		 tphone.setBounds(200,280,150,30);
		 add(tphone);
		 
		 JLabel lblemail = new JLabel("Email");
		 lblemail.setBounds(60,330,120,30);
		 lblemail.setFont(new Font("Tahoma",Font.PLAIN,17));
		 add(lblemail);
		 
		  temail = new  JTextField();
		 temail.setBounds(200,330,150,30);
		 add(temail);

		 JLabel lblaadhar = new JLabel("Aadhar");
		 lblaadhar.setBounds(60,380,120,30);
		 lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
		 add(lblaadhar);
		 
		  taadhar = new  JTextField();
		 taadhar.setBounds(200,380,150,30);
		 add(taadhar);
		 
		  submit=new JButton("SUBMIT");
		 submit.setBackground(Color.black);
		 submit.setForeground(Color.WHITE);
		 submit.setBounds(200,430,150,30);
		 submit.addActionListener(this);
		 add(submit);
		 
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
		 Image i2=i1.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
		 ImageIcon i3= new ImageIcon(i2);
		 JLabel image = new JLabel(i3);
		 image.setBounds(380,60,450,370);
		 add(image);
		 
		 getContentPane().setBackground(Color.WHITE);
		 setBounds(350,100,850,540);
		 setVisible(true);
	 }
	 public void actionPerformed(ActionEvent  ae) {
		 String name=tfname.getText();
		 String age=tage.getText();
		 String salary=tsalary.getText();
		 String phone=tphone.getText();
		 String email=temail.getText();
		 String aadhar=taadhar.getText();
		 
		 String gender=null;
		 
		 if(name.equals("")) {
			 JOptionPane.showMessageDialog(null, "Name should not be empty");
			 return;
		 }
		 
		 if(rbmale.isSelected()) {
			 gender="Male";
		 }else if(rbfemale.isSelected()){
			 gender="female";
		 }
		 String job=(String) cbjob.getSelectedItem();
	
		 try {
			Conn conn=new Conn();
			
			String query="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
			
			conn.s.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "Employee Added");
			setVisible(false);
			
		 } catch (Exception e) {
			e.printStackTrace();
		}

	 }
	 public static void main(String[] args) {
		new AddEmployee();
	}
}
