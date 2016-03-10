package sqlConnection;
/*
 * You can get the movie you want in searching title, actor, writer and director
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.Button;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JMenu;

public class Fourth_Search {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnBack;
	private JButton btnGo;
	private JTable table;
	private ArrayList<String> movies;
	ListSelectionModel selectionModel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fourth_Search window = new Fourth_Search();
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
	public Fourth_Search() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		movies = new ArrayList<String>();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddInformation = new JLabel("Search ");
		lblAddInformation.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblAddInformation.setBounds(222, 8, 184, 15);
		frame.getContentPane().add(lblAddInformation);
		
		JLabel lblNewLabel = new JLabel("Search Movie");
		lblNewLabel.setBounds(10, 55, 82, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Search actor");
		lblNewLabel_1.setBounds(10, 166, 82, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Search director");
		lblNewLabel_2.setBounds(10, 90, 111, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Search writer");
		lblNewLabel_3.setBounds(10, 128, 101, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(141, 52, 317, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 86, 317, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(141, 124, 317, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(141, 162, 317, 21);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(0, 0, 93, 23);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(First.v==1){
					Third_Member member=new Third_Member();
					member.main(null);
					frame.dispose();
				}
				if(First.v==2){
					Third_Staff staff=new Third_Staff();
				    staff.main(null);
				    frame.dispose();}
			}
		});
		
		btnGo = new JButton("Go");
		btnGo.setBounds(170, 207, 258, 23);
		frame.add(btnGo);
		btnGo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		table = new JTable();
		table.setCellSelectionEnabled(true);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {

			},
			new String[] {
				"Movie", "Year"
			}
		));
		table.setBounds(141, 314, 310, 258);
		frame.getContentPane().add(table);
		
		JLabel lblNewLabel_4 = new JLabel("Title");
		lblNewLabel_4.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(141, 287, 54, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Year");
		lblNewLabel_5.setFont(new Font("ËÎÌå", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(310, 287, 54, 15);
		frame.getContentPane().add(lblNewLabel_5);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel removeCells = (DefaultTableModel) table.getModel();
				for(int i = removeCells.getRowCount() - 1; i >= 0; i--) {
					removeCells.removeRow(i);
				} 
				Set<String> movieResults = searchMovie(textField.getText(), textField_1.getText(),textField_2.getText(), textField_3.getText());
				movies.addAll(movieResults);
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				for(String movieResult:movieResults) {
					String[] movieAndYear = movieResult.split("@");
					model.addRow(new Object[] {movieAndYear[0], movieAndYear[1]});
				}

			}
		});
		
		selectionModel = table.getSelectionModel();

		selectionModel.addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent e) {
		    	if ( !e.getValueIsAdjusting() && !selectionModel.isSelectionEmpty()) { 
			    	Fifth_SearchResult movieDetail = new Fifth_SearchResult(movies.get(e.getFirstIndex()).split("@")[0]);
			    	frame.dispose();
		    	}
		    }
		});
	}
	
	public static Set<String> searchMovie(String movieName, String director, String writer, String actor)
	{
		Set<String> movieList = new HashSet<String>();
		try {
			Statement statement = First.connection.createStatement();
			String basicQuery = "SELECT title, year "
					 		  + "FROM Movie";
			ResultSet wholeResultSet = statement.executeQuery(basicQuery);
			while(wholeResultSet.next()) {
				String movieTitle = wholeResultSet.getString("title");
				String year = wholeResultSet.getString("year");
				movieList.add(movieTitle + "@" + year);
			}
			if(movieName.length() > 0) {
				String query = "SELECT title, year "
							 + "FROM Movie "
							 + "WHERE LOWER(Title) LIKE LOWER('%" + movieName + "%')";
				intersectMoviesQueryResult(movieList, query);
			}

			if(director.length() > 0) {
				String query = "SELECT Movie.title, Movie.year "
							 + "FROM Director JOIN Person ON (Person.ID = Director.ID) JOIN Direct ON (Director.ID = Direct.directorID) JOIN movie ON (Direct.movie = Movie.title) "
							 + "WHERE LOWER(Person.name) like LOWER('%" + director + "%')";
				intersectMoviesQueryResult(movieList, query);
			}

			if(writer.length() > 0) {
				String query = "SELECT Movie.title, Movie.year "
							 + "FROM Writer JOIN Person ON (Person.ID = Writer.ID) JOIN Write ON (Writer.ID = Write.writerID) JOIN Movie ON (Write.movie = Movie.title) "
							 + "WHERE LOWER(Person.name) like LOWER('%" + writer + "%')";
				intersectMoviesQueryResult(movieList, query);
			}

			if(actor.length() > 0) {
				String query = "SELECT Movie.title, Movie.year "
							 + "FROM Actor JOIN Person ON (Person.ID = Actor.ID) JOIN Role on (Actor.ID = Role.playerID) JOIN Movie ON (Role.movie = Movie.Title) "
							 + "WHERE LOWER(Person.name) like LOWER('%" + actor + "%')";
				intersectMoviesQueryResult(movieList, query);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(movieList);
		
		return movieList;
	}
	
	private static void intersectMoviesQueryResult(Set<String> finalResult ,String query) throws SQLException
	{
		Statement statement = First.connection.createStatement();
		Set<String> tempList = new HashSet<String>();
		ResultSet resultSet = statement.executeQuery(query);

		while(resultSet.next()) {
			String movieTitle = resultSet.getString("title");
			String year = resultSet.getString("year");
			tempList.add(movieTitle + "@" + year);
		}
		finalResult.retainAll(tempList);
	}
}
