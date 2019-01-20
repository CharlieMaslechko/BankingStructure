import java.awt.*; 
import javax.swing.*;

public class GUI extends JFrame{
	
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
		

	}
}
