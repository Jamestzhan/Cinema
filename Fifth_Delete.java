package sqlConnection;
/*
 * Delete the information in different ways
 */
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Fifth_Delete {

	private JFrame frame;
	private JTextField dMovie;
	private JTextField dPerson;
	private JTextField dActor;
	private JTextField dDirector;
	private JTextField dWriter;
	boolean add=false;
	private JTextField dRoom;
	private JTextField dShowing;
	private JTextField dDirect1;
	private JTextField dWrite1;
	private JTextField dAct1;
	private JTextField dDirect2;
	private JTextField dWrite2;
	private JTextField dAct2;
	private JTextField dAct3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fifth_Delete window = new Fifth_Delete();
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
	public Fifth_Delete() {
		initialize();
	}

	private static void deleteMovie(String title) {
		String deleteMovie = "DELETE Movie WHERE title = '" + title+"'";
		
		try {
			Statement statement = First.connection.createStatement();
			
			statement.execute(deleteMovie);
			
			System.out.println("Movie deleted successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void deletePerson(int id) {
		String deletePerson = "DELETE Person WHERE id = " + id;
		String deleteDirector = "DELETE Director where id in "
		+ "(select id from Person where id = "+id+")";
		String deleteActor = "DELETE Actor where id in "
				+ "(select id from Person where id = "+id+")";
		String deleteWriter = "DELETE Writer where id in "
				+ "(select id from Person where id = "+id+")";
		try {
			Statement statement = First.connection.createStatement();
			
			statement.execute(deleteWriter);
			statement.execute(deleteActor);
			statement.execute(deleteDirector);
			statement.execute(deletePerson);
			
			System.out.println("Person deleted successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void deleteDirector(int id) {
		String deleteDirector = "DELETE Director WHERE id = " + id;
		try {
			Statement statement = First.connection.createStatement();
			
			statement.execute(deleteDirector);
			
			System.out.println("Director deleted successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void deleteWriter(int id) {
		String deleteWriter = "DELETE Writer WHERE id = " + id;
		try {
			Statement statement = First.connection.createStatement();
			
			statement.execute(deleteWriter);
			
			System.out.println("Writer deleted successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void deleteActor(int id) {
		String deleteActor = "DELETE Actor WHERE id = " + id;
		try {
			Statement statement = First.connection.createStatement();
			
			statement.execute(deleteActor);
			
			System.out.println("Actor deleted successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void deleteDirect(int id, String movie) {
		String deleteDirect = "DELETE Direct "
				+ "WHERE directorID = " + id+" "
				+ "AND movie = '" + movie + "'";
		try {
			Statement statement = First.connection.createStatement();

			statement.execute(deleteDirect);

			System.out.println("Direct deleted successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void deleteWrite(int id, String movie) {
		String deleteWrite = "DELETE Write "
				+ "WHERE writerID = " + id+" "
				+ "AND movie = '" + movie + "'";
		try {
			Statement statement = First.connection.createStatement();

			statement.execute(deleteWrite);

			System.out.println("Write deleted successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void deleteRole(String name, int id, String movie) {
		String deleteRole = "DELETE Role "
				+ "WHERE name = '" + name + "' "
				+ "AND playerID = " + id+" "
				+ "AND movie = '" + movie + "'";
		try {
			Statement statement = First.connection.createStatement();

			statement.execute(deleteRole);

			System.out.println("Role deleted successfully.");
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
		
		dMovie = new JTextField();
		dMovie.setBounds(248, 53, 196, 21);
		frame.getContentPane().add(dMovie);
		dMovie.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(474, 513, 100, 39);
		frame.getContentPane().add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dPerson.getText().length() > 0) {
					int id = Integer.parseInt(dPerson.getText());
					deletePerson(id);
				}
				if(dMovie.getText().length() > 0) {
					String title = dMovie.getText().toString();
					deleteMovie(title);
				}
				if(dActor.getText().length() > 0) {
					int id = Integer.parseInt(dActor.getText());
					deleteActor(id);
				}
				if(dDirector.getText().length() > 0) {
					int id = Integer.parseInt(dDirector.getText());
					deleteDirector(id);
				}
				if(dWriter.getText().length() > 0) {
					int id = Integer.parseInt(dWriter.getText());
					deleteWriter(id);
				}
				if(dRoom.getText().length() > 0) {
					int roomNumber = Integer.parseInt(dRoom.getText());
					deleteRoom(roomNumber);
				}
				if(dShowing.getText().length() > 0) {
					String roomAndTime[] = dShowing.getText().split("@");
					int roomNumber = Integer.parseInt(roomAndTime[0]);
					String time = roomAndTime[1];
					deleteShowing(time, roomNumber);
				}
				if(dDirect1.getText().length() > 0) {
					int id = Integer.parseInt(dDirect1.getText());
					String movie = dDirect2.getText().toString();
					deleteDirect(id, movie);
				}
				if(dWrite1.getText().length() > 0) {
					int id = Integer.parseInt(dWrite1.getText());
					String movie = dWrite2.getText().toString();
					deleteWrite(id, movie);
				}
				if(dAct1.getText().length() > 0) {
					String name = dAct1.getText().toString();
					int id = Integer.parseInt(dAct2.getText());
					String movie = dAct3.getText().toString();
					deleteRole(name, id, movie);
				}
				add=true;	      
				}
		    });
		
		JLabel lblDeleteInformation = new JLabel("Delete Information");
		lblDeleteInformation.setBounds(213, 6, 119, 15);
		frame.getContentPane().add(lblDeleteInformation);
		
		JLabel lblDeleteMovie = new JLabel("Delete Movie");
		lblDeleteMovie.setBounds(104, 56, 100, 15);
		frame.getContentPane().add(lblDeleteMovie);
		
		JLabel lblDeletePerson = new JLabel("Delete Person");
		lblDeletePerson.setBounds(104, 99, 100, 15);
		frame.getContentPane().add(lblDeletePerson);
		
		dPerson = new JTextField();
		dPerson.setBounds(248, 96, 196, 21);
		frame.getContentPane().add(dPerson);
		dPerson.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(0, 2, 93, 23);
		frame.getContentPane().add(btnBack);
		
		JLabel lblDeleteActor = new JLabel("Delete Actor");
		lblDeleteActor.setBounds(104, 145, 93, 15);
		frame.getContentPane().add(lblDeleteActor);
		
		JLabel lblDeleteDirector = new JLabel("Delete Director");
		lblDeleteDirector.setBounds(104, 192, 119, 15);
		frame.getContentPane().add(lblDeleteDirector);
		
		JLabel lblDeleteWriter = new JLabel("Delete Writer");
		lblDeleteWriter.setBounds(104, 241, 93, 15);
		frame.getContentPane().add(lblDeleteWriter);
		
		dActor = new JTextField();
		dActor.setBounds(248, 142, 196, 21);
		frame.getContentPane().add(dActor);
		dActor.setColumns(10);
		
		dDirector = new JTextField();
		dDirector.setBounds(248, 189, 196, 21);
		frame.getContentPane().add(dDirector);
		dDirector.setColumns(10);
		
		dWriter = new JTextField();
		dWriter.setBounds(248, 238, 196, 21);
		frame.getContentPane().add(dWriter);
		dWriter.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Delete Room");
		lblNewLabel.setBounds(104, 287, 100, 15);
		frame.getContentPane().add(lblNewLabel);
		
		dRoom = new JTextField();
		dRoom.setBounds(248, 284, 196, 21);
		frame.getContentPane().add(dRoom);
		dRoom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Delete Showing");
		lblNewLabel_1.setBounds(104, 330, 100, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		dShowing = new JTextField();
		dShowing.setBounds(249, 327, 195, 21);
		frame.getContentPane().add(dShowing);
		dShowing.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Delete Direct");
		lblNewLabel_2.setBounds(104, 376, 100, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Delete Write");
		lblNewLabel_3.setBounds(104, 422, 93, 15);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Delete Act");
		lblNewLabel_4.setBounds(104, 469, 100, 15);
		frame.getContentPane().add(lblNewLabel_4);
		
		dDirect1 = new JTextField();
		dDirect1.setBounds(248, 373, 58, 21);
		frame.getContentPane().add(dDirect1);
		dDirect1.setColumns(10);
		
		dWrite1 = new JTextField();
		dWrite1.setBounds(248, 419, 58, 21);
		frame.getContentPane().add(dWrite1);
		dWrite1.setColumns(10);
		
		dAct1 = new JTextField();
		dAct1.setBounds(248, 466, 58, 21);
		frame.getContentPane().add(dAct1);
		dAct1.setColumns(10);
		
		dDirect2 = new JTextField();
		dDirect2.setBounds(316, 373, 66, 21);
		frame.getContentPane().add(dDirect2);
		dDirect2.setColumns(10);
		
		dWrite2 = new JTextField();
		dWrite2.setBounds(316, 419, 66, 21);
		frame.getContentPane().add(dWrite2);
		dWrite2.setColumns(10);
		
		dAct2 = new JTextField();
		dAct2.setBounds(316, 466, 66, 21);
		frame.getContentPane().add(dAct2);
		dAct2.setColumns(10);
		
		dAct3 = new JTextField();
		dAct3.setBounds(392, 466, 66, 21);
		frame.getContentPane().add(dAct3);
		dAct3.setColumns(10);
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					Fourth_Modify modify=new Fourth_Modify();
					modify.main(null);
					frame.dispose();
				
	}});
	}
	
	private static void deleteRoom(int number) {
		String deleteRoom = "DELETE Room WHERE roomNumber = " + number;
		try {
			Statement statement = First.connection.createStatement();
			
			statement.execute(deleteRoom);
			
			System.out.println("Room deleted successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void deleteShowing(String time, int room) {
		String deleteShowing = "DELETE Showing WHERE "
				+ "startTime = TO_DATE('" + time+ "','yyyy-mm-dd hh24:mi:ss') "
				+"AND inRoom = "+room;
		try {
			Statement statement = First.connection.createStatement();
			
			statement.execute(deleteShowing);
			
			System.out.println("Showing deleted successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
