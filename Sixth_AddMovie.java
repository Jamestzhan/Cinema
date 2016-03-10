package sqlConnection;
/*
 * Add function, add a new movie
 *
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

public class Sixth_AddMovie {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	ArrayList<JTextField> a=new ArrayList<JTextField>();
	boolean add=false;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sixth_AddMovie window = new Sixth_AddMovie();
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
	public Sixth_AddMovie() {
		initialize();
	}
	
	private static void addMovie(String title, int year, int length, String 
			pgrating, String poster) {
	
	String insertMovie = "INSERT INTO Movie " + 
			"(title, year, length, PGRating, poster) " + "VALUES" +
			"('" + title+"', " +year+", " + length+ ", '" + pgrating+"', "
			+ "'"+poster+"')";
	try {
		Statement statement = First.connection.createStatement();
		
		statement.executeUpdate(insertMovie);
		
		System.out.println("Record is inserted into Movie table!");

		
	} 
	catch (SQLIntegrityConstraintViolationException e) {
		System.out.println("Wrong command.");
	}
	catch (SQLException e) {
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

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSaveChanges = new JButton("Save ");
		btnSaveChanges.setBounds(294, 204, 115, 37);
		frame.getContentPane().add(btnSaveChanges);
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = textField.getText().toString();
				String genres = textField_1.getText().toString();
				int year = Integer.parseInt(textField_2.getText());
				int length = Integer.parseInt(textField_3.getText());
				String pgrating = textField_4.getText().toString();
				String poster = textField_5.getText().toString();
				addMovie(title, year, length, pgrating, poster);
				String[] genre = genres.split(",");
				for(int i = 0; i < genre.length; i++) {
					addGenre(title, genre[i]);
				}
				add=true;	      }
		    });
		
		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(30, 82, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Year");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(164, 82, 54, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PG rating");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(277, 76, 82, 26);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Length");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(213, 76, 54, 26);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Poster");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(355, 82, 54, 15);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblModifyMovie = new JLabel("Add Movie");
		lblModifyMovie.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblModifyMovie.setBounds(150, 10, 198, 27);
		frame.getContentPane().add(lblModifyMovie);
		
		textField = new JTextField();
		textField.setBounds(20, 112, 66, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		if(add=true){
		a.add(textField);
		}
		
		
		textField_2 = new JTextField();
		textField_2.setBounds(169, 112, 44, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		if(add=true){
			a.add(textField_2);
			}
		
		textField_3 = new JTextField();
		textField_3.setBounds(223, 112, 44, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		if(add=true){
			a.add(textField_3);
			}
		
		textField_4 = new JTextField();
		textField_4.setBounds(287, 112, 66, 21);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		if(add=true){
			a.add(textField_4);
			}
		
		textField_5 = new JTextField();
		textField_5.setBounds(355, 112, 54, 21);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		if(add=true){
			a.add(textField_5);
			}
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(0, 0, 93, 23);
		frame.getContentPane().add(btnBack);
		
		JLabel lblNewLabel_1 = new JLabel("Genres");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(100, 83, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(96, 112, 66, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Fourth_Modify modify=new Fourth_Modify();
					modify.main(null);
					frame.dispose();
				
	}});
		
		
}
}
