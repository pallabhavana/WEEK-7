import java.sql.*;
class EInsert
{
public static void main(String a[])
{
Connection c;
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
c = DriverManager.getConnection("jdbc:odbc:DS7");
Statement s= c.createStatement();
int k=s.executeUpdate("insert into student valus(103,'bhavs''BE')");
if(k>0)
System.out.println("Record succesfully inserted");
c.close();
}catch(Exception e)
{
System.out.println(e);
}
}
}