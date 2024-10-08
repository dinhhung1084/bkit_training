import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExceptionHandling {

    public static void main(String[] args) {

        File file = new File("hello.txt");
        String url = "jdbc:mysql://localhost:3306/db";
        String user = "root";
        String password = "12345";
        try{
//            int a = 100/0; //ArithmeticException

//            String b=null;
//            System.out.println(b.length());//NullPointerException

//            String c="abc";
//            int i=Integer.parseInt(c);//NumberFormatException

//            int d[]=new int[5];
//            d[10]=50; //ArrayIndexOutOfBoundsException

//        try (FileReader fr = new FileReader(file)){
//            int data;
//            while ((data =fr.read()) != -1){
//                System.out.println((char) data); //IOException
//            }


//        try(Connection conn = DriverManager.getConnection(url,user,password)){
//            Statement stmt = conn.createStatement();
//
//            String query = "SELECT * FROM HEHE";
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()){
//                System.out.println(rs.getInt("id")); //SQLException
//            }

            Class.forName("abc.xyz"); //ClassNotFoundException



        }catch(Exception e){
            System.out.println(e);
        }
    }
}

