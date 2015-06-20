

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveToDatabase
 */
@WebServlet("/SaveToDatabase")
public class SaveToDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveToDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/AppSyncData";
		String username = "root";
		String pwrd = "root";
		
		try
		{
			String fname = request.getParameter("firstname");
			String lname = request.getParameter("lastname");
			String email_id = request.getParameter("emailid");
			String cnt = request.getParameter("contactnum");
			String userid = request.getParameter("uname");
			String pword = request.getParameter("pass");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
	        conn = DriverManager.getConnection(url,username,pwrd);
	        PreparedStatement pst = (PreparedStatement)conn.prepareStatement("insert into user_details (FirstName, LastName, EmailID, ContactNumber, UserName, Password) values(?,?,?,?,?,?)");
	        pst.setString(1,fname);
	        pst.setString(2,lname);
	        pst.setString(3,email_id);
	        pst.setString(4,cnt);
	        pst.setString(5,userid);
	        pst.setString(6,pword);
	        
	        int i = pst.executeUpdate();
	        String msg = " ";
	        if(i!=0){  
	            msg="Record has been inserted";
	            pw.println("<font size='12' color=blue>" + msg + "</font>");  
	          }  
	          else{  
	            msg="Failed to insert the data";
	            pw.println("<font size='12' color=blue>" + msg + "</font>");
	           } 
	        conn.close();
		}
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
	}

}
