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

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/courses")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<Course> courseList = null;
			String pivot = request.getParameter("sortby");
			
			if (pivot != null) {
				courseList = CourseDAO.getInstance().getAllCoursesSortBy(pivot);
			} else {
				courseList = CourseDAO.getInstance().getAllCourses();
			}
			
			request.setAttribute("thisYear",  Year.now().getValue()+1);
			request.setAttribute("courseList", courseList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("courses.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String nameInput = request.getParameter("name");
			if (nameInput != "") {
				List<Course> courseList = CourseDAO.getInstance().getCoursesByName(nameInput);
				request.setAttribute("courseList", courseList);

				RequestDispatcher dispatcher = request.getRequestDispatcher("courses.jsp");
				dispatcher.forward(request, response);
			} else {
				doGet(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
