import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnector 
{

	Connection con;
	public Connection getConnection()
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","virus","virus");
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	public void closeCon() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}