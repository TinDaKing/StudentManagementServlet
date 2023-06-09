package web;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;

@WebServlet(name = "add_student", urlPatterns = { "/add_student" })
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.sendRedirect("students");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			double grade = Double.parseDouble(request.getParameter("grade"));
			Date birthday = Date.valueOf(request.getParameter("birthday"));
			String address = request.getParameter("address");
			String note = request.getParameter("note");
			
			StudentDAO.getInstance().addAStudent(name, grade, birthday, address, note);
			response.sendRedirect("students");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
