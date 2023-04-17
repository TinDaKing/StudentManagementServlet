package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RegisterDAO;

@WebServlet("/cancel_register")
public class CancelRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CancelRegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String path = request.getParameter("path");
			int studentId = Integer.parseInt(request.getParameter("student_id"));
			int courseId = Integer.parseInt(request.getParameter("course_id"));
			RegisterDAO.getInstance().cancelRegister(studentId, courseId);
			response.sendRedirect(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.sendRedirect("students");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
