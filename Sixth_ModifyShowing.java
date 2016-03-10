package sqlConnection;
/*
 * Modify a showing
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;

public class Sixth_ModifyShowing {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	boolean add = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sixth_ModifyShowing window = new Sixth_ModifyShowing();
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
	public Sixth_ModifyShowing() {
		initialize();
	}
	
	private static void modifyShowing(String time, int room, String movie) {
		String modifyShowing = "UPDATE Showing" + 
				" SET movie" + " = '" + movie +
				"' WHERE startTime = (TO_DATE('" + time+ "','yyyy-mm-dd hh24:mi:ss') "
				+"AND inRoom = "+room;
		try {
			Statement statement = First.connection.createStatement();
			
			statement.execute(modifyShowing);
			
			System.out.println("Showing modified successfully.");
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
		
		JLabel lblModifyShowing = new JLabel("Modify Showing");
		lblModifyShowing.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblModifyShowing.setBounds(118, 10, 163, 42);
		frame.getContentPane().add(lblModifyShowing);
		
		JButton btnNewButton = new JButton("Save changes");
		btnNewButton.setBounds(269, 195, 123, 42);
		frame.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String time = textField.getText().toString();
				int room = Integer.parseInt(textField_1.getText());
				String movie = textField_2.getText().toString();
				modifyShowing(time, room, movie);
				add = true;
			}
		});
		
		JLabel lblNewLabel = new JLabel("Time");
		lblNewLabel.setBounds(53, 73, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Room");
		lblNewLabel_1.setBounds(168, 73, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Modify");
		lblNewLabel_2.setBounds(281, 73, 54, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(42, 114, 66, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(156, 114, 66, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(269, 114, 66, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
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
