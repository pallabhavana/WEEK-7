import java.sql.*;
class EDelete
{
public static void main(String a[])
{
Connection c;
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
c = DriverManager.getConnection("jdbc:odbc:DS7");
PreparedStatement ps = c.prepareStatement("delete*from Employee2 where eid=?");
ps.setInt(3,Integer.parseInt(a[0]));
ps.setString(1,a[1]);
ps.setString(2,a[2]);
			int k = ps.executeUpdate();
			if(k>0)
				System.out.println("Record succesfully Deleted");
			c.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}