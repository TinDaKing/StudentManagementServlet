package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.Connector;

public class RegisterDAO {
	private static RegisterDAO instance;

	public static RegisterDAO getInstance() {
		if (instance == null) {
			instance = new RegisterDAO();
		}
		return instance;
	}

	private RegisterDAO() {
	}

	private static final String REGISTER_A_STUDENT_TO_A_COURSE = "INSERT INTO studentcourse (student_id, class_id) "
			+ "VALUES (?, ?);";
	private static final String CANCEL_A_REGISTER = "DELETE FROM studentcourse "
			+ "WHERE (student_id = ?) and (class_id = ?);";

	public boolean registerStudentToCourse(int studentId, int courseId) {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		int rowChanged = 0;
		try {
			ps = connection.prepareStatement(REGISTER_A_STUDENT_TO_A_COURSE);
			ps.setInt(1, studentId);
			ps.setInt(2, courseId);
			rowChanged = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (rowChanged > 0)
			return true;
		return false;
	}

	public boolean cancelRegister(int studentId, int courseId) {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		int rowChanged = 0;
		try {
			ps = connection.prepareStatement(CANCEL_A_REGISTER);
			ps.setInt(1, studentId);
			ps.setInt(2, courseId);
			rowChanged = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (rowChanged > 0)
			return true;
		return false;
	}
}
