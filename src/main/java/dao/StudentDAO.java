package dao;

import java.sql.Connection;
import java.sql.Date;

import util.Connector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Course;
import model.Student;

public class StudentDAO {
	private static StudentDAO instance;

	public static StudentDAO getInstance() {
		if (instance == null) {
			instance = new StudentDAO();
		}
		return instance;
	}

	private StudentDAO() {
	}

	private static final String GET_ALL_STUDENTS = "SELECT * FROM studentmanagement.student;";
	private static final String GET_COURSES_A_STUDENT_JOINED = "SELECT c.* FROM studentcourse s\r\n"
			+ "JOIN course c on s.class_id = c.class_id\r\n"
			+ "where s.student_id = ?;";


	public List<Student> getAllStudents() {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Student> studentList = new ArrayList<>();
		try {
			ps = connection.prepareStatement(GET_ALL_STUDENTS);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("student_id");
				String name = rs.getString("name");
				double grade = rs.getDouble("grade");
				Date birthDay = rs.getDate("birthday");
				String address = rs.getString("address");
				String note = rs.getString("note");
				studentList.add(new Student(id, name, grade, birthDay, address, note));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}

		return studentList;
	}
	
	public List<Course> getCoursesStudentJoined(int studentId){
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Course> coursesList = new ArrayList<>();
		try {
			ps = connection.prepareStatement(GET_COURSES_A_STUDENT_JOINED);
			ps.setInt(1, studentId);
			rs = ps.executeQuery();
			while (rs.next()) {
				int sid = rs.getInt("class_id");
				String name = rs.getString("name");
				String lecturer = rs.getString("lecturer");
				String year = rs.getString("year");
				String note = rs.getString("note");
				coursesList.add(new Course(studentId, name, name, sid, note));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}

		return coursesList;
	}

}
