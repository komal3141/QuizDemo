
import java.sql.*;

public class QuizQuestions {
	
		public static String Question;
		public static String OptionA;
		public static String OptionB;
		public static String OptionC;
		public static String OptionD;
		public static String Answer ;
		
	public QuizQuestions GetQuestion(int Q_ID) 
		
		throws SQLException{
			Connection con =null;
			PreparedStatement ps =null;
			ResultSet rs1 =null;
		try {
			System.out.println("Connectin Database...");
			
			while(true)
			{
				dbConnection connection= new dbConnection();
				con=connection.getdbConnectionDetails();			
				//Statement stmt=con.createStatement();
			    //rs1=stmt.executeQuery("select * from question where Question_ID = "+Q_ID); 
			    
			    ps=con.prepareStatement("select * from question where Question_ID=?");
				ps.setInt(1,Q_ID);
				//System.out.println(ps);
				rs1=ps.executeQuery();
			
			    if (!rs1.isBeforeFirst() ) {    
				    System.out.println("No data******"); 
				    break;
				    //con .close();
				} else {
					break;
				}
				
			}
			while(rs1.next()) {
				QuizQuestions Q = new QuizQuestions();
				Q.Question = rs1.getString(2);
				//System.out.println("Got question..."+Q.Question);
				
				//System.out.println("Didn't get question...");

				Q.OptionA = rs1.getString(3);
				Q.OptionB = rs1.getString(4);
				Q.OptionC = rs1.getString(5);
				Q.OptionD = rs1.getString(6);
				Q.Answer = rs1.getString(7);
				ps.close();
				con .close();
				return (Q);
			}
			
		}catch(Exception e) {
			e.getMessage();
			
		}
		return null;
	}
	}
	
		
	

	

		
	
		
	                         


