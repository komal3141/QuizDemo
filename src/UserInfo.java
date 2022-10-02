import java.sql.*;

public class UserInfo {
	public static String UserName;
	public static String Passwrd  ;
	public static String FirstName;
	public static String LastName;
	public static int Score;
	
	public void UpdateStudentInfo(UserInfo studentInfo) 
		
		throws SQLException{
			Connection con =null;
			PreparedStatement ps =null;
			
		try {
			System.out.println("Connectin Database...");
			dbConnection connection= new dbConnection();
			con=connection.getdbConnectionDetails();
			
			ps=con.prepareStatement("INSERT INTO student_data (UserName,Passwrd,FirstName,LastName,Score) VALUES (?,?,?,?,?)");
			ps.setString(1, studentInfo.UserName);
			ps.setString(2, studentInfo.Passwrd);
			ps.setString(3, studentInfo.FirstName);
			ps.setString(4, studentInfo.LastName);
			ps.setInt(5, studentInfo.Score);
			
			int q = ps.executeUpdate();
				
			con.close();
			
			}catch(Exception e) {
			e.getMessage();
			
		     }
		
		
	
	}
	
	public boolean StudentExists(String UserName) throws SQLException {
		
		boolean isExists=false;
		Connection con =null;
		ResultSet rs1 =null;
		PreparedStatement ps =null;

		int ID=0;
		
		dbConnection connection= new dbConnection();
		con=connection.getdbConnectionDetails();
		
		//Statement stmt=con.createStatement();
		//rs1=stmt.executeQuery("select Id from student_data where UserName="+UserName); 
		
		ps=con.prepareStatement("select Id from student_data where UserName=?");
		ps.setString(1, UserName);
		
		System.out.println(ps);
		rs1=ps.executeQuery();
		
		if(rs1.next())
			 ID = rs1.getInt(1);
		
		System.out.println(ID);

		if(ID!=0)
			isExists=true;
			
		return isExists;
	}
	
	public int GetNumberOfStudents() throws SQLException {
		
		int count=0;
		Connection con =null;
		ResultSet rs1 =null;
		PreparedStatement ps =null;

				
		dbConnection connection= new dbConnection();
		con=connection.getdbConnectionDetails();
		
		//Statement stmt=con.createStatement();
		//rs1=stmt.executeQuery("select Id from student_data where UserName="+UserName); 
		
		ps=con.prepareStatement("select count(*) from student_data");
		//ps.setString(1, UserName);
		
		System.out.println(ps);
		rs1=ps.executeQuery();
		
		if(rs1.next())
			 count = rs1.getInt(1);
		
		System.out.println(count);
		
		return count;
	}
	
	public int GetStudentScore(String UserName) throws SQLException {
		
		int score=0;
		Connection con =null;
		ResultSet rs1 =null;
		PreparedStatement ps =null;

				
		dbConnection connection= new dbConnection();
		con=connection.getdbConnectionDetails();
		
		//Statement stmt=con.createStatement();
		//rs1=stmt.executeQuery("select Id from student_data where UserName="+UserName); 
		
		ps=con.prepareStatement("select Score from student_data where UserName=?");
		ps.setString(1, UserName);
		
		System.out.println(ps);
		rs1=ps.executeQuery();
		
		if(rs1.next())
			 score = rs1.getInt(1);
		
		System.out.println(score);

					
		return score;

	
	}
	
	
		public String GetUserPassword(String UserName) throws SQLException {
		
		String paswrd="1234";
		Connection con =null;
		ResultSet rs1 =null;
		PreparedStatement ps =null;

				
		dbConnection connection= new dbConnection();
		con=connection.getdbConnectionDetails();
		
		//Statement stmt=con.createStatement();
		//rs1=stmt.executeQuery("select Id from student_data where UserName="+UserName); 
		
		ps=con.prepareStatement("select Score from student_data where UserName=?");
		ps.setString(1, UserName);
		
		System.out.println(ps);
		rs1=ps.executeQuery();
		
		if(rs1.next())
			paswrd = rs1.getString(1);
		
		System.out.println(paswrd);

					
		return paswrd;

	
	}
		
		
		public void updateStudentScore(String UserName,int score) throws SQLException {
			
			
			Connection con =null;
			ResultSet rs1 =null;
			PreparedStatement ps =null;

					
			dbConnection connection= new dbConnection();
			con=connection.getdbConnectionDetails();
			
			//Statement stmt=con.createStatement();
			//rs1=stmt.executeQuery("select Id from student_data where UserName="+UserName); 
			
			ps=con.prepareStatement("update student_data set score = ? where UserName = ?");
			ps.setInt(1, score);
			ps.setString(2, UserName);
			
			System.out.println(ps);
		    ps.executeUpdate();
			
			System.out.println(score);

			
		}


	}
	


