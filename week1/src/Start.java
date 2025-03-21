import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;

public class Start {

    private Connection connection;

    public Start(Connection connection) {
        this.connection = connection;
    }

     public  void start() throws SQLException {
        System.out.println("=============================");
        System.out.println("========学生选课管理系统========");
        System.out.println("=============================");
        System.out.println("1.登录");
        System.out.println("2.注册");
        System.out.println("3.退出");
        System.out.println("请选择操作（输入1-3）");

        Scanner sc=new Scanner(System.in);
        int choice1=sc.nextInt();

        switch(choice1){

            case 1:
                Login l=new Login(connection);
                l.denglu();
                break;
            case 2:
                Signup s=new Signup(connection);
                s.zhuce();
                break;
            case 3:
                break;
        }

    }
}
