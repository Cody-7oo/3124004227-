import java.sql.*;
import java.util.Scanner;

public class Login {

    private Connection connection;

    public  Login(Connection connection) {
        this.connection = connection;
    }

    public  void denglu() throws  SQLException{


        System.out.println("=====用户登录=====");
        System.out.println("请输入用户名：");
        Scanner sc=new Scanner(System.in);
        String name=sc.nextLine();
        System.out.println("请输入密码：");
        Scanner sc1 =new Scanner(System.in);
        String password= sc1.nextLine();

        String sql ="select * from users where u_name=? and u_password=?";

        PreparedStatement pstmt=connection.prepareStatement(sql) ;

        pstmt.setString(1,name);
        pstmt.setString(2,password);

        String mysql="select u_role from users where u_name="+'"'+name+'"';

        Statement stmt=connection.createStatement();

        ResultSet rs=pstmt.executeQuery();
        if(rs.next()){
              int role=rs.getInt("u_role");
              if(role==1){
                  System.out.println("登录成功！你的角色是学生");

              }
              else if(role==2){
                  System.out.println("登录成功！你的角色是管理员");
              }
        }
        else{
            System.out.println("用户名或密码错误（3秒后重新登录）");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            denglu();
        }

    }
}
