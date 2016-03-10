package sqlConnection;
/*
 * Login
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Second {
	
	private static JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	public static int UserID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Second window = new Second();
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
	public Second() {
		initialize();
		//this.setVisible(true);
	}

	private static void memberLogin(int id, String pswd) {
		ResultSet result = null;
		try {
			Statement statement = First.connection.createStatement();
			result = statement.executeQuery("SELECT * FROM Member "
					+ "WHERE ID = "+id+" AND PASSWORD = '"+pswd + "'");
			if(result.next()) {
				System.out.println("Logged in!");
				Second.UserID = id;
				Third_Member.main(null);
				frame.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Wrong ID or wrong password", "Alert", JOptionPane.WARNING_MESSAGE);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void staffLogin(int id, String pswd) {
		ResultSet result = null;
		try {
			Statement statement = First.connection.createStatement();
			result = statement.executeQuery("SELECT * FROM Staff "
					+ "WHERE ID = "+id+" AND PASSWORD = '"+pswd + "'");
			if(result.next()) {
				System.out.println("Logged in!");
				Second.UserID = id;
				Third_Staff.main(null);
                frame.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Wrong ID or wrong password", "Alert", JOptionPane.WARNING_MESSAGE);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblLogin.setBounds(263, 8, 118, 56);
		frame.getContentPane().add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(93, 78, 25, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(72, 136, 73, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(155, 76, 299, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(155, 136, 299, 21);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(243, 189, 93, 23);
		frame.getContentPane().add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(First.v==1){
					int userID = textField.getText().length() > 0 ? Integer.parseInt(textField.getText()) : 0;
					memberLogin(userID, String.valueOf(passwordField.getPassword()));
                    }
				if(First.v==2){
					int userID = textField.getText().length() > 0 ? Integer.parseInt(textField.getText()) : 0;
					staffLogin(userID, String.valueOf(passwordField.getPassword()));
			}}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(10, 10, 73, 23);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				First.main(null);
				frame.dispose();
			}
		});
		
	}
	
	
}
