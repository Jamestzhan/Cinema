package sqlConnection;
/*
 * Modify the movie information in different ways
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fifth_Modify {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fifth_Modify window = new Fifth_Modify();
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
	public Fifth_Modify() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Modify \r\nMovie");
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(68, 58, 123, 86);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Sixth_ModifyMoive.main(null);
					frame.dispose();
				
	}});
		
		JButton btnNewButton_1 = new JButton("Modify Person");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBounds(234, 58, 117, 86);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Sixth_ModifyPerson.main(null);
					frame.dispose();
				
	}});
		
		JLabel lblModify = new JLabel("Modify ");
		lblModify.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblModify.setBounds(178, 10, 63, 22);
		frame.getContentPane().add(lblModify);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(0, 0, 93, 23);
		frame.getContentPane().add(btnBack);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Fourth_Modify modify=new Fourth_Modify();
					modify.main(null);
					frame.dispose();
				
	}});
		
		JButton btnNewButton_2 = new JButton("Modify Room");
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setBounds(68, 154, 123, 82);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Sixth_ModifyRoom.main(null);
					frame.dispose();
				
	}});
		
		JButton btnNewButton_3 = new JButton("Modify Showing");
		btnNewButton_3.setForeground(Color.RED);
		btnNewButton_3.setBounds(235, 154, 116, 82);
		frame.getContentPane().add(btnNewButton_3);
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Sixth_ModifyShowing.main(null);
					frame.dispose();
				
	}});

	}

}
