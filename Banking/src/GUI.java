import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class GUI extends JFrame{
	
	//Private to GUI class
	private static String usernameAdmin;
	private static String passwordAdmin;
			
	//Login credentials mutator
	public static void setCredentials(String user, String pass) {
		usernameAdmin = user;
		passwordAdmin = pass;
	}
			
	//Username Accessor
	public static String getUsername() {
		return usernameAdmin;
	}
	//Password Accessor
	public static String getPassword() {
		return passwordAdmin;
	}	
	
	public static boolean passwordCheck(String password) {
		if (password.equals(passwordAdmin)) {
			return true;
		}else {
			return false;
		}			
	}
	
	public static boolean usernameCheck(String username) {
		if (username.equals(usernameAdmin)) {
			return true;
		}else {
			return false;
		}			
	}
	
	//Components
	JFrame loginFrame;
	JPanel loginPanel;
	JLabel title;
	JLabel usernameText;
	JLabel passwordText;
	JButton loginButton;
	JTextField adminUserField;
	JPasswordField adminPassField;
	
	//Layouts
	SpringLayout mainLayout;
	
	//Fonts
	Font titleFont;
	Font defaultFont;
	
	//GUI Constructor - ran when new GUI object is created
	public GUI() {

		//Create default font
		titleFont = new Font("Shree Devanagari 714", Font.PLAIN, 22);
		defaultFont = new Font("Shree Devanagari 714", Font.PLAIN, 12);

		//Object assignment
		loginFrame = new JFrame();
		loginPanel = new JPanel();
		title = new JLabel();
		usernameText = new JLabel();
		loginButton = new JButton();
		passwordText = new JLabel();
		adminUserField = new JTextField();
		mainLayout = new SpringLayout();
		adminPassField = new JPasswordField();
		
	

		//Initialize Frame size
		loginFrame.setSize(400, 200);
		
		//set JPanel (container) layout type
		loginPanel.setLayout(mainLayout);
		
		//Modify login title
		title.setText("Administrator Login");
		title.setFont(titleFont);
		
		//Modify login label
		usernameText.setText("Username: ");
		usernameText.setFont(defaultFont);
		
		//Modify login text field
		adminUserField.setFont(defaultFont);;
		adminUserField.setColumns(10);
		
		//Modify login button
		loginButton.setText("Login");
		loginButton.setSize(20, 10);
		
		//Modify password label
		passwordText.setText("Password: ");
		passwordText.setFont(defaultFont);
		
		//Modify password text field
		adminPassField.setColumns(10);
		
		
		//CONSTRAINTS
		
		//Constraints for "Administrator Login" Label
		mainLayout.putConstraint(SpringLayout.WEST, title, 5, SpringLayout.WEST, loginPanel);
		mainLayout.putConstraint(SpringLayout.NORTH, title, 5, SpringLayout.NORTH, loginPanel);
		
		//Constraints for "Username" Label
		mainLayout.putConstraint(SpringLayout.NORTH, usernameText, 15, SpringLayout.SOUTH, title);
		mainLayout.putConstraint(SpringLayout.WEST, usernameText, 5, SpringLayout.WEST, loginPanel);
		
		//Constraints for adminUserField
		mainLayout.putConstraint(SpringLayout.NORTH, adminUserField, 10, SpringLayout.SOUTH, title);
		mainLayout.putConstraint(SpringLayout.WEST, adminUserField, 5, SpringLayout.EAST, usernameText);
		
		//Constraints for "Password" Label
		mainLayout.putConstraint(SpringLayout.NORTH, passwordText, 20, SpringLayout.SOUTH, usernameText);
		mainLayout.putConstraint(SpringLayout.WEST, passwordText, 5, SpringLayout.WEST, loginPanel);
		
		//Constraints for login button
		mainLayout.putConstraint(SpringLayout.NORTH, loginButton, 10, SpringLayout.SOUTH, passwordText);
		mainLayout.putConstraint(SpringLayout.WEST, loginButton, 1, SpringLayout.WEST, loginPanel);
		
		//Constraints for adminPassField
		mainLayout.putConstraint(SpringLayout.NORTH, adminPassField, 15, SpringLayout.SOUTH, usernameText);
		mainLayout.putConstraint(SpringLayout.WEST, adminPassField, 0, SpringLayout.WEST, adminUserField);
		
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Console initializer 
		System.out.println("new GUI Created");
		
		//Add components to panel
		loginPanel.add(title);
		loginPanel.add(usernameText);
		loginPanel.add(adminUserField);
		loginPanel.add(loginButton);
		loginPanel.add(passwordText);
		loginPanel.add(adminPassField);
		
		
		//Add panel to frame
		loginFrame.add(loginPanel);
		
		//Visibilities
		loginFrame.setVisible(true);
		loginFrame.setResizable(false);
		
		//Event Listeners
		
		//Object of eventHandler class 
		eventHandler eventHandlerObj = new eventHandler();
		loginButton.addActionListener(eventHandlerObj);

	}//End Constructor
	
	

	
	//Private class within GUI
	public class eventHandler implements ActionListener{
		//Action listener required implementation of event triggering method
		
		
		//This method handles event under the circumstances an event of occurring
		public void actionPerformed(ActionEvent event) {	
		

			
		
			
			//Create empty strings to hold empty login data
			String usernameStorage = "";
			String passwordStorage = "";
			
			//Source refers to the location of event
			
			//Event for login button press
			if (event.getSource() == loginButton) {
				System.out.println("Login sequence commenced");
				
				//Store username and password in variables
				usernameStorage = adminUserField.getText();
				passwordStorage = new String(adminPassField.getPassword());	
				
				//Check login details
				if(usernameStorage.contentEquals("") && passwordStorage.equals("")){
					JOptionPane.showMessageDialog(loginFrame, "Please enter a username and password", "Error", JOptionPane.ERROR_MESSAGE);
				}else if(usernameStorage.contentEquals("")) {
					JOptionPane.showMessageDialog(loginFrame, "Please enter a username", "Error", JOptionPane.ERROR_MESSAGE);
				}else if(passwordStorage.contentEquals("")) {
					JOptionPane.showMessageDialog(loginFrame, "Please enter a password", "Error", JOptionPane.ERROR_MESSAGE);
				}else if(GUI.passwordCheck(passwordStorage) && GUI.usernameCheck(usernameStorage)) {
					System.out.println("Login successful");
				}else {
					//Catch incorrect username or password
					JOptionPane.showMessageDialog(loginFrame, "Incorrect username or password", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		}//End actionPerformed method
	}//End eventHandler class
	
	
	
}
