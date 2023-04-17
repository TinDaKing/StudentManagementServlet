package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CourseDAO;


@WebServlet("/add_course")
public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddCourseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("courses");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String lecturer = request.getParameter("lecturer");
			int year = Integer.parseInt(request.getParameter("year"));
			String note = request.getParameter("note");
			
			CourseDAO.getInstance().addACourse(name, lecturer, year, note);
			response.sendRedirect("courses");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
