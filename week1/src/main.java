import java.sql.*;

public class main {
    public static void main(String[] args) throws Exception {

        String url="jdbc:mysql:///qg";
        String username="root";
        String password="1234";
        Connection conn=DriverManager.getConnection(url,username,password);

        Start start = new Start(conn);
        start.start();



    }
}


