package sqlConnection;

import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Sixth_Person {
	
	public static enum PersonPageType {
		personPageType_Director,
		personPageType_Writer,
		personPageType_Actor,
	};

	private JFrame frame;
	private JTable table;
	private JComboBox comboBox;
	private static String fromMoviePage;
	private static String personID;
	private static PersonPageType type;
	private ArrayList<Map<String, String>> movies;
	private Map<String, String> personAttributes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sixth_Person window = new Sixth_Person(fromMoviePage, personID, type);
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
	public Sixth_Person(String fromMoviePage, String personID, PersonPageType type) {
		this.fromMoviePage = fromMoviePage;
		this.personID = personID;
		this.type = type;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.movies = new ArrayList<Map<String, String>>();
		this.getPersonAttributes();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPerson = new JLabel("Person");
		lblPerson.setBounds(170, 10, 54, 15);
		frame.getContentPane().add(lblPerson);
		
		JLabel lblName = new JLabel("Name:	" + personAttributes.get("name"));
		lblName.setBounds(10, 85, 200, 15);
		frame.getContentPane().add(lblName);
		
		JLabel lblBirthdate = new JLabel("Birthdate:	" + personAttributes.get("birthdate"));
		lblBirthdate.setBounds(10, 132, 200, 15);
		frame.getContentPane().add(lblBirthdate);
		
		JLabel lblNewLabel = new JLabel("Gender:	" + personAttributes.get("gender"));
		lblNewLabel.setBounds(10, 184, 200, 15);
		frame.getContentPane().add(lblNewLabel);
		
		
		if(type == PersonPageType.personPageType_Director || type == PersonPageType.personPageType_Actor) {
			JLabel lblNewLabel_1 = new JLabel("");
			BufferedImage image = null;
			try {
				// Read from a URL
				URL url = new URL(personAttributes.get("photo"));
				image = ImageIO.read(url);
			} catch (IOException e) {
			}
			lblNewLabel_1.setBounds(259, 77, 154, 122);
			lblNewLabel_1.setIcon(new ImageIcon(resize(image, lblNewLabel_1.getBounds().height, lblNewLabel_1.getBounds().width)));
			frame.getContentPane().add(lblNewLabel_1);
			
			JLabel lblPhoto = new JLabel("Photo");
			lblPhoto.setBounds(304, 43, 54, 15);
			frame.getContentPane().add(lblPhoto);
		}

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(0, 6, 93, 23);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	Fifth_SearchResult movieDetail = new Fifth_SearchResult(fromMoviePage);
				frame.dispose();
				
	}});
		
		this.frame.setVisible(true);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {
				"Movie Title", "Movie Year"
			}
		));
		DefaultTableModel modelMovie = (DefaultTableModel) table.getModel();
		for(Map<String, String> movie : movies) {
			modelMovie.addRow(new Object[] {movie.get("title"), movie.get("year")});
		}
		
		table.setBounds(10, 225, 403, 27);
		frame.getContentPane().add(table);
		
		
		if(this.type == PersonPageType.personPageType_Actor) {
		    comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"5", "4", "3", "2", "1"}));
			comboBox.setBounds(466, 231, 93, 23);
			frame.getContentPane().add(comboBox);
			
			JButton btnRate = new JButton("Rate");
			btnRate.setBounds(466, 270, 93, 23);
			frame.getContentPane().add(btnRate);
			btnRate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
			    	rateForActor(5 - comboBox.getSelectedIndex());
		}});
		}

		this.frame.setVisible(true);

	}
	
	public static BufferedImage resize(BufferedImage image, int width, int height) {
	    BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
	    Graphics2D g2d = (Graphics2D) bi.createGraphics();
	    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
	    g2d.drawImage(image, 0, 0, width, height, null);
	    g2d.dispose();
	    return bi;
	}
	
	private static void getMoviesBasedOnQuery(ArrayList<Map<String, String>> movies, String query) 
	{
		try {
			Statement statement = First.connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				Map<String, String> movie = new HashMap<String, String>();
				movie.put("title", resultSet.getString("title"));
				movie.put("year", resultSet.getString("year"));
				movie.put("poster", resultSet.getString("poster"));
				movies.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void getPersonAttributes() {
		this.personAttributes = new HashMap<String, String>();
		try {
			Statement statement = First.connection.createStatement();
			String query = "";
			switch(type) {
				case personPageType_Director:
					query = "SELECT name, birthdate, gender, Director.photo "
						  + "FROM Person JOIN Director ON Director.ID = Person.ID "
						  + "WHERE Person.ID =" + personID;
					movies = getMoviesFromDirector(Integer.parseInt(personID));
					break;
					
				case personPageType_Writer:
					query = "SELECT name, birthdate, gender "
						  + "FROM Person JOIN Writer ON Writer.ID = Person.ID "
						  + "WHERE Person.ID =" + personID;
					movies = getMoviesFromWriter(Integer.parseInt(personID));
					break;
					
				case personPageType_Actor:
					query = "SELECT name, birthdate, gender, Actor.photo "
							+ "FROM Person JOIN Actor ON Actor.ID = Person.ID "
							+ "WHERE Person.ID =" + personID;
					movies = getMoviesFromActor(Integer.parseInt(personID));
					break;
					
				default:
					break;
			}
			
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				this.personAttributes.put("name", resultSet.getString("name"));
				this.personAttributes.put("birthdate", resultSet.getString("birthdate"));
				this.personAttributes.put("gender", resultSet.getString("gender"));
				if(type == PersonPageType.personPageType_Director || type == PersonPageType.personPageType_Actor) {
					this.personAttributes.put("photo", resultSet.getString("photo"));
				}
			}
			System.out.println(this.personAttributes);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static ArrayList<Map<String, String>> getMoviesFromDirector(int ID) 
	{
		ArrayList<Map<String, String>> movies = new ArrayList<Map<String, String>>();

		String query = "SELECT Movie.title, Movie.year, Movie.poster "
				+ "FROM Director JOIN Direct ON (Director.ID = Direct.directorID) JOIN movie ON (Direct.movie = Movie.title) "
				+ "WHERE Director.ID = " + ID + "";

		getMoviesBasedOnQuery(movies, query);
		
		System.out.println(movies);

		return movies;
	}

	private static ArrayList<Map<String, String>> getMoviesFromWriter(int ID) 
	{
		ArrayList<Map<String, String>> movies = new ArrayList<Map<String, String>>();

		String query = "SELECT Movie.title, Movie.year, Movie.poster "
				+ "FROM Writer JOIN Write ON (Writer.ID = Write.writerID) JOIN Movie ON (Write.movie = Movie.title) "
				+ "WHERE Writer.ID = " + ID + "";

		getMoviesBasedOnQuery(movies, query);

		System.out.println(movies);

		return movies;
	}
	
	private static ArrayList<Map<String, String>> getMoviesFromActor(int ID) 
	{
		ArrayList<Map<String, String>> movies = new ArrayList<Map<String, String>>();

		String query = "SELECT Movie.title, Movie.year, Movie.poster "
				+ "FROM Actor JOIN Role on (Actor.ID = Role.playerID) JOIN Movie ON (Role.movie = Movie.Title) "
				+ "WHERE Actor.ID = " + ID + "";

		getMoviesBasedOnQuery(movies, query);

		System.out.println(movies);

		return movies;
	}
	
	private static void rateForActor(int rating) {
		try {
			Statement statement = First.connection.createStatement();
			String insert = "INSERT INTO RateActor (fromMember, toActor, rate) VALUES (" + Second.UserID + ", '" + personID + "', " + rating + ")";
			statement.executeQuery(insert);
			System.out.println("Rate Success!");
		}
		catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Wrong Operation");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
