import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JTextField;

public class quizStart {
	private JButton StartButton;
	private JLabel welcomeLabel;
	private JFrame frame;
	private JRadioButton optionABtn;
	private JRadioButton optionBBtn;
	private JRadioButton optionCBtn;
	private JRadioButton optionDBtn;
	private JButton NextButton;
	JButton finishButton = new JButton("Finish");
	JLabel ResultLabel = new JLabel("Exam is over!");
	JLabel SearchLabel = new JLabel("Search Student Score");
	JButton SearchButton = new JButton("Search");
	
	
	
	int[]  qstAttempted = new int[10];
    int questionCount=0;
    int StudentScore=0;
    static String StudentName="";
    QuizQuestions quizQ = new QuizQuestions();
	QuizQuestions Q;
	ButtonGroup G = new ButtonGroup();
	private JTextField UserText;
	
	/**
	 * Launch the application.
	 */
	public static void main(String userName) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					quizStart window = new quizStart();
					window.frame.setVisible(true);
					StudentName = userName;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public quizStart() {
		initialize();
	}

	public void nextRandom(int[] array) {
		Random random=new Random();
		
						
		for(int i=0;i<array.length;i++) {
			
			array[i]=1+random.nextInt(10);
			
			for(int j=0; j<i;j++) {
				if ( array[i]== array[j])
			 	{
			 		i--;
			 		break;
			 	}
			}
			//System.out.println("array i>>"+array[i]);
			 	
		
		   }
		
		
	}
	
	
	public void showFinish() {
		
		//System.out.println("Final Scorer=>>"+score);
		optionABtn.setVisible(false);
		optionBBtn.setVisible(false);
		optionCBtn.setVisible(false);
		optionDBtn.setVisible(false);
		NextButton.setVisible(false);
		welcomeLabel.setVisible(false);
		ResultLabel.setVisible(true);
		finishButton.setVisible(true);
	}

	public void showExamResult() {
		
		System.out.println("Final Scorer=>>"+StudentScore);
		if(StudentScore >= 8) {
			ResultLabel.setText("You Scored "+StudentScore+" ( Class A )");
		}else if(StudentScore>=6) {
			ResultLabel.setText("You Scored "+StudentScore+" ( Class B)");
		}else if(StudentScore == 5) {
			ResultLabel.setText("You Scored "+StudentScore+" ( Class C )");
		}else {
			ResultLabel.setText("<HTML>You Failed in Exam! <BR>Score is "+StudentScore+" ( Class D)</HTML>");
		}
		finishButton.setVisible(false);
		UserText.setVisible(true);
		SearchLabel.setVisible(true);
		SearchButton.setVisible(true);
		
	}
	public boolean validateAnswer(QuizQuestions Q) {
		
		String CorrectAnswer=Q.Answer;
		String StudentAnswer="";
		boolean Flag=false;
		
		//System.out.println("Correct Answer=>>"+CorrectAnswer);
		
		if(optionABtn.isSelected()){
			
			StudentAnswer=Q.OptionA;
        }
        else if(optionBBtn.isSelected()){
        	StudentAnswer=Q.OptionB;
        }else if(optionCBtn.isSelected()){
        	StudentAnswer=Q.OptionC;
        }else if(optionDBtn.isSelected()){
        	StudentAnswer=Q.OptionD;
        }
		
		//System.out.println("<<Student Answer=>>"+StudentAnswer);

		if (CorrectAnswer.equals(StudentAnswer) ) {
			  Flag=true;
			System.out.println("<<Student Answer is Correct=>>"+StudentAnswer);

		}
			
		return Flag;
	}
	
	public void uncheckOptions() {
		
		G.clearSelection();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBounds(100, 100, 575, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		 StartButton = new JButton("START");
		StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartButton.setVisible(false);
				//welcomeLabel.setVisible(false);
                 
				SearchLabel.setVisible(false);
				SearchButton.setVisible(false);
				
				//Get random ID
				//Get Question here.. 
				
				optionABtn.setVisible(true);
				optionBBtn.setVisible(true);
				optionCBtn.setVisible(true);
				optionDBtn.setVisible(true);
				NextButton.setVisible(true);
				
				nextRandom(qstAttempted);
				
				System.out.println("Student Name is =>>"+StudentName);
				
				try {
					Q = quizQ.GetQuestion(qstAttempted[questionCount]);
					
					System.out.println("Question=>>"+Q.Question);
					welcomeLabel.setText(Q.Question);
					System.out.println("OptionA>>"+Q.OptionA);
					
					//System.out.println("OptionB>>"+Q.OptionB);
					//System.out.println("OptionC>>"+Q.OptionC);
					//System.out.println("OptionD>>"+Q.OptionD);
					//System.out.println("Answer=>>"+Q.Answer);
					optionABtn.setText(Q.OptionA);
					optionBBtn.setText(Q.OptionB);
					optionCBtn.setText(Q.OptionC);
					optionDBtn.setText(Q.OptionD);
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			
		});
		StartButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		StartButton.setForeground(new Color(0, 0, 255));
		StartButton.setBounds(216, 144, 143, 49);
		frame.getContentPane().add(StartButton);
		
		welcomeLabel = new JLabel("Welcome to JAVA Quiz  click Start to continue!");
		welcomeLabel.setVerticalAlignment(SwingConstants.TOP);
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		welcomeLabel.setBounds(20, 11, 471, 72);
		frame.getContentPane().add(welcomeLabel);
		
		optionABtn = new JRadioButton("New radio button");
		optionABtn.setBounds(20, 132, 232, 34);
		frame.getContentPane().add(optionABtn);
		
		optionBBtn = new JRadioButton("New radio button");
		optionBBtn.setBounds(20, 181, 232, 40);
		frame.getContentPane().add(optionBBtn);
		
		optionCBtn = new JRadioButton("New radio button");
		optionCBtn.setBounds(20, 234, 232, 43);
		frame.getContentPane().add(optionCBtn);
		
		optionDBtn = new JRadioButton("New radio button");
		optionDBtn.setBounds(20, 287, 232, 49);
		frame.getContentPane().add(optionDBtn);
		
		
		G.add(optionABtn);
		G.add(optionBBtn);
		G.add(optionCBtn);
		G.add(optionDBtn);
		
		optionABtn.setVisible(false);
		optionBBtn.setVisible(false);
		optionCBtn.setVisible(false);
		optionDBtn.setVisible(false);
		finishButton.setForeground(new Color(0, 0, 139));
		finishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				showExamResult();
				UserInfo newS=new UserInfo();
				//Update score to data base
				try {
					newS.updateStudentScore(StudentName,StudentScore);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		
		finishButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		finishButton.setBounds(216, 187, 143, 40);
		frame.getContentPane().add(finishButton);
		finishButton.setVisible(false);
		
		NextButton = new JButton("Next");
		NextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Validate result
				questionCount++;
				//qstAttempted[questionCount]
				
				boolean valAns=validateAnswer(Q);
				
				uncheckOptions();
				
				if(valAns) {
					System.out.println("Answer=>>"+valAns);
					StudentScore++;
					System.out.println("CurrentScore=>>"+StudentScore);

				}
				
				if (questionCount <10) {
				//QuizQuestions quizQ = new QuizQuestions();
				try {
					 Q = quizQ.GetQuestion(qstAttempted[questionCount]);
					
					System.out.println("Question=>>"+Q.Question);
					welcomeLabel.setText(Q.Question);
					//System.out.println("OptionA>>"+Q.OptionA);
					
					//System.out.println("OptionB>>"+Q.OptionB);
					//System.out.println("OptionC>>"+Q.OptionC);
					//System.out.println("OptionD>>"+Q.OptionD);
					//System.out.println("Answer=>>"+Q.Answer);
					optionABtn.setText(Q.OptionA);
					optionBBtn.setText(Q.OptionB);
					optionCBtn.setText(Q.OptionC);
					optionDBtn.setText(Q.OptionD);
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				} else {
					
					//All questions completed
					showFinish();
				}
			}
		});
		NextButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		NextButton.setBounds(418, 291, 89, 23);
		NextButton.setVisible(false);
		
		
		frame.getContentPane().add(NextButton);
		
		
		ResultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ResultLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		ResultLabel.setBounds(151, 68, 274, 106);
		frame.getContentPane().add(ResultLabel);
		
		
		SearchLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		SearchLabel.setBounds(20, 48, 178, 34);
		frame.getContentPane().add(SearchLabel);
		SearchLabel.setVisible(false);
		
		UserText = new JTextField();
		UserText.setText("Enter UserName");
		UserText.setBounds(204, 56, 201, 34);
		frame.getContentPane().add(UserText);
		UserText.setColumns(10);
		UserText.setVisible(false);
		
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Get Score of Student 
				
				String user=UserText.getText();
				int Uscore=0;
				boolean entryExists=false;
				UserInfo student=new UserInfo();
				
							
				try {
					entryExists=student.StudentExists(user);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				if(entryExists)
				{
				try {
					Uscore=student.GetStudentScore(user);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				ResultLabel.setText(user+" Scored ="+Uscore);
				}else {
				
				ResultLabel.setText("Invalid User!");

				}
			}
		});
		
		
		SearchButton.setBounds(435, 60, 89, 23);
		frame.getContentPane().add(SearchButton);
		ResultLabel.setVisible(false);
		SearchButton.setVisible(false);
		
	}
}
