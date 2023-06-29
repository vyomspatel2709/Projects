package Default;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.Date;

public class Checkout extends JFrame implements ActionListener{

	JLabel lblroomnumber,lblcheckintime,lblcheckouttime;
	Choice ccustomer;
	JButton checkout,back;
		Checkout(){
			
			getContentPane().setBackground(Color.white);
			setLayout(null);
			
			JLabel text=new JLabel("Checkout");
			text.setBounds(100,20,100,30);
			text.setForeground(Color.blue);
			text.setFont(new Font("Tahoma",Font.PLAIN,20));
			add(text);
			
			JLabel lblid=new JLabel("Customer Id");
			lblid.setBounds(30,80,100,30);
			add(lblid);
			
			ccustomer=new Choice();
			ccustomer.setBounds(150,85,150,25);
			add(ccustomer);
			
			ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
			Image i2=i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT );
			ImageIcon i3=new ImageIcon(i2);
			JLabel tick=new JLabel(i3	);
			tick.setBounds(310,85,20,20);
			add(tick);
			
			JLabel lblroom=new JLabel("Room Number");
			lblroom.setBounds(30,130,100,30);
			add(lblroom);
			
			lblroomnumber=new JLabel();
			lblroomnumber.setBounds(150,130,100,30);
			add(lblroomnumber);
			
			JLabel lblcheckin=new JLabel("Checkin Time");
			lblcheckin.setBounds(30,180,100,30);
			add(lblcheckin);
			
			lblcheckintime=new JLabel();
			lblcheckintime.setBounds(150,180,100,30);
			add(lblcheckintime);
			
			JLabel lblcheckout=new JLabel("Checkout Time");
			lblcheckout.setBounds(30,230,100,30);
			add(lblcheckout);
			
			Date date=new Date();
			lblcheckouttime=new JLabel(""+date);
			lblcheckouttime.setBounds(150,230,180,30);
			add(lblcheckouttime);
			
			checkout = new JButton("Checkout");
			checkout.setBackground(Color.black);
			checkout.setForeground(Color.white);
			checkout.setBounds(30,280,120,30);
			checkout.addActionListener(this);
			add(checkout);
			
			back = new JButton("Back");
			back.setBackground(Color.black);
			back.setForeground(Color.white);
			back.setBounds(170,280,120,30);
			back.addActionListener(this);
			add(back);
			
			try {
				Conn c=new Conn();
				java.sql.ResultSet rs=c.s.executeQuery("select * from customer");
				while (rs.next()) {
					ccustomer.add(rs.getString("number"));
					lblroomnumber.setText(rs.getString("room"));
					lblcheckintime.setText(rs.getString("checkintime"));
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
			Image i5=i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT );
			ImageIcon i6=new ImageIcon(i5);
			JLabel image=new JLabel(i6);
			image.setBounds(350,50,400,250);
			add(image);
			
			setBounds(300,200,800,400);
			setVisible(true);
			
		}
		
		@Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()== checkout) {
				String query1="delete from customer where number='"+ccustomer.getSelectedItem()+"'";
				String query2="update rooms set availability ='Available' where roomnumber='"+lblroomnumber.getText()+"'";
				
				try {
					Conn c=new Conn();
					c.s.executeUpdate(query1);
					c.s.executeUpdate(query2);
					
					JOptionPane.showMessageDialog(null,"Checkout Done");
				
					setVisible(false);
					new Reception();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else {
				setVisible(true);
				new Reception();
			}
		}
		public static void main(String[] args) {
			new Checkout();
		}
}
