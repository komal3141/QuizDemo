import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class QuiZ implements ActionListener{
	private static JFrame frame;
	private static JTextField textField;
	private static JTextField UserNameTxt;
	private static JButton LoginButton;
	private static JLabel UserNameLbl;
	private static JLabel PswdLabel;
	private JPasswordField passwordField;
	boolean entryExists;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuiZ window = new QuiZ();
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
	public QuiZ() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 255, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(0, 241, 434, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(2);
		
		UserNameTxt = new JTextField();
		UserNameTxt.setBounds(142, 30, 221, 20);
		frame.getContentPane().add(UserNameTxt);
		UserNameTxt.setColumns(10);
		
		LoginButton = new JButton("Login");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String UserName = UserNameTxt.getText();
			    String Password =passwordField.getText();
				System.out.println(UserName + ","+ Password);
				
				//Check if userExits
				UserInfo newUser= new UserInfo();
				
				
				try {
					entryExists=newUser.StudentExists(UserName);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
					
				
				if(!entryExists) {
				
					//Get User password
					//if (UserName.equals("komal")&& Password.equals("1234"))
					UserInfo newStudent=new UserInfo();
					
					newStudent.UserName=UserName;
					newStudent.Passwrd="1234";
					newStudent.FirstName=UserName;
					newStudent.LastName=UserName;
					newStudent.Score=0;
					
					try {
						newStudent.UpdateStudentInfo(newStudent);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						
				}
				if (true) {
					//success.setText("Login successful!");
					System.out.println("Login Successfull");
					frame.setVisible(false);


					quizStart info =new quizStart();
					quizStart.main(UserName);
					
					//QuizQuestions quizQ = new QuizQuestions();
					try {
						//QuizQuestions Q = quizQ.GetQuestion(2);
						
						
						UserInfo user= new UserInfo();
						boolean flag=user.StudentExists("komal1234");
						System.out.println("Flag=>>"+flag);

						int score= user.GetStudentScore("Avi1234");
						int count=user.GetNumberOfStudents();
						
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				 }
				
			}
		});
		LoginButton.setVerticalAlignment(SwingConstants.TOP);
		LoginButton.setFont(new Font("Yu Gothic Light", Font.BOLD, 15));
		LoginButton.setBounds(204, 126, 89, 23);
		frame.getContentPane().add(LoginButton);
		
		UserNameLbl = new JLabel("User Name");
		UserNameLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		UserNameLbl.setBounds(27, 28, 98, 20);
		frame.getContentPane().add(UserNameLbl);
		
		PswdLabel = new JLabel("Password");
		PswdLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		PswdLabel.setBounds(27, 80, 82, 17);
		frame.getContentPane().add(PswdLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(142, 80, 221, 20);
		frame.getContentPane().add(passwordField);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

