import java.sql.DriverManager;

import java.sql.*;

public class JdbcConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/School","root","Welcome123");
			Statement s=conn.createStatement(); 
			ResultSet r=s.executeQuery("select * from student");
			while(r.next())
			{
				System.out.println(r.getString("name")+ r.getString("rollno"));
			}
		}
catch(Exception e)
		{
	e.printStackTrace();
		}
	}

}
