package sqlConnection;
/*
 * check the avaiability of each moive, display the information of this movie and let user buy the tickets.
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Fourth_Check {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnCheck;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Fourth_Check window = new Fourth_Check();
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
	public Fourth_Check() {
		initialize();
	}
	
	private static void buyTicket(String startTime, int room, int id, double price) {
		String insertTicket = "INSERT INTO Ticket " + 
				"(startTime, room, member, price) " + "VALUES" +
				"(TO_DATE('" + startTime+ "','yyyy-mm-dd hh24:mi:ss'), "  
				+room+", " + id+ ", " + price+")";
		try {
			Statement statement = First.connection.createStatement();
			
			statement.executeUpdate(insertTicket);
			
			JOptionPane.showMessageDialog(null, "You have bought the ticket successfully", "Purchase", JOptionPane.WARNING_MESSAGE);
		} 
		catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Wrong command.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static Set<String> searchAvailableTickets(String movieName, String Date)
	{
		Set<String> ticketsList = new HashSet<String>();
		try {
			Statement statement = First.connection.createStatement();
			String basicQuery = "SELECT Showing.inRoom room, Showing.Movie movie, TO_CHAR(startTime,'yyyy-mm-dd HH24:MI:ss') time, Room.CAPACITY - (SELECT COUNT(*) FROM Ticket WHERE Ticket.startTime = Showing.startTime AND Ticket.room = Showing.inRoom) available_tickets "
							  + "FROM Showing JOIN Room ON (Room.roomNumber = Showing.inRoom)";
			ResultSet wholeResultSet = statement.executeQuery(basicQuery);
			while(wholeResultSet.next()) {
				String movieTitle = wholeResultSet.getString("movie");
				String time = wholeResultSet.getString("time");
				String room = wholeResultSet.getString("room");
				String availableTickets = wholeResultSet.getString("available_tickets");
				ticketsList.add(movieTitle + "@" + time + "@" + room + "@" + availableTickets);
			}
			
			if(movieName.length() > 0) {
				String query = "SELECT Showing.inRoom room, Showing.Movie movie, TO_CHAR(startTime,'yyyy-mm-dd HH24:MI:ss') time, Room.CAPACITY - (SELECT COUNT(*) FROM Ticket WHERE Ticket.startTime = Showing.startTime AND Ticket.room = Showing.inRoom) available_tickets "
						  	 + "FROM Showing JOIN Room ON (Room.roomNumber = Showing.inRoom) "
						  	 + "WHERE LOWER(Showing.movie) like LOWER('%" + movieName + "%')";
				intersectTicketsQueryResult(ticketsList, query);
			}
			
			if(Date.length() > 0) {
				String query = "SELECT Showing.inRoom room, Showing.Movie movie, TO_CHAR(startTime,'yyyy-mm-dd HH24:MI:ss') time, Room.CAPACITY - (SELECT COUNT(*) FROM Ticket WHERE Ticket.startTime = Showing.startTime AND Ticket.room = Showing.inRoom) available_tickets "
						  	 + "FROM Showing JOIN Room ON (Room.roomNumber = Showing.inRoom) "
						  	 + "WHERE TO_CHAR(startTime,'mm-dd') = '" + Date + "'";
				intersectTicketsQueryResult(ticketsList, query);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(ticketsList);

		return ticketsList;
	}
	
	private static void intersectTicketsQueryResult(Set<String> finalResult ,String query) throws SQLException
	{
		Statement statement = First.connection.createStatement();
		Set<String> tempList = new HashSet<String>();
		ResultSet resultSet = statement.executeQuery(query);
		while(resultSet.next()) {
			String movieTitle = resultSet.getString("movie");
			String time = resultSet.getString("time");
			String room = resultSet.getString("room");
			String availableTickets = resultSet.getString("available_tickets");
			tempList.add(movieTitle + "@" + time + "@" + room + "@" + availableTickets);
		}
		finalResult.retainAll(tempList);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 566, 505);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCheckAv = new JLabel("Check Availability");
		lblCheckAv.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblCheckAv.setBounds(135, 10, 174, 32);
		frame.getContentPane().add(lblCheckAv);
		
		JLabel lblMoive = new JLabel("Moive");
		lblMoive.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblMoive.setBounds(92, 82, 54, 15);
		frame.getContentPane().add(lblMoive);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTime.setBounds(92, 133, 54, 15);
		frame.getContentPane().add(lblTime);
		
		textField = new JTextField();
		textField.setBounds(182, 80, 146, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(182, 131, 148, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnNewButton = new JButton("Back");
		btnNewButton.setBounds(0, 0, 93, 23);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
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
		
		
		btnNewButton_1 = new JButton("Buy");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.setBounds(433, 211, 93, 23);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				String time = (String) table.getModel().getValueAt(row, 1);
				System.out.println(time);
				int room = Integer.parseInt((String) table.getModel().getValueAt(row, 2));
				int price = (int) table.getModel().getValueAt(row, 3);
				buyTicket(time, room, 2, price);
			}
		});
		
		btnCheck = new JButton("Check");
		btnCheck.setBounds(182, 177, 93, 23);
		//frame.getContentPane().add(btnCheck);
		frame.getContentPane().add(btnCheck);
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel modelActor = (DefaultTableModel) table.getModel();
				int rowCount = modelActor.getRowCount();
				//Remove rows one by one from the end of the table
				for (int i = rowCount - 1; i >= 0; i--) {
				    modelActor.removeRow(i);
				}
				String movie = textField.getText().toString();
				String date = textField_1.getText().toString();
				Set<String> list = searchAvailableTickets(movie, date);
				
				Iterator<String> i = list.iterator();
				String row;
				String[] elements;
				
				while(i.hasNext()) {
					row = i.next();
					System.out.println(row);
					elements = row.split("@");
					modelActor.addRow(new Object[] {elements[0], elements[1], elements[2], 12});
				}

				btnNewButton_1.setEnabled(true);
			}
		});
		
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(32, 285, 494, 161);
		frame.getContentPane().add(table);
		
		lblNewLabel = new JLabel("StartTime");
		lblNewLabel.setBounds(166, 262, 71, 15);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Movie");
		lblNewLabel_1.setBounds(50, 262, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Room");
		lblNewLabel_2.setBounds(304, 262, 54, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Price");
		lblNewLabel_3.setBounds(439, 262, 54, 15);
		frame.getContentPane().add(lblNewLabel_3);
	}
	
	
	
	

}
