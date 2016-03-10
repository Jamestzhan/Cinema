package sqlConnection;
/*
 * Modify the information of the showing room
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Sixth_ModifyRoom {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	boolean add = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sixth_ModifyRoom window = new Sixth_ModifyRoom();
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
	public Sixth_ModifyRoom() {
		initialize();
	}
	
	private static void modifyRoom(int number, int capacity) {
		String modifyRoom = "UPDATE Room" + 
				" SET capacity" + " = " + capacity +
				" WHERE roomNumber = "+number;
		try {
			Statement statement = First.connection.createStatement();
			
			statement.execute(modifyRoom);
			
			System.out.println("Room modified successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblModifyRoom = new JLabel("Modify Room");
		lblModifyRoom.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblModifyRoom.setBounds(140, 10, 138, 37);
		frame.getContentPane().add(lblModifyRoom);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setBounds(88, 85, 54, 15);
		frame.getContentPane().add(lblNumber);
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setBounds(237, 85, 54, 15);
		frame.getContentPane().add(lblCapacity);
		
		textField = new JTextField();
		textField.setBounds(76, 120, 66, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(236, 120, 66, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSaveChanges = new JButton("Save changes");
		btnSaveChanges.setBounds(288, 196, 116, 44);
		frame.add(btnSaveChanges);
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int room = Integer.parseInt(textField.getText());
				int cap = Integer.parseInt(textField_1.getText());
				modifyRoom(room, cap);
				add = true;
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(0, 2, 93, 23);
		frame.getContentPane().add(btnBack);

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Fifth_Modify modify=new Fifth_Modify();
				modify.main(null);
				frame.dispose();

			}});
	}

}
