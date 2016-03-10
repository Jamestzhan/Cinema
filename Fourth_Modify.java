package sqlConnection;
/*
 * THe staff modify panel, which you can modify the information in under different button.
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fourth_Modify {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fourth_Modify window = new Fourth_Modify();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Fourth_Modify() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStaffModify = new JLabel("Staff Modify");
		lblStaffModify.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblStaffModify.setBounds(243, 20, 118, 23);
		frame.getContentPane().add(lblStaffModify);
		
		JLabel lblAdd = new JLabel("Add");
		lblAdd.setForeground(Color.RED);
		lblAdd.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAdd.setBounds(10, 76, 76, 38);
		frame.getContentPane().add(lblAdd);
		
		JLabel lblNewLabel = new JLabel("Delete");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(10, 164, 62, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Modify");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(10, 218, 62, 24);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		JButton btnNewButton = new JButton("Movie");
		btnNewButton.setBounds(110, 68, 93, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Sixth_AddMovie addmovie=new Sixth_AddMovie();
					addmovie.main(null);
					frame.dispose();
				
	}});
		
		JButton btnNewButton_1 = new JButton("Person");
		btnNewButton_1.setBounds(233, 68, 93, 23);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Sixth_AddPerson addperson=new Sixth_AddPerson();
					addperson.main(null);
					frame.dispose();
				
	}});
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.setBounds(110, 166, 93, 23);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Fifth_Delete delete=new Fifth_Delete();
					delete.main(null);
					frame.dispose();
				
	}});
		
		JButton btnNewButton_3 = new JButton("Modify");
		btnNewButton_3.setBounds(110, 221, 93, 23);
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Fifth_Modify modify=new Fifth_Modify();
					modify.main(null);
					frame.dispose();
				
	}});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(0, 0, 93, 23);
		frame.getContentPane().add(btnBack);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(First.v==1){
					Third_Member member=new Third_Member();
					member.main(null);
					frame.dispose();
				}
				if(First.v==2){
					Third_Staff staff=new Third_Staff();
				    staff.main(null);
				    frame.dispose();}
			
		}
		});
		
		JButton btnNewButton_5 = new JButton("Room");
		btnNewButton_5.setBounds(362, 68, 93, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Sixth_AddRoom addRoom=new Sixth_AddRoom();
				addRoom.main(null);
				frame.dispose();
				
	}});
		
		JButton btnShowing = new JButton("Showing");
		btnShowing.setBounds(481, 68, 93, 23);
		frame.getContentPane().add(btnShowing);
		btnShowing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Sixth_AddShowing addShowing=new Sixth_AddShowing();
				addShowing.main(null);
				frame.dispose();
				
	}});
		
		JButton btnNewButton_4 = new JButton("Direct");
		btnNewButton_4.setBounds(110, 111, 93, 23);
		frame.getContentPane().add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddDirect addDirect=new AddDirect();
				addDirect.main(null);
				frame.dispose();
				
	}});
		
		JButton btnNewButton_6 = new JButton("Write");
		btnNewButton_6.setBounds(233, 111, 93, 23);
		frame.getContentPane().add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddWrite addWrite=new AddWrite();
				addWrite.main(null);
				frame.dispose();
				
	}});
		
		JButton btnNewButton_7 = new JButton("Act");
		btnNewButton_7.setBounds(362, 111, 93, 23);
		frame.getContentPane().add(btnNewButton_7);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddAct addAct=new AddAct();
				addAct.main(null);
				frame.dispose();
				
	}});
		
		
	}
}
