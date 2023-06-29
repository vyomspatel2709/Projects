package Default;

import java.awt.Color;
import java.awt.Image;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Department extends JFrame{
	JLabel table;
	
	Department(){
		getContentPane().setBackground(Color.white); 	
		setLayout(null);
		
		JLabel l1=new JLabel("Department");
		l1.setBounds(180,10,100,20);
		add(l1);
		
		JLabel l2=new JLabel("Budget");
		l2.setBounds(370,10,100,20);
		add(l2);
		
		table=new JLabel();
		table.setBounds(0,40,500,400);
		add(table);
		
				
		setBounds(200,100,1050,600);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Department();
	}

}
