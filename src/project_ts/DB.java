package project_ts;

import java.sql.*;

public class DB {
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultset;
	
	 String url = "jdbc:mysql://den1.mysql3.gear.host:3306/barioaandb?useSSL=true";
     String user = "barioaandb";
     String password = "paroladb@";
	
	public DB() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, user, password);
            
		}catch(Exception e) {
			System.out.println("Eroare la connectare DB.");
		}
	}
	
	public void register(String username, String password) throws SQLException {
		
		statement = connection.createStatement();
        
        statement.execute("INSERT INTO useri (username, password) VALUES" + 
                "('"+username+"', '"+password+"')");		
	}
	
	public void checkLogin(String username, String password) {
	//	ResultSet res = stt.executeQuery("SELECT * FROM people WHERE lname = 'Bloggs'");
		try {
			resultset = statement.executeQuery("SELECT username, password FROM useri WHERE username =" + username + " AND passowrd =" + password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
