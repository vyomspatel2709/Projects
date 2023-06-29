package Default;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.*;

@SuppressWarnings("serial")
public class AddRoom extends JFrame implements ActionListener  {
	JButton add,cancel;
	JTextField tfroom,tfprice;
	JComboBox<String> availablecombo,cleancombo,bedcombo;
	
	AddRoom(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel heading=new JLabel("Add Rooms");
		heading.setFont(new Font("Tahoma", Font.BOLD,18));
		heading.setBounds(150,20,200,20);
		add(heading);
		
		JLabel lblroomno=new JLabel("Room Number");
		lblroomno.setFont(new Font("Tahoma", Font.PLAIN,16));
		lblroomno.setBounds(60,80,120,30);
		add(lblroomno);

		tfroom=new JTextField();
		tfroom.setBounds(200,80,150,30);
		add(tfroom);
		
		JLabel lblavailable=new JLabel("Available");
		lblavailable.setFont(new Font("Tahoma", Font.PLAIN,16));
		lblavailable.setBounds(60,130,120,30);
		add(lblavailable);

		String availableoptions[]= {"Available","Occupied"};
		availablecombo=new JComboBox<String>(availableoptions);
		availablecombo.setBounds(200,130,150,30);
		availablecombo.setBackground(Color.white);
		add(availablecombo);
		
		JLabel lblclean=new JLabel("Cleaning Status");
		lblclean.setFont(new Font("Tahoma", Font.PLAIN,16));
		lblclean.setBounds(60,180,120,30);
		add(lblclean);
		
		String cleanoptions[]= {"Clean","Dirty"};
		cleancombo=new JComboBox<String>(cleanoptions);
		cleancombo.setBounds(200,180,150,30);
		cleancombo.setBackground(Color.white);
		add(cleancombo);

		JLabel lblprice=new JLabel("Price");
		lblprice.setFont(new Font("Tahoma", Font.PLAIN,16));
		lblprice.setBounds(60,230,120,30);
		add(lblprice);
	
		tfprice=new JTextField();
		tfprice.setBounds(200,230,150,30);
		add(tfprice);
		
		JLabel lbltype=new JLabel("Bed Type");
		lbltype.setFont(new Font("Tahoma", Font.PLAIN,16));
		lbltype.setBounds(60,280,120,30);
		add(lbltype);
		
		String bedoptions[]= {"Single","Double"};
		bedcombo=new JComboBox<String>(bedoptions);
		bedcombo.setBounds(200,280,150,30);
		add(bedcombo);

		add = new JButton("Add");
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		add.setBounds(60, 350, 130, 30);
		add.addActionListener(this);
		add(add);
		
		cancel=new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setBounds(220, 350, 130, 30);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
		JLabel image=new JLabel(i1);
		image.setBounds(400,30,500,300);
		add(image);
		
		setBounds(330,200,940,470);
		setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource() == add) {
			String roomnumber =tfroom.getText();
			String availability = (String) availablecombo.getSelectedItem();
			String status=(String) cleancombo.getSelectedItem();
			String price=(String)tfprice.getText();
			String type=(String) bedcombo.getSelectedItem();

			try {
				Conn conn=new Conn();
				String str="insert into rooms values('"+roomnumber+"','"+availability+"','"+status+"','"+price+"','"+type+"')";
			
				conn.s.executeUpdate(str);
				
				
				JOptionPane.showMessageDialog(null, "New Room Added Successfully");
				setVisible(false);

			} catch (Exception e2) {
				e2.printStackTrace();
			}
	}
	}
	public static void main(String[] args) {
		new AddRoom();
	}
}