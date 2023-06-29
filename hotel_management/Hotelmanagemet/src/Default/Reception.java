package Default;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Reception 	extends JFrame implements ActionListener{

	JButton newcustomer,update,roomstatus,checkout,logout;
	Reception(){
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		newcustomer=new JButton("New Customer Form");
		newcustomer.setBounds(10, 30, 200, 30);
		newcustomer.setBackground(Color.BLACK);
		newcustomer.setForeground(Color.white);
		newcustomer.addActionListener(this);
		add(newcustomer);

		JButton rooms=new JButton("Rooms");
		rooms.setBounds(10, 70, 200, 30);
		rooms.setBackground(Color.BLACK);
		rooms.setForeground(Color.white);
		rooms.addActionListener(this);
		add(rooms);
		
		JButton department=new JButton("Department");
		department.setBounds(10, 110, 200, 30);
		department.setBackground(Color.BLACK);
		department.setForeground(Color.white);
		add(department);
		
		JButton allEmpoloyee=new JButton("All Employees");
		allEmpoloyee.setBounds(10, 150, 200, 30);
		allEmpoloyee.setBackground(Color.BLACK);
		allEmpoloyee.setForeground(Color.white);
		add(allEmpoloyee);
		
		JButton customers=new JButton("Customer Info");
		customers.setBounds(10, 190, 200, 30);
		customers.setBackground(Color.BLACK);
		customers.setForeground(Color.white);
		add(customers);
		
		JButton managerInfo=new JButton("Manager Info");
		managerInfo.setBounds(10, 230, 200, 30);
		managerInfo.setBackground(Color.BLACK);
		managerInfo.setForeground(Color.white);
		add(managerInfo);
		
		checkout=new JButton("Checkout");
		checkout.setBounds(10, 270, 200, 30);
		checkout.setBackground(Color.BLACK);
		checkout.setForeground(Color.white);
		checkout.addActionListener(this);
		add(checkout);
		
		update=new JButton("Update Status");
		update.setBounds(10, 310, 200, 30);
		update.setBackground(Color.BLACK);
		update.setForeground(Color.white);
		update.addActionListener(this);
		add(update);
		
		roomstatus=new JButton("Update Room Status");
		roomstatus.setBounds(10, 350, 200, 30);
		roomstatus.setBackground(Color.BLACK);
		roomstatus.setForeground(Color.white);
		add(roomstatus);
		
		JButton pickup=new JButton("Pickup Service");
		pickup.setBounds(10, 390, 200, 30);
		pickup.setBackground(Color.BLACK);
		pickup.setForeground(Color.white);
		add(pickup);
		
		JButton searchRoom=new JButton("Search Room");
		searchRoom.setBounds(10, 430, 200, 30);
		searchRoom.setBackground(Color.BLACK);
		searchRoom.setForeground(Color.white);
		add(searchRoom);
		
		logout=new JButton("Logout");
		logout.setBounds(10, 470,200, 30);
		logout.setBackground(Color.black);
		logout.setForeground(Color.white);
		logout.addActionListener(this);
		add(logout);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
		JLabel image=new JLabel(i1);
		image.setBounds(250,30,500,470);
		add(image);	
		
		setBounds(350,100,800,570);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == newcustomer) {
			setVisible(false);
			new AddCustomer();
		}
		else if(ae.getSource() == update) {
			setVisible(false);
			new UpdateCheck();
		}
		else if(ae.getSource() == roomstatus) {
			setVisible(false);
			new UpdateRoom();
		}
		else if(ae.getSource()== checkout) {
			setVisible(false);
			new Checkout();
		}
		else if(ae.getSource()== logout) {
			setVisible(false);
			System.exit(0);
		}
		
	}
	public static void main(String[] args) {
		new Reception();
	}
}
