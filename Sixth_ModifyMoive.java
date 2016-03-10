package sqlConnection;
/*
 * Modify movie information
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Sixth_ModifyMoive {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnBack;
	ArrayList<JTextField> a=new ArrayList<JTextField>();
	boolean add=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sixth_ModifyMoive window = new Sixth_ModifyMoive();
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
	public Sixth_ModifyMoive() {
		initialize();
	}
	
	private static void modifyMovie(String pk, String attr, String value) {
		String modifyMovie = "UPDATE Movie" + 
								" SET " + attr+" = '" + value +
								"' WHERE title = '"+pk+"'";
		try {
			Statement statement = First.connection.createStatement();
			
			statement.execute(modifyMovie);
			
			System.out.println("Movie modified successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void addGenre(String movie, String genre) {
		String insertGenre = "INSERT INTO Genre " + 
								"VALUES" + 
								" ('" + movie + "' , '"+ genre + "')";
		try {
			Statement statement = First.connection.createStatement();
			
			statement.executeUpdate(insertGenre);
			
			System.out.println("Record is inserted into Genre table!");

			
		} 
		catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Wrong command.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void deleteGenre(String movie) {
		String deleteGenre = "DELETE Genre "
							+ "WHERE movie = '" + movie+"'";
		try {
			Statement statement = First.connection.createStatement();
			
			statement.execute(deleteGenre);
			
			System.out.println("Genre deleted successfully.");
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
		
		JButton btnSaveChanges = new JButton("Save changes");
		btnSaveChanges.setBounds(294, 218, 115, 23);
		frame.add(btnSaveChanges);
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length() > 0) {
					String title = textField.getText().toString();
					if(textField_1.getText().length() > 0) {
						deleteGenre(title);
						String genres = textField_1.getText().toString();
						String[] genre = genres.split(",");
						for(int i = 0; i < genre.length; i++) {
							addGenre(title, genre[i]);
						}
					}
					if(textField_2.getText().length() > 0) {
						String year = textField_2.getText();
						modifyMovie(title, "year", year);
					}
					if(textField_3.getText().length() > 0) {
						String length = textField_3.getText();
						modifyMovie(title, "length", length);
					}
					if(textField_4.getText().length() > 0) {
						String pgrating = textField_4.getText();
						modifyMovie(title, "pgrating", pgrating);
					}
					if(textField_5.getText().length() > 0) {
						String poster = textField_5.getText();
						modifyMovie(title, "poster", poster);
					}
				}
				
				
				add=true;	      }
		    });
		
		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setBounds(32, 39, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("genres");
		lblNewLabel_1.setBounds(85, 39, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Year");
		lblNewLabel_2.setBounds(149, 39, 54, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PG rating");
		lblNewLabel_3.setBounds(264, 39, 54, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Length");
		lblNewLabel_4.setBounds(200, 39, 54, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Poster");
		lblNewLabel_5.setBounds(338, 39, 54, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblModifyMovie = new JLabel("Modify Movie");
		lblModifyMovie.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblModifyMovie.setBounds(137, 0, 198, 27);
		frame.getContentPane().add(lblModifyMovie);
		
		
		btnBack = new JButton("Back");
		btnBack.setBounds(0, 2, 93, 23);
		frame.getContentPane().add(btnBack);

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Fifth_Modify modify=new Fifth_Modify();
				modify.main(null);
				frame.dispose();
			}});

		textField = new JTextField();
		textField.setBounds(10, 59, 66, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		if(add=true){
		a.add(textField);
		}
		
		textField_1 = new JTextField();
		textField_1.setBounds(80, 59, 54, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		if(add=true){
		a.add(textField_1);
		}
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 59, 44, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		if(add=true){
			a.add(textField_2);
			}
		
		textField_3 = new JTextField();
		textField_3.setBounds(200, 64, 44, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		if(add=true){
			a.add(textField_3);
			}
		
		textField_4 = new JTextField();
		textField_4.setBounds(252, 59, 66, 21);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		if(add=true){
			a.add(textField_4);
			}
		
		textField_5 = new JTextField();
		textField_5.setBounds(328, 59, 54, 21);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		if(add=true){
			a.add(textField_5);
			}
		
}
}
