package sqlConnection;
/*
 * The behavior of writer
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

public class AddWrite {

	private JFrame frame;
	private JTextField aWriteID;
	private JTextField aWriteMovie;
	boolean add = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddWrite window = new AddWrite();
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
	public AddWrite() {
		initialize();
	}
	
	private static void addWrite(int id, String movie) {
		String insertWrite = "INSERT INTO Write " + 
				"(writerId, movie) " + "VALUES" +
				"(" + id +", "+ "'"+movie+"')";
		try {
			Statement statement = First.connection.createStatement();
			
			statement.executeUpdate(insertWrite);
			
			System.out.println("Record is inserted into Write table!");

			
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
		
		JLabel lblAddWrite = new JLabel("Add Write");
		lblAddWrite.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblAddWrite.setBounds(156, 10, 133, 52);
		frame.getContentPane().add(lblAddWrite);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(129, 85, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Movie");
		lblNewLabel_1.setBounds(255, 85, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		aWriteID = new JTextField();
		aWriteID.setBounds(107, 124, 66, 21);
		frame.getContentPane().add(aWriteID);
		aWriteID.setColumns(10);
		
		aWriteMovie = new JTextField();
		aWriteMovie.setBounds(243, 124, 66, 21);
		frame.getContentPane().add(aWriteMovie);
		aWriteMovie.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(287, 197, 98, 35);
		frame.getContentPane().add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(aWriteID.getText());
				String movie = aWriteMovie.getText().toString();
				addWrite(id, movie);
				add = true;
			}
		});
		
		JButton btnBack = new JButton("Back");
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
