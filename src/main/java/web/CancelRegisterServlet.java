package web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;
import dao.StudentDAO;

/**
 * Servlet implementation class CancelRegisterServlet
 */
@WebServlet("/cancel_register")
public class CancelRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String referer = request.getHeader("Referer");
		response.sendRedirect(referer);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int studentId = Integer.parseInt(request.getParameter("student_id"));
			int courseId = Integer.parseInt(request.getParameter("course_id"));
			
			RegisterDAO.getInstance().cancelRegister(studentId, courseId);
			String referer = request.getHeader("Referer");
			response.sendRedirect(referer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
