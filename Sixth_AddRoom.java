package sqlConnection;
/*
 * Add function, add showing room
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class Sixth_AddRoom {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnBack;
	boolean add=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sixth_AddRoom window = new Sixth_AddRoom();
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
	public Sixth_AddRoom() {
		initialize();
	}
	
	private static void addRoom(int number, int capacity) {
		String insertRoom = "INSERT INTO Room " + 
				"(roomNumber, capacity) " + "VALUES" +
				"(" + number +", "+ ""+capacity+")";
		try {
			Statement statement = First.connection.createStatement();
			
			statement.executeUpdate(insertRoom);
			
			System.out.println("Record is inserted into Room table!");

			
		} 
		catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Wrong command.");
		}
		catch (SQLException e) {
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
		
		textField = new JTextField();
		textField.setBounds(93, 107, 66, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(239, 107, 66, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setBounds(93, 68, 54, 15);
		frame.getContentPane().add(lblNumber);
		
		JLabel lblCapacity = new JLabel("Capacity");
		lblCapacity.setBounds(239, 68, 54, 15);
		frame.getContentPane().add(lblCapacity);
		
		JLabel lblAddRoom = new JLabel("Add Room");
		lblAddRoom.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblAddRoom.setBounds(150, 10, 130, 27);
		frame.getContentPane().add(lblAddRoom);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(275, 198, 121, 32);
		frame.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num = Integer.parseInt(textField.getText());
				int cap = Integer.parseInt(textField_1.getText());
				addRoom(num, cap);
				add = true;
			}
		});
		
		
		btnBack = new JButton("Back");
		btnBack.setBounds(0, 0, 93, 23);
		frame.getContentPane().add(btnBack);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Fourth_Modify modify=new Fourth_Modify();
					modify.main(null);
					frame.dispose();
				
	}});
	}

}
