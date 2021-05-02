import java.sql.*;
class EUpdate
{
public static void main(String a[])
{
Connection c;
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
c = DriverManager.getConnection("jdbc:odbc:DSn1");
PreparedStatement ps = c.prepareStatement("update Student set SName=?,course=?where regno=?");
ps.setInt(1,Integer.parseInt(a[0]));
ps.setString(1,a[1]);
ps.setString(2,a[2]);
int k = ps.executeUpdate();
if(k>0)
System.out.println("Record succesfully updated");
c.close();
}catch(Exception e)
{
System.out.println(e);
}
}
}