package sqlConnection;
/*
 * The search function and rate function
 */
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

import java.awt.Font;
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

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import sqlConnection.Sixth_Person.PersonPageType;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Fifth_SearchResult {

	private JFrame frame;
	private JButton btnBack;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JComboBox comboBox;
	private static String movieTitle;
	private Map<String, String> movieAttributes;
	
	private ArrayList<Map<String, String>> directors;
	private ArrayList<Map<String, String>> writers;
	private ArrayList<Map<String, String>> actors;
	
	/**
	 * Launch the application.
	 */
	public static void main(String arg) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */	
	public Fifth_SearchResult(String movieTitle) {
		this.movieTitle = movieTitle;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);		
		
		this.getMovieAttributes();
		
		JList list = new JList();
		list.setBounds(78, 35, 1, 1);
		frame.getContentPane().add(list);
		
		JLabel lblMovieInformation = new JLabel("Movie Detail");
		lblMovieInformation.setVerticalAlignment(SwingConstants.TOP);
		lblMovieInformation.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblMovieInformation.setBounds(248, 0, 336, 27);
		frame.getContentPane().add(lblMovieInformation);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(0, 0, 93, 23);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Fourth_Search search=new Fourth_Search();
					search.main(null);
					frame.dispose();
				
	}});
		
		JLabel lblTitle = new JLabel("Title:	" + movieAttributes.get("title"));
		lblTitle.setBounds(10, 68, 329, 15);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblYear = new JLabel("Genres:");
		lblYear.setBounds(10, 107, 329, 15);
		frame.getContentPane().add(lblYear);
		
		JLabel lblNewLabel = new JLabel("Year:	" + movieAttributes.get("year"));
		lblNewLabel.setBounds(10, 149, 329, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Length:	" + movieAttributes.get("length"));
		lblNewLabel_1.setBounds(10, 187, 329, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblPoster = new JLabel("Poster");
		lblPoster.setBounds(416, 68, 54, 15);
		frame.getContentPane().add(lblPoster);
		
		JLabel lblPgRating = new JLabel("PG rating:	 " + movieAttributes.get("PGRating"));
		lblPgRating.setBounds(10, 228, 329, 15);
		frame.getContentPane().add(lblPgRating);
		
		JLabel lblNewLabel_2 = new JLabel("Director");
		lblNewLabel_2.setBounds(10, 272, 54, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		directors = getDirectorsFromMovie(this.movieTitle);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Director name"
			}
		));
		DefaultTableModel modelDirector = (DefaultTableModel) table.getModel();
		for(Map<String, String> director : directors) {
			modelDirector.addRow(new Object[] {director.get("name")});
		}
		final ListSelectionModel selectionDirectorModel = table.getSelectionModel();

		selectionDirectorModel.addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent e) {
		    	if ( !e.getValueIsAdjusting() && !selectionDirectorModel.isSelectionEmpty()) {
		    		Sixth_Person directorDetail = new Sixth_Person(movieTitle, directors.get(e.getFirstIndex()).get("ID"), PersonPageType.personPageType_Director);
			    	frame.dispose();
		    	}
		    }
		});

		
		table.setBounds(78, 272, 455, 45);
		frame.getContentPane().add(table);
		
		JLabel lblDirector = new JLabel("Writer");
		lblDirector.setBounds(10, 318, 54, 15);
		frame.getContentPane().add(lblDirector);
		
		JLabel lblWriter = new JLabel("Actor");
		lblWriter.setBounds(10, 369, 54, 15);
		frame.getContentPane().add(lblWriter);
		
		
		writers = getWritersFromMovie(this.movieTitle);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Writer name"
			}
		));
		DefaultTableModel modelWriter = (DefaultTableModel) table_1.getModel();
		for(Map<String, String> writer : writers) {
			modelWriter.addRow(new Object[] {writer.get("name")});
		}
		table_1.setBounds(78, 318, 455, 45);
		frame.getContentPane().add(table_1);
		
		final ListSelectionModel selectionWriterModel = table_1.getSelectionModel();

		selectionWriterModel.addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent e) {
		    	if ( !e.getValueIsAdjusting() && !selectionWriterModel.isSelectionEmpty()) {
			    	Sixth_Person movieDetail = new Sixth_Person(movieTitle, writers.get(e.getFirstIndex()).get("ID"), PersonPageType.personPageType_Writer);
			    	frame.dispose();
		    	}
		    }
		});
		
		
		actors = getActorsFromMovie(this.movieTitle);

		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Actor name", "Role"
			}
		));
		DefaultTableModel modelActor = (DefaultTableModel) table_2.getModel();
		for(Map<String, String> actor : actors) {
			modelActor.addRow(new Object[] {actor.get("name"), "Act Role: " + actor.get("role")});
		}
		table_2.setBounds(78, 369, 455, 90);
		frame.getContentPane().add(table_2);
		
		final ListSelectionModel selectionActorModel = table_2.getSelectionModel();

		selectionActorModel.addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent e) {
		    	if ( !e.getValueIsAdjusting() && !selectionActorModel.isSelectionEmpty()) {
			    	Sixth_Person movieDetail = new Sixth_Person(movieTitle, actors.get(e.getFirstIndex()).get("ID"), PersonPageType.personPageType_Actor);
			    	frame.dispose();
		    	}
		    }
		});

		BufferedImage image = null;
		try {
			// Read from a URL
			URL url = new URL(movieAttributes.get("poster"));
			image = ImageIO.read(url);
		} catch (IOException e) {
		}

		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(390, 87, 139, 156);
		lblNewLabel_3.setIcon(new ImageIcon(resize(image, lblNewLabel_3.getBounds().height, lblNewLabel_3.getBounds().width)));
		frame.getContentPane().add(lblNewLabel_3);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"5", "4", "3", "2", "1"}));
		comboBox.setBounds(219, 65, 93, 50);
		frame.getContentPane().add(comboBox);
		
		JButton btnRate = new JButton("Rate");
		btnRate.setBounds(219, 103, 93, 23);
		frame.getContentPane().add(btnRate);
		

		
		btnRate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rateForMovie(5 - comboBox.getSelectedIndex());
	}});		
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
	
	private void getMovieAttributes() {
		this.movieAttributes = new HashMap<String, String>();
		try {
			Statement statement = First.connection.createStatement();
			String query = "SELECT title, year, length, PGRating, poster "
						 + "FROM Movie "
						 + "WHERE Movie.title = '" + this.movieTitle + "'";
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				this.movieAttributes.put("title", resultSet.getString("title"));
				this.movieAttributes.put("year", resultSet.getString("year"));
				this.movieAttributes.put("length", resultSet.getString("length"));
				this.movieAttributes.put("PGRating", resultSet.getString("PGRating"));
				this.movieAttributes.put("poster", resultSet.getString("poster"));
			}
			System.out.println(this.movieAttributes);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static ArrayList<Map<String, String>> getDirectorsFromMovie(String movieTitle) {
		ArrayList<Map<String, String>> directors = new ArrayList<Map<String, String>>();
		try {
			Statement statement = First.connection.createStatement();
			String query = "SELECT Person.ID, Person.name, Director.photo "
						 + "FROM Director JOIN Person ON (Person.ID = Director.ID) JOIN Direct ON (Director.ID = Direct.directorID) JOIN movie ON (Direct.movie = Movie.title) "
						 + "WHERE Movie.title = '" + movieTitle + "'";
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				Map<String, String> director = new HashMap<String, String>();
				director.put("ID", resultSet.getString("ID"));
				director.put("name", resultSet.getString("name"));
				director.put("photo", resultSet.getString("photo"));
				directors.add(director);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(directors);
		
		return directors;
	}
	
	private static ArrayList<Map<String, String>> getActorsFromMovie(String movieTitle) {
		ArrayList<Map<String, String>> actors = new ArrayList<Map<String, String>>();
		try {
			Statement statement = First.connection.createStatement();
			String query = "SELECT Person.ID, Person.name, Role.name role, Actor.photo "
						 + "FROM Actor JOIN Person ON (Person.ID = Actor.ID) JOIN Role on (Actor.ID = Role.playerID) JOIN Movie ON (Role.movie = Movie.Title) "
						 + "WHERE Movie.title = '" + movieTitle + "'";
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				Map<String, String> actor = new HashMap<String, String>();
				actor.put("ID", resultSet.getString("ID"));
				actor.put("name", resultSet.getString("name"));
				actor.put("role", resultSet.getString("role"));
				actor.put("photo", resultSet.getString("photo"));
				actors.add(actor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(actors);
		
		return actors;
	}

	private static ArrayList<Map<String, String>> getWritersFromMovie(String movieTitle) {
		ArrayList<Map<String, String>> writers = new ArrayList<Map<String, String>>();
		try {
			Statement statement = First.connection.createStatement();
			String query = "SELECT Person.ID, Person.name "
						 + "FROM Writer JOIN Person ON (Person.ID = Writer.ID) JOIN Write ON (Writer.ID = Write.writerID) JOIN Movie ON (Write.movie = Movie.title) "
						 + "WHERE Movie.title = '" + movieTitle + "'";
			ResultSet resultSet = statement.executeQuery(query);
			while(resultSet.next()) {
				Map<String, String> writer = new HashMap<String, String>();
				writer.put("ID", resultSet.getString("ID"));
				writer.put("name", resultSet.getString("name"));
				writers.add(writer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(writers);
		
		return writers;
	}
	
	private String getGenres () {
		
		try {
			Statement statement = First.connection.createStatement();
			String query = "";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return null;
	}
	
	private static void rateForMovie(int rating) {
		try {
			Statement statement = First.connection.createStatement();
			String insert = "INSERT INTO RateMovie (fromMember, toMovie, rate) VALUES (" + Second.UserID + ", '" + movieTitle + "', " + rating + ")";
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
