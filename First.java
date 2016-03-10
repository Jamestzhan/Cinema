package sqlConnection;
/*
 * Finish the connection with database, and display the two login ways, member and staff
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class First {

	public static int v;
	private JFrame frame;
	public static Connection connection;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					First window = new First();
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
	public First() {
		initialize();
		init();
	}

	private static void init() 
	{
		System.out.println("-------- Oracle JDBC Connection Testing ------");	 

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return;
		}
		System.out.println("Oracle JDBC Driver Registered!");
		connection = null;

		try {
			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@fourier.cs.iit.edu:1521:orcl", "tzhan",
					"Tonghezhan");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}
		if (connection != null) {
			System.out.println("Success");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JButton btnNewButton = new JButton("Member");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Second.main(null);
				frame.dispose();
	            v=1;
			}
		});
		btnNewButton.setBounds(98, 87, 385, 104);
		frame.getContentPane().add(btnNewButton);
		
		
		JLabel lblCinemaApplication = new JLabel("Cinema Application");
		lblCinemaApplication.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblCinemaApplication.setBounds(199, 6, 197, 46);
		frame.getContentPane().add(lblCinemaApplication);
		
		final JButton btnNewButton_1 = new JButton("Staff");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBounds(98, 219, 385, 104);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Second.main(null);
				frame.dispose();
			    v=2;
			}
		});
	}
}
