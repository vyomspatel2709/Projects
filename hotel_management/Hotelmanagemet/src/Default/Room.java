package Default;

import java.awt.Color;
import java.awt.Image;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Room extends JFrame{
	JLabel table;
	
	Room(){
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
		Image i2=i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(500,0,600,600);
		add(image);
		
		table=new JLabel();
		table.setBounds(0,40,500,400);
		add(table);
		
				
		setBounds(200,100,1050,600);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Room();
	}

}
