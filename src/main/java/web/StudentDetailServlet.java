package web;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import model.Course;
import model.Student;

/**
 * Servlet implementation class StudentDetailServlet
 */
@WebServlet("/student_detail")
public class StudentDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Student stu = StudentDAO.getInstance().getStudentByID(id);
			List<Course> courseList = StudentDAO.getInstance().getCoursesStudentJoined(id);
			request.setAttribute("student", stu);
			request.setAttribute("courseList", courseList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("student-detail.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			double grade = Double.parseDouble(request.getParameter("grade"));
			Date birthDay = Date.valueOf(request.getParameter("birthday"));
			String address = request.getParameter("address");
			String note = request.getParameter("note");

			StudentDAO.getInstance().updateStudentByID(id, name, grade, birthDay, address, note);

			response.sendRedirect("student_detail?id=" + id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
