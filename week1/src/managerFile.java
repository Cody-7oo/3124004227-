import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class managerFile {
    private Connection connection;

    public managerFile(Connection connection) {
        this.connection = connection;
    }

    public void managerFile() throws SQLException {

        System.out.println("=====管理员菜单=====");
        System.out.println("1.查看所有学生");
        System.out.println("2.修改学生手机号");
        System.out.println("3.查询所有课程");
        System.out.println("4.修改课程学分");
        System.out.println("5.查询某课程的学生名单");
        System.out.println("6.查询某学生的选课情况");
        System.out.println("7.退出");

        Scanner sc=new Scanner(System.in);
        int choice=sc.nextInt();

        Statement stmt=connection.createStatement();

        switch(choice){

            case 1:
                ResultSet rs=stmt.executeQuery("select * from students");
                while(rs.next()){
                    String name=rs.getString("name");
                    String phone=rs.getString("phone");

                    System.out.println(name+" "+phone);
                }
                System.out.println("查询成功（5秒后回菜单）");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                managerFile();
                break;
            case 2:

                System.out.println("请输入需要修改的学生名字");
                Scanner sc2=new Scanner(System.in);
                String stu_name=sc2.nextLine();
                System.out.println("请输入手机号");
                Scanner sc1=new Scanner(System.in);
                String num=sc1.nextLine();
                if (num.length()!=11){
                    System.out.println("手机号有误");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    managerFile();
                }
                stmt.executeUpdate("update students set phone="+'"'+num+'"' +"where name="+'"'+stu_name+'"');
                System.out.println("修改成功（5秒后回菜单）");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                managerFile();
                break;
            case 3:
                ResultSet rs1=stmt.executeQuery("select * from courses");
                while(rs1.next()){
                   String name=rs1.getString("name");
                   int score=rs1.getInt("score");
                   String date=rs1.getString("date");
                    System.out.println(name+" "+score+" "+date);
                }
                System.out.println("查询成功（5秒后回菜单）");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                managerFile();
                break;
            case 4:
                System.out.println("请输入课程名称");
                Scanner sc3=new Scanner(System.in);
                String cour_name=sc3.nextLine();
                System.out.println("请输入修改后的学分");
                Scanner sc4=new Scanner(System.in);
                int cour_score=sc4.nextInt();
                stmt.executeUpdate("update courses set score="+'"'+cour_score+'"' +"where name="+'"'+cour_name+'"');
                System.out.println("修改成功（5秒后回菜单）");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                managerFile();
                break;
            case 5:
                //查询某课程的学生名单
                System.out.println("请输入你要查询的课程：");
                Scanner sc5=new Scanner(System.in);
                String cour_name1=sc5.nextLine();
                ResultSet rs2=stmt.executeQuery("select * from student_course where course_name="+'"'+cour_name1+'"');
                while(rs2.next()){
                    String name1=rs2.getString("student_name");
                    System.out.println(name1);
                }
                System.out.println("查询成功（5秒后回菜单）");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                managerFile();
                break;
            case 6:
                //查询某学生的选课情况
                System.out.println("请输入你要查询的学生：");
                Scanner sc6=new Scanner(System.in);
                String student_name=sc6.nextLine();
                ResultSet rs3= stmt.executeQuery("select * from student_course where student_name="+'"'+student_name+'"');
                while (rs3.next()){
                    String course_name3=rs3.getString("course_name");
                    System.out.println(course_name3);
                }
                System.out.println("查询成功（5秒后回菜单）");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                managerFile();
                break;
            case 7:
                Start start = new Start(connection);
                start.start();
                break;


        }

    }
}


