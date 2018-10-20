

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		
		DBConnector dc=new DBConnector();
		Connection con=dc.getConnection();
		ResultSet res;
		HttpSession session=request.getSession(true);
		
		try {
			PreparedStatement pstmt=con.prepareStatement("SELECT * FROM JSEEK WHERE UNAME=? AND PWD=?");
			pstmt.setString(1, uname);
			pstmt.setString(2, pwd);
			res=pstmt.executeQuery();
			/*while(res.next()==true)
			{
				uname=res.getString("UNAME");
				pwd=res.getString("PWD");
				

			}*/
			if(res.next()==true) {
				
				session.setAttribute("fname", res.getString("fname"));
				session.setAttribute("lname", res.getString("lname"));
				session.setAttribute("type", res.getString("type"));
				session.setAttribute("email", res.getString("email"));
				session.setAttribute("mob", res.getString("mob"));
				session.setAttribute("exp", res.getInt("exp"));
				session.setAttribute("uname", res.getString("uname"));
				session.setAttribute("pwd", res.getString("pwd"));
				
				response.sendRedirect("/JobSeeker.com/successLogin.jsp");
			}
			else {
				response.sendRedirect("/JobSeeker.com/errorLogin.html");
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
