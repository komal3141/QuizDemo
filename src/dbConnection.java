import java.sql.*;

public class dbConnection {
	
	static Connection connection=null;
	
	public static Connection  getdbConnectionDetails() {
		
		try {
			System.out.println("Connectin Database...");
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizs", "root", "komEnter@1401l");
			
			}catch(Exception e) {
			e.getMessage();
			
		     }
		return connection;
	}

}
