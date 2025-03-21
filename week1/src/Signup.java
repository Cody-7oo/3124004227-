import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;


public class Signup {

    private  Connection connection;

    public  Signup(Connection connection) {
        this.connection = connection;
    }


    public  void zhuce() throws SQLException {

        Statement stmt=connection.createStatement();
        ResultSet re=stmt.executeQuery("select * from users");

        System.out.println("====================");
        System.out.println("=======用户注册=======");
        System.out.println("====================");
        System.out.println("请输入用户名：");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("请输入密码：");
        Scanner sc1 = new Scanner(System.in);
        String password = sc1.nextLine();
        System.out.println("请确认密码：");
        Scanner sc2 = new Scanner(System.in);
        String password1 = sc2.nextLine();
        System.out.println("请选择角色（输入1代表学生，2代表管理员）：");
        Scanner sc3 = new Scanner(System.in);
        int Role = sc3.nextInt();

        if (Role != 1 && Role != 2) {
            zhuce();
        }

        while (re.next()) {

            String name1 = re.getString(2);

           if (name1.equals(name)) {
               System.out.println("用户名已存在！！！");
               zhuce();
           }

        }

        String mysql = "insert into users (u_name,u_password,u_role) values ("+'"'+name+'"'+","+'"'+password+'"'+","+Role+")";




        if (password1.equals(password)) {

           stmt.executeUpdate(mysql);
            if (Role==1){
                stmt.executeUpdate("insert into students(name) values ("+'"'+name+'"'+")");
            }
            System.out.println("注册成功！请返回主界面登录！！！(3秒后自动跳转)");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Start start = new Start(connection);
            start.start();
        } else {
            System.out.println("两次密码不相同");
            zhuce();
        }

        stmt.close();
        re.close();

    }

}