package sqlConnection;
/*
 * The behavior of director
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

public class AddDirect {

	private JFrame frame;
	private JTextField aDirectID;
	private JTextField aDirectMovie;
	boolean add = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDirect window = new AddDirect();
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
	public AddDirect() {
		initialize();
	}
	
	private static void addDirect(int id, String movie) {
		String insertDirect = "INSERT INTO Direct " + 
				"(directorId, movie) " + "VALUES" +
				"(" + id +", "+ "'"+movie+"')";
		try {
			Statement statement = First.connection.createStatement();
			
			statement.executeUpdate(insertDirect);
			
			System.out.println("Record is inserted into Direct table!");

			
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
		
		JLabel lblAddDirect = new JLabel("Add Direct");
		lblAddDirect.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblAddDirect.setBounds(153, 10, 129, 33);
		frame.getContentPane().add(lblAddDirect);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(128, 67, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Movie");
		lblNewLabel_1.setBounds(246, 67, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		aDirectID = new JTextField();
		aDirectID.setBounds(116, 112, 66, 21);
		frame.getContentPane().add(aDirectID);
		aDirectID.setColumns(10);
		
		aDirectMovie = new JTextField();
		aDirectMovie.setBounds(246, 112, 66, 21);
		frame.getContentPane().add(aDirectMovie);
		aDirectMovie.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(265, 189, 115, 40);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(aDirectID.getText());
				String movie = aDirectMovie.getText().toString();
				addDirect(id, movie);
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
