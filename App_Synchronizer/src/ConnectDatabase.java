import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectDatabase {
	public static Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appsyncdata","root","root");
			return con;
		}
		catch(Exception e)
		{
			System.out.println("Database Connection Error!");
			e.printStackTrace();
			return null;
		}
	}
	public static void close(Connection con)
	{
		try{con.close();}
		catch(Exception e){e.printStackTrace();}
	}
}
