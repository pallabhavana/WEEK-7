import java.awt.*;
import java.awt.event.event.*;
import java.sql.*;
class SFrame extends Frame 
implements ActionListener
{
Label l1,l2,l3;TextField tf1,tf2,tf3;Button b1,b2;
connection c;PreparedStatement ps;
SFrame()
{
l1 = new Label("enter reg no");
l2 = new Label("name");
l3 = new Label("Course");
tf1=new TextField();
tf2=new TextField();
tf3=new TextField();
b1 = new Button("Search");
b2= new Button("clear");
setLayout(new GridLayout(4,2));
add(l1);add(tf1);
add(l2);add(tf2);
add(l3);add(tf3);
add(b1);add(b2);
b1.addActionListener(this);
b2.addActionListener(this);
addWindowListener(new WindowAdapter(){
public void windowClosing(WindowEvent we)
{
dispose();
}});
try
{
class.forName("sun.jdbc.odbc.jdbcOdbcDriver");
c=DriverManager.getConnection("jdbc:odbc:dsnl");
ps = c.PrepareStatement("select*from student where regno=?");
}catch(Exception e)
{
System.out.println(e);
}
}
public void actionPerformed(ActionEvent ae)
{try{
String s = ae.getActionCommand();
if(s.equals("Search"))
{
ps.setInt(1,Integer.parseInt(tf1.getText()));
resultSet rs=ps.excuteQuery();
if(rs.next())
{
tf2.setText(rs.getString(2));
tf3.setText(rs.getString(3));
}
}
else
{
tf1.setText("");tf2.setText("");tf3.setText("");
}
}
catch(Exception e){System.out.printn(e);
}
}
public static void main(String args[]){
SFrame sf = new SFrame();
sf.setvisible(true);
sf.setSize(300,300);
}
}



