import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class DBConn {

    private static final String URL = "jdbc:mysql:///qg";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }



}
