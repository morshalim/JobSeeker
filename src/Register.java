

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String type=request.getParameter("type");
		String mobno=request.getParameter("mob");
		String email=request.getParameter("email");
		/*String dob=request.getParameter("dob");*/
		int exp=Integer.parseInt(request.getParameter("exp"));
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		
		DBConnector dc=new DBConnector();
		Connection con=dc.getConnection();
		
		ResultSet res;
		
		boolean b = false;
		try {
			PreparedStatement  pstmt=con.prepareStatement("INSERT INTO JSEEK VALUES('"+fname+"','"+lname+"','"+type+"','"+email+"','"+mobno+"',"+exp+",'"+uname+"','"+pwd+"')");
			b=pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(b==false) {
			response.sendRedirect("/JobSeeker.com/successRegister.jsp");
		}
		else {
			response.sendRedirect("/JobSeeker.com/failedRegister.jsp");
		}
		
	}

}
