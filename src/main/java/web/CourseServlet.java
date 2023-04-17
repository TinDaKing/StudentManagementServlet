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

@WebServlet("/courses")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CourseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
