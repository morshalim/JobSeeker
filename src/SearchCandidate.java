

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchCandidate
 */
public class SearchCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchCandidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int exp1=Integer.parseInt(request.getParameter("sel"));

		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();

		DBConnector dc=new DBConnector();
		Connection con=dc.getConnection();
		ResultSet res;

		try {
			PreparedStatement pstmt=con.prepareStatement("SELECT * FROM JSEEK WHERE TYPE='jseek' AND EXP>="+exp1+"");

			res=pstmt.executeQuery();
			while(res.next()==true)
			{

				pw.write("<html><head><title>SuccessSearch</title></head><body>"
						+ "Fname:'"+res.getString("fname")+"'</br>Lname:'"+res.getString("lname")+"'"
						+ "</br>Email:'"+res.getString("email")+"'</br>Mob no:'"+res.getString("mob")+"'</br>"
						+ "Experience:'"+res.getString("exp")+"'</br></br></br>"
						+ "</body></html>");

			}
			/*if(res.next()==false) {
				pw.write("<html><head><title>Errorsearch</title></head<body>Unable to search data</body></html>");
			}
*/
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
