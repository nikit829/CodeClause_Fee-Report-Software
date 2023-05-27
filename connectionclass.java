import java.sql.*;

public class connectionclass
{
    Connection con;
    Statement st;

    //default constructor
    connectionclass(){
        String url="jdbc:mysql://localhost:3306/fee_report";
        String username="root";
        String password="student";
    try 
    {
        //connecting to database
        con=DriverManager.getConnection(url, username, password);
        st=con.createStatement();
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
        
    }
    public static void main(String[] args) throws Exception {
       new connectionclass();
    }
}