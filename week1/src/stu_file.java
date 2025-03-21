import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class stu_file {
    private Connection connection;
    public String stu_name;

    public stu_file(Connection connection,String name) {
        this.connection = connection;
        stu_name = name;
    }



    public void  stuFile() throws SQLException {

        System.out.println("=====学生菜单=====");
        System.out.println("1.查看可选课程");
        System.out.println("2.选择课程");
        System.out.println("3.退选课程");
        System.out.println("4.查看已选课程");
        System.out.println("5.修改手机号");
        System.out.println("6.退出");

        Scanner sc=new Scanner(System.in);
        int choice=sc.nextInt();

        Statement st=connection.createStatement();


        switch(choice){

            case 1:
                ResultSet rs=st.executeQuery("select * from courses");
                while(rs.next()){
                    String name=rs.getString("name");
                    int score=rs.getInt("score");
                    String date=rs.getString("date");

                    System.out.println(name+" "+score+" "+date);
                    System.out.println("------------------ ");
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                stuFile();
                break;
            case 2:
                int cnt=0;
                ResultSet rs6=st.executeQuery("select * from student_course where student_name="+'"'+stu_name+'"');
                while(rs6.next()){
                    cnt++;
                }

                if (cnt>=5){
                    System.out.println("你已满课");
                    stuFile();
                }

                System.out.println("请输入你要选择的课程：");
                Scanner sc3=new Scanner(System.in);
                String cour_name=sc3.nextLine();
                st.executeUpdate("insert into student_course (student_name ,course_name)values("+'"'+stu_name+'"'+","+'"'+cour_name+'"'+")");
                System.out.println("选择成功（5秒后回菜单）");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                stuFile();
                break;
            case 3:
                System.out.println("请输入你要退的课程：");
                Scanner sc4=new Scanner(System.in);
                String course_name1=sc4.nextLine();

                ResultSet re6=st.executeQuery("select * from courses where name="+'"'+course_name1+'"');
                Date ddl=re6.getDate("date");

                LocalDate currentDate=LocalDate.now();

               // if (ddl.){
               //     System.out.println("已开课，无法退课");
               //     stuFile();
               // }

                st.executeUpdate("delete from student_course where course_name="+'"'+course_name1+'"'+"and student_name="+'"'+stu_name+'"');
                System.out.println("退课成功（5秒后回菜单）");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                stuFile();
                break;
            case 4:
                ResultSet rs1=st.executeQuery("select * from student_course where student_name="+'"'+stu_name+'"');
                while(rs1.next()){
                    String course_name2=rs1.getString("course_name");
                    System.out.println(course_name2);
                }
                System.out.println("查询成功（5秒后回菜单）");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                stuFile();
                break;
            case 5:
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
                    stuFile();
                }
                st.executeUpdate("update students set phone="+'"'+num+'"' +"where name="+'"'+stu_name+'"');
                System.out.println("修改成功（5秒后回菜单）");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                stuFile();
                break;
            case 6:
                Start start = new Start(connection);
                start.start();
                break;


        }


    }

}
