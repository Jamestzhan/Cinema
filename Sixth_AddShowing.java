package sqlConnection;
/*
 *Add function, add a new showing
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Sixth_AddShowing {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnBack;
	boolean add = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sixth_AddShowing window = new Sixth_AddShowing();
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
	public Sixth_AddShowing() {
		initialize();
	}
	
	private static void addShowing(String time, int room, String movie) {
		String insertShowing = "INSERT INTO Showing " + 
				"(startTime, inRoom, movie) " + "VALUES" +
				"(TO_DATE('" + time+ "','yyyy-mm-dd hh24:mi:ss'), " 
				+ room +", '" + movie + "')";
		try {
			Statement statement = First.connection.createStatement();
			
			statement.executeUpdate(insertShowing);
			
			System.out.println("Record is inserted into Showing table!");

			
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
		
		JLabel lblNewLabel = new JLabel("Time");
		lblNewLabel.setBounds(70, 77, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Room");
		lblNewLabel_1.setBounds(179, 77, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Movie");
		lblNewLabel_2.setBounds(301, 77, 54, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblAddShowing = new JLabel("Add Showing");
		lblAddShowing.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblAddShowing.setBounds(144, 10, 123, 20);
		frame.getContentPane().add(lblAddShowing);
		
		textField = new JTextField();
		textField.setBounds(56, 111, 66, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(162, 111, 66, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(284, 111, 66, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(271, 200, 123, 33);
		frame.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String time = textField.getText().toString();
				int room = Integer.parseInt(textField_1.getText());
				String movie = textField_2.getText().toString();
				addShowing(time, room, movie);
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
