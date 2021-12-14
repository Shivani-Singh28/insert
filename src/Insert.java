import java.sql.*;
import java.util.Scanner;

public class Insert {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","");
        Statement smtl=con.createStatement();
        String sqlquery="insert into new values(?,?,?)";
        PreparedStatement ps=(PreparedStatement) con.prepareStatement(sqlquery);
        while(true){
            Scanner sc=new Scanner(System.in);
            System.out.println("enter student name");
            String name=sc.next();
            System.out.println("enter student age");
            int age= Integer.parseInt(sc.next());
            System.out.println("enter student rollno");
            int rollno= Integer.parseInt(sc.next());
            ps.setString(1,name);
            ps.setInt(2,age);
            ps.setInt(3,rollno);
            ps.executeUpdate();
            System.out.println("do you want to continue");
            String choice=sc.next();
            if(choice.equalsIgnoreCase("no"))
            {
                break;
            }
        }
        con.close();
    }
}


