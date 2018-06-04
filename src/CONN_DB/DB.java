package CONN_DB;

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

    public boolean register(String username, String password) throws SQLException {

        statement = connection.createStatement();

        if(!checkLoginUsername(username)){
            statement.execute("INSERT INTO useri (username, password) VALUES" +
                    "('"+username+"', '"+password+"')");
            statement.close();
            return true;
        }else{
            return false;
        }


    }

    public boolean checkLoginUsername(String username) {

        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM useri WHERE username = ? ";
            // Assuming there is a global variable for the connection, named con
            PreparedStatement ppst = connection.prepareStatement(sql);
            ppst.setString(1, username);
            resultset = ppst.executeQuery();

            if(resultset.next()){
                return true;
            }else{
                return  false;
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Eroare la check login");
            e.printStackTrace();
        }


        return false;
    }

    public boolean checkLogin(String username, String password) {

        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM useri WHERE username = ? AND password = ? ";
            // Assuming there is a global variable for the connection, named con
            PreparedStatement ppst = connection.prepareStatement(sql);
            ppst.setString(1, username);
            ppst.setString(2, password );
            resultset = ppst.executeQuery();

            if(resultset.next()){
               return true;
            }else{
                return  false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Eroare la check login");
            e.printStackTrace();
        }

        return false;
    }

}
