package sqlConnection;
/*
 * Add function, add person, include actor, writer and director 
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

import javax.swing.JButton;
import javax.swing.JTextField;

public class Sixth_AddPerson {

	private JFrame frame;
	private JTextField pID;
	private JTextField pName;
	private JTextField pBirthdate;
	private JTextField pGender;
	private JTextField aID;
	private JTextField aPhoto;
	private JTextField dID;
	private JTextField dphoto;
	private JTextField wID;
	private JButton btnBack;
	ArrayList<JTextField> a=new ArrayList<JTextField>();
	boolean add=false;
	private JLabel lblPerson;
	private JLabel lblId_1;
	private JLabel lblId_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sixth_AddPerson window = new Sixth_AddPerson();
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
	public Sixth_AddPerson() {
		initialize();
	}
	
	private static void addPerson(int id, String name, String birth, String gender) {
		String insertPerson = "INSERT INTO Person " + 
				"(id, name, birthdate, gender) " + "VALUES" +
				"(" + id+", '" +name+"', TO_DATE('" + birth+
				"','yyyy-mm-dd'), '" + gender+"')";
		try {
			Statement statement = First.connection.createStatement();
			
			statement.executeUpdate(insertPerson);
			
			System.out.println("Record is inserted into Person table!");

			
		} 
		catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Wrong command.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void addDirector(int id, String photo) {
		String insertDirector = "INSERT INTO Director " + 
				"(id, photo) " + "VALUES" +
				"(" + id +", "+ "'"+photo+"')";
		try {
			Statement statement = First.connection.createStatement();
			
			statement.executeUpdate(insertDirector);
			
			System.out.println("Record is inserted into Director table!");

			
		} 
		catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Wrong command.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void addWriter(int id) {
		String insertWriter = "INSERT INTO Writer " + 
				"(id) " + "VALUES" +
				"(" + id +")";
		try {
			Statement statement = First.connection.createStatement();
			
			statement.executeUpdate(insertWriter);
			
			System.out.println("Record is inserted into Writer table!");

			
		} 
		catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("Wrong command.");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void addActor(int id, String photo) {
		String insertActor = "INSERT INTO Actor " + 
				"(id, photo) " + "VALUES" +
				"(" + id +", "+ "'"+photo+"')";
		try {
			Statement statement = First.connection.createStatement();
			
			statement.executeUpdate(insertActor);
			
			System.out.println("Record is inserted into Actor table!");

			
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
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddPerson = new JLabel("Add Person");
		lblAddPerson.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblAddPerson.setBounds(156, 10, 143, 27);
		frame.getContentPane().add(lblAddPerson);
		
		JLabel lblNewLabel = new JLabel("Actor");
		lblNewLabel.setBounds(10, 178, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Director");
		lblNewLabel_1.setBounds(10, 232, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Writer");
		lblNewLabel_2.setBounds(10, 294, 54, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(78, 64, 54, 15);
		frame.getContentPane().add(lblId);
		
		JButton btnSaveChanges = new JButton("Save changes");
		btnSaveChanges.setBounds(434, 368, 114, 27);
		frame.getContentPane().add(btnSaveChanges);
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pID.getText().length() > 0) {
					int id = Integer.parseInt(pID.getText());
					String name = pName.getText().toString();
					String birth = pBirthdate.getText().toString();
					String gender = pGender.getText().toString();
					addPerson(id, name, birth, gender);
				}
				if(aID.getText().length() > 0) {
					int id = Integer.parseInt(aID.getText());
					String photo = aPhoto.getText().toString();
					addActor(id, photo);
				}
				if(dID.getText().length() > 0) {
					int id = Integer.parseInt(dID.getText());
					String photo = dphoto.getText().toString();
					addDirector(id, photo);
				}
				if(wID.getText().length() > 0) {
					int id = Integer.parseInt(wID.getText());
					addWriter(id);
				}
				add=true;	      }
		    });

		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(154, 64, 54, 15);
		frame.getContentPane().add(lblName);
		
		JLabel lblBirthdate = new JLabel("Birthdate");
		lblBirthdate.setBounds(249, 64, 54, 15);
		frame.getContentPane().add(lblBirthdate);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(327, 64, 54, 15);
		frame.getContentPane().add(lblGender);
		
		JLabel lblPhoto = new JLabel("Photo");
		lblPhoto.setBounds(154, 146, 54, 15);
		frame.getContentPane().add(lblPhoto);
		
		pID = new JTextField();
		pID.setBounds(78, 89, 54, 21);
		frame.getContentPane().add(pID);
		pID.setColumns(10);
		if(add=true){
			a.add(pID);
			}
		
		pName = new JTextField();
		pName.setBounds(154, 89, 66, 21);
		frame.getContentPane().add(pName);
		pName.setColumns(10);
		if(add=true){
			a.add(pName);
			}
		pBirthdate = new JTextField();
		pBirthdate.setBounds(249, 89, 66, 21);
		frame.getContentPane().add(pBirthdate);
		pBirthdate.setColumns(10);
		if(add=true){
			a.add(pBirthdate);
			}
		
		pGender = new JTextField();
		pGender.setBounds(327, 89, 66, 21);
		frame.getContentPane().add(pGender);
		pGender.setColumns(10);
		if(add=true){
			a.add(pGender);
			}
		
		aID = new JTextField();
		aID.setBounds(74, 175, 52, 21);
		frame.getContentPane().add(aID);
		aID.setColumns(10);
		if(add=true){
			a.add(aID);
			}
		
		aPhoto = new JTextField();
		aPhoto.setBounds(156, 175, 66, 21);
		frame.getContentPane().add(aPhoto);
		aPhoto.setColumns(10);
		if(add=true){
			a.add(aPhoto);
			}
		
		dID = new JTextField();
		dID.setBounds(74, 229, 52, 21);
		frame.getContentPane().add(dID);
		dID.setColumns(10);
		if(add=true){
			a.add(dID);
			}
		
		dphoto = new JTextField();
		dphoto.setBounds(156, 229, 66, 21);
		frame.getContentPane().add(dphoto);
		dphoto.setColumns(10);
		if(add=true){
			a.add(dphoto);
			}
		
		wID = new JTextField();
		wID.setBounds(78, 294, 54, 21);
		frame.getContentPane().add(wID);
		wID.setColumns(10);
		if(add=true){
			a.add(wID);
			}
				
		btnBack = new JButton("Back");
		btnBack.setBounds(0, 0, 93, 23);
		frame.getContentPane().add(btnBack);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Fourth_Modify modify=new Fourth_Modify();
					modify.main(null);
					frame.dispose();
				
	}});
		
		lblPerson = new JLabel("Person");
		lblPerson.setBounds(10, 92, 54, 15);
		frame.getContentPane().add(lblPerson);
		
		lblId_1 = new JLabel("ID");
		lblId_1.setBounds(78, 269, 54, 15);
		frame.getContentPane().add(lblId_1);
		
		lblId_2 = new JLabel("ID");
		lblId_2.setBounds(78, 146, 54, 15);
		frame.getContentPane().add(lblId_2);

	}
}
