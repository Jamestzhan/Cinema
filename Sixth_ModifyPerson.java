package sqlConnection;
/*
 * Modify the information of person, include actor, director
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Sixth_ModifyPerson {

	private JFrame frame;
	private JTextField pID;
	private JTextField pValue;
	private JTable table;
	private JButton btnBack;
	ArrayList<JTextField> a=new ArrayList<JTextField>();
	boolean add=false;
	private JComboBox comboBox;
	private JLabel lblPerson;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblDirector;
	private JLabel lblId_1;
	private JLabel lblPhoto;
	private JTextField aID;
	private JTextField dID;
	private JTextField aPhoto;
	private JTextField dPhoto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sixth_ModifyPerson window = new Sixth_ModifyPerson();
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
	public Sixth_ModifyPerson() {
		initialize();
	}

	private static void modifyPerson(int id, String attr, String value) {
		String modifyPerson;
		if(attr.equals("birthdate")) {
			modifyPerson = "UPDATE Person" + 
					" SET " + attr+" = TO_DATE('" + value+"','yyyy-mm-dd')" +
					" WHERE id = "+id;
		}
		else {
			modifyPerson = "UPDATE Person" + 
					" SET " + attr+" = '" + value +
					"' WHERE id = "+id;
		}
		try {
			Statement statement = First.connection.createStatement();

			statement.execute(modifyPerson);

			System.out.println("Person modified successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void modifyActor(int id, String photo) {
		String modifyActor = "UPDATE Actor" + 
				" SET photo" + " = '" + photo +
				"' WHERE id = "+id;
		try {
			Statement statement = First.connection.createStatement();

			statement.execute(modifyActor);

			System.out.println("Actor modified successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void modifyDirector(int id, String photo) {
		String modifyDirector = "UPDATE Director" + 
				" SET photo" + " = '" + photo +
				"' WHERE id = "+id;
		try {
			Statement statement = First.connection.createStatement();

			statement.execute(modifyDirector);

			System.out.println("Director modified successfully.");
		} catch (SQLException e) {
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

		JLabel lblModifyPerson = new JLabel("Modify Person");
		lblModifyPerson.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblModifyPerson.setBounds(206, 10, 166, 23);
		frame.getContentPane().add(lblModifyPerson);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(106, 78, 54, 15);
		frame.getContentPane().add(lblId);

		JLabel lblBirthday = new JLabel("Attribute");
		lblBirthday.setBounds(241, 78, 80, 15);
		frame.getContentPane().add(lblBirthday);

		JLabel lblNewLabel = new JLabel("Value");
		lblNewLabel.setBounds(407, 78, 54, 15);
		frame.getContentPane().add(lblNewLabel);

		JButton btnSaveChanges = new JButton("Save changes");
		btnSaveChanges.setBounds(446, 360, 150, 56);
		frame.getContentPane().add(btnSaveChanges);
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pID.getText().length() > 0) {
					int id = Integer.parseInt(pID.getText());
					String attri = comboBox.getSelectedItem().toString();
					String value = pValue.getText().toString();
					modifyPerson(id, attri, value);
				}
				if(aID.getText().length() > 0) {
					int id = Integer.parseInt(aID.getText());
					String photo = aPhoto.getText().toString();
					modifyActor(id, photo);
				}
				if(dID.getText().length() > 0) {
					int id = Integer.parseInt(dID.getText());
					String photo = dPhoto.getText().toString();
					modifyDirector(id, photo);
				}
				add=true;	      }
		});

		pID = new JTextField();
		pID.setBounds(106, 103, 66, 21);
		frame.getContentPane().add(pID);
		pID.setColumns(10);
		if(add=true){
			a.add(pID);
		}

		pValue = new JTextField();
		pValue.setBounds(407, 103, 66, 21);
		frame.getContentPane().add(pValue);
		pValue.setColumns(10);
		if(add=true){
			a.add(pValue);
		}


		table = new JTable();
		table.setBounds(105, 170, 1, 1);
		frame.getContentPane().add(table);

		btnBack = new JButton("Back");
		btnBack.setBounds(0, 2, 93, 23);
		frame.getContentPane().add(btnBack);

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Fifth_Modify modify=new Fifth_Modify();
				modify.main(null);
				frame.dispose();

			}});
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Name", "Birthdate", "Gender"}));
		comboBox.setBounds(240, 103, 100, 20);
		frame.getContentPane().add(comboBox);

		lblPerson = new JLabel("Person");
		lblPerson.setBounds(10, 106, 54, 15);
		frame.getContentPane().add(lblPerson);

		lblNewLabel_1 = new JLabel("Actor");
		lblNewLabel_1.setBounds(10, 225, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(10, 250, 24, -5);
		frame.getContentPane().add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(10, 277, 24, 1);
		frame.getContentPane().add(lblNewLabel_3);

		lblDirector = new JLabel("Director");
		lblDirector.setBounds(10, 288, 54, 15);
		frame.getContentPane().add(lblDirector);

		lblId_1 = new JLabel("ID");
		lblId_1.setBounds(106, 186, 54, 15);
		frame.getContentPane().add(lblId_1);

		lblPhoto = new JLabel("Photo");
		lblPhoto.setBounds(241, 186, 54, 15);
		frame.getContentPane().add(lblPhoto);

		aID = new JTextField();
		aID.setBounds(106, 222, 66, 21);
		frame.getContentPane().add(aID);
		aID.setColumns(10);

		dID = new JTextField();
		dID.setBounds(106, 285, 66, 21);
		frame.getContentPane().add(dID);
		dID.setColumns(10);

		aPhoto = new JTextField();
		aPhoto.setBounds(241, 222, 66, 21);
		frame.getContentPane().add(aPhoto);
		aPhoto.setColumns(10);

		dPhoto = new JTextField();
		dPhoto.setBounds(241, 285, 66, 21);
		frame.getContentPane().add(dPhoto);
		dPhoto.setColumns(10);


	}
}
