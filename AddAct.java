package sqlConnection;
/*
 * The behavior of actor
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

import javax.swing.JButton;
import javax.swing.JTextField;

public class AddAct {

	private JFrame frame;
	private JTextField aActName;
	private JTextField aActID;
	private JTextField aActMovie;
	boolean add = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAct window = new AddAct();
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
	public AddAct() {
		initialize();
	}
	
	private static void addRole(String name, int id, String movie) {
		String insertRole = "INSERT INTO Role " + 
				"(name, playerId, movie) " + "VALUES" +
				"('" + name + "', " + id +", "+ "'"+movie+"')";
		try {
			Statement statement = First.connection.createStatement();
			
			statement.executeUpdate(insertRole);
			
			System.out.println("Record is inserted into Role table!");

			
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
		
		JLabel lblAddAct = new JLabel("Add Act");
		lblAddAct.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblAddAct.setBounds(164, 10, 111, 40);
		frame.getContentPane().add(lblAddAct);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(62, 81, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setBounds(177, 81, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Movie");
		lblNewLabel_2.setBounds(291, 81, 54, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(308, 215, 93, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = aActName.getText().toString();
				int id = Integer.parseInt(aActID.getText());
				String movie = aActMovie.getText().toString();
				addRole(name, id, movie);
				add = true;
			}
		});
		
		aActName = new JTextField();
		aActName.setBounds(63, 128, 66, 21);
		frame.getContentPane().add(aActName);
		aActName.setColumns(10);
		
		aActID = new JTextField();
		aActID.setBounds(177, 128, 66, 21);
		frame.getContentPane().add(aActID);
		aActID.setColumns(10);
		
		aActMovie = new JTextField();
		aActMovie.setBounds(291, 128, 66, 21);
		frame.getContentPane().add(aActMovie);
		aActMovie.setColumns(10);
		
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
