package web;

import java.io.IOException;
import java.time.Year;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;
import model.Course;
import model.Student;

/**
 * Servlet implementation class CourseDetail
 */
@WebServlet("/course_detail")
public class CourseDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			
			Course cou = CourseDAO.getInstance().getCourseByID(id);
			List<Student> studentList = CourseDAO.getInstance().getAllStudentsOfCourse(id);
			
			request.setAttribute("thisYear",  Year.now().getValue()+1);
			request.setAttribute("course", cou);
			request.setAttribute("studentList", studentList);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("course-detail.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String lecturer = request.getParameter("lecturer");
			int year = Integer.parseInt(request.getParameter("year"));
			String note = request.getParameter("note");

			CourseDAO.getInstance().updateCourseByID(id, name, lecturer, year, note);

			response.sendRedirect("course_detail?id=" + id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
