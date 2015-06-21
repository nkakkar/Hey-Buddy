import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginDAO {
	public static boolean validate(String user, String password)
	{
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = ConnectDatabase.getConnection();
			ps = con.prepareStatement("Select UserName, Password from user_details where UserName = ? and Password = ?");
			ps.setString(1,user);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				//result found, means valid input
				return true;
			}
		}
		catch(Exception e)
		{
			System.out.println("Login Error!");
			e.printStackTrace();
			return false;
		}
		finally
		{
			ConnectDatabase.close(con);
		}
		return false;
	}
}
