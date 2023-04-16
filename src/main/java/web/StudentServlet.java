package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import model.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet(name = "students", urlPatterns = { "/students" })
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Student> studentList = null;
			String pivot = request.getParameter("sortby");
			
			if (pivot != null) {
				studentList = StudentDAO.getInstance().getAllStudentsSortBy(pivot);
			} else {
				studentList = StudentDAO.getInstance().getAllStudents();
			}
			request.setAttribute("studentList", studentList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("students.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nameInput = request.getParameter("studentName");
			if (nameInput != "") {
				List<Student> studentList = StudentDAO.getInstance().getStudentsByName(nameInput);
				request.setAttribute("studentList", studentList);

				RequestDispatcher dispatcher = request.getRequestDispatcher("students.jsp");
				dispatcher.forward(request, response);
			} else {
				doGet(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
