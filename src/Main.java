import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import  java.util.Scanner;

public class Main {
     static Scanner scanner = new Scanner(System.in);
    public static  void  main(String[] args){
       insertStudent();
       selectStudent();
       updateStudent();
       deleteStudent();
        insertTeacher();
        selectTeacher();
        updateTeacher();
        deleteTeacher();

    }

    static void deleteStudent(){
        int rollNo =scanner.nextInt() ;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai","root","");
            Statement st = con.createStatement();
            int count = st.executeUpdate("delete from student where rollNo='"+rollNo+"'");
            if (count>0){
                System.out.println("Student is deleted from database");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    static void updateStudent(){
          Student student = new Student();
          student.setRollno(scanner.nextInt());
          student.setName(scanner.next());
          student.setEmail(scanner.next());
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai","root","");
            Statement st = con.createStatement();
            st.executeUpdate("update student set name='"+student.getName()+"' ,email='"+student.getEmail()+"' where rollNo='"+student.getRollno()+"' ");
            selectStudent(student.getRollno());
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
     static void selectStudent(){
        Student student = new Student();
        int rollNo= scanner.nextInt();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai","root","");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student where rollNo='"+rollNo+"'");
            while (rs.next()){
                student.setRollno(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
            }
            System.out.println(student.getRollno());
            System.out.println(student.getName());
            System.out.println(student.getEmail());
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    static void selectStudent(int rollNo) {
        Student student = new Student();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student where rollNo='" + rollNo + "'");
            while (rs.next()) {
                student.setRollno(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setEmail(rs.getString(3));
            }
            System.out.println(student.getRollno());
            System.out.println(student.getName());
            System.out.println(student.getEmail());
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
     static void insertStudent(){
        Student student = new Student();
        student.setRollno(scanner.nextInt());
        student.setName(scanner.next());
        student.setEmail(scanner.next());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai","root","");
            Statement st = con.createStatement();
            st.executeUpdate("insert into student values('"+student.getRollno()+"','"+student.getName()+"','"+student.getEmail()+"')");

        }
        catch (Exception e){
            System.out.println(e);
        }
    }

     static void deleteTeacher(){
        int Id =scanner.nextInt() ;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai","root","");
            Statement ab = con.createStatement();
            int count = ab.executeUpdate("delete from teacher where Id='"+Id+"'");
            if (count>0){
                System.out.println("Teacher is deleted from database");
            }
        }
        catch (Exception a){
            System.out.println(a);
        }
    }
    static void updateTeacher(){
        Teacher teacher = new Teacher();
        teacher.setId(scanner.nextInt());
        teacher.setName(scanner.next());
        teacher.setEmail(scanner.next());
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai","root","");
            Statement ab = con.createStatement();
            ab.executeUpdate("update teacher set name='"+teacher.getName()+"' ,email='"+teacher.getEmail()+"' where Id='"+teacher.getId()+"' ");
            selectTeacher(teacher.getId());
        }
        catch (Exception a){
            System.out.println(a);
        }
    }
    static void selectTeacher(){
        Teacher teacher = new Teacher();
        int Id= scanner.nextInt();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai","root","");
            Statement ab = con.createStatement();
            ResultSet cd = ab.executeQuery("select * from teacher where Id='"+Id+"'");
            while (cd.next()){
                teacher.setId(cd.getInt(1));
                teacher.setName(cd.getString(2));
                teacher.setEmail(cd.getString(3));
            }
            System.out.println(teacher.getId());
            System.out.println(teacher.getName());
            System.out.println(teacher.getEmail());
        }
        catch (Exception a){
            System.out.println(a);
        }
    }
    static void selectTeacher(int Id) {
        Teacher teacher = new Teacher();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai", "root", "");
            Statement ab = con.createStatement();
            ResultSet cd = ab.executeQuery("select * from teacher where Id='" + Id + "'");
            while (cd.next()) {
                teacher.setId(cd.getInt(1));
                teacher.setName(cd.getString(2));
                teacher.setEmail(cd.getString(3));
            }
            System.out.println(teacher.getId());
            System.out.println(teacher.getName());
            System.out.println(teacher.getEmail());
        }
        catch (Exception a) {
            System.out.println(a);
        }
    }
    static void insertTeacher(){
        Teacher teacher = new Teacher();
        teacher.setId(scanner.nextInt());
        teacher.setName(scanner.next());
        teacher.setEmail(scanner.next());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mumbai","root","");
            Statement ab = con.createStatement();
            ab.executeUpdate("insert into student values('"+teacher.getId()+"','"+teacher.getName()+"','"+teacher.getEmail()+"')");

        }
        catch (Exception a){
            System.out.println(a);
        }
    }
}