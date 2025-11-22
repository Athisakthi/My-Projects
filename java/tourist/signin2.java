package tourist;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * Servlet implementation class signin
 */
@WebServlet("/signin")
public class signin2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signin2() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
		String user=request.getParameter("username");
		String email=request.getParameter("email");
		String no=request.getParameter("mobile");
		long number=Long.parseLong(no);
		String pass=request.getParameter("password");
		String confirm=request.getParameter("confirm");
		int count=0;
		if(pass.equals(confirm)) {

			try {
				tourist.signin(user,email,number, pass);

				response.sendRedirect("second.jsp?a="+number);

			}catch(SQLIntegrityConstraintViolationException e) {
				response.sendRedirect("login.jsp");
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch(SQLException e) {
				e.printStackTrace();
			}

		}else if(!pass.equals(confirm)){

			response.sendRedirect("signsuccess.jsp");
		}

	}

}
