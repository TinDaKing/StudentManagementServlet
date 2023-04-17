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
	private static final String GET_COURSES_A_STUDENT_JOINED = "SELECT c.* FROM studentcourse s "
			+ "			JOIN course c on c.class_id = s.class_id "
			+ "			WHERE s.student_id=?;";
	private static final String GET_ALL_STUDENTS_SORT_BY = "SELECT * FROM studentmanagement.student " 
			+ "ORDER BY ";
	private static final String GET_STUDENTS_BY_NAME = "SELECT * FROM studentmanagement.student "
			+ "WHERE name LIKE '%";
	private static final String DELETE_STUDENT_BY_ID = "DELETE FROM student WHERE student_id=?;";
	private static final String DELETE_REGISTER_RECORD_OF_STUDENT = "DELETE FROM studentcourse "
			+ "WHERE student_id = ?;";
	private static final String ADD_A_STUDENT = "INSERT INTO student(name,grade,birthday,address,note) "
			+ "VALUES (?,?,?,?,?);";
	private static final String GET_A_STUDENT_BY_ID = "SELECT * FROM student WHERE student_id=?;";
	private static final String UPDATE_ROW_BY_ID = "UPDATE student "
			+ "SET name = ?, grade = ?, birthday = ?, address = ?, note = ? "
			+ "WHERE student_id = ?;";
	private String prePivot;
	private String nextOrder;

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

	public List<Student> getAllStudentsSortBy(String pivot) {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Student> studentList = new ArrayList<>();
		try {
			String query = "";
			if (prePivot != null && pivot.equals(prePivot)) {
				query = GET_ALL_STUDENTS_SORT_BY + prePivot + nextOrder;
				if (nextOrder == " DESC;")
					nextOrder = " ASC;";
				else
					nextOrder = " DESC;";
			} else {
				if (pivot.equals("name")) {
					query = GET_ALL_STUDENTS_SORT_BY + "name;";
					prePivot = "name";
					nextOrder = " DESC;";
				} else if (pivot.equals("grade")) {
					query = GET_ALL_STUDENTS_SORT_BY + "grade DESC;";
					prePivot = "grade";
					nextOrder = " ASC;";
				} else {
					query = GET_ALL_STUDENTS_SORT_BY + "student_id;";
					prePivot = "student_id";
					nextOrder = " DESC;";
				}
			}
			ps = connection.prepareStatement(query);
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

	public List<Student> getStudentsByName(String nameInput) {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Student> studentList = new ArrayList<>();
		try {
			ps = connection.prepareStatement(GET_STUDENTS_BY_NAME + nameInput + "%';");
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

	public List<Course> getCoursesStudentJoined(int studentId) {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Course> coursesList = new ArrayList<>();
		try {
			ps = connection.prepareStatement(GET_COURSES_A_STUDENT_JOINED);
			ps.setInt(1, studentId);
			rs = ps.executeQuery();
			while (rs.next()) {
				int classId = rs.getInt("class_id");
				String name = rs.getString("name");
				String lecturer = rs.getString("lecturer");
				int year = rs.getInt("year");
				String note = rs.getString("note");
				coursesList.add(new Course(classId, name, lecturer, year, note));
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

	public boolean deleteStudentByID(int studentId) {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		int rowChanged = 0;
		try {
			ps = connection.prepareStatement(DELETE_STUDENT_BY_ID);
			ps.setInt(1, studentId);
			rowChanged = ps.executeUpdate();
			
			ps2 = connection.prepareStatement(DELETE_REGISTER_RECORD_OF_STUDENT);
			ps2.setInt(1, studentId);
			rowChanged += ps2.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (ps2 != null) {
					ps2.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		if (rowChanged > 0) {
			return true;
		}
		return false;
	}

	public boolean addAStudent(String name, double grade, Date birthday, String address, String note) {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		int rowChanged = 0;
		try {
			ps = connection.prepareStatement(ADD_A_STUDENT);
			ps.setString(1, name);
			ps.setDouble(2, grade);
			ps.setDate(3, birthday);
			ps.setString(4, address);
			ps.setString(5, note);
			rowChanged = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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

		if (rowChanged > 0) {
			return true;
		}
		return false;
	}

	public Student getStudentByID(int studentId) {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student stu = null;
		try {
			ps = connection.prepareStatement(GET_A_STUDENT_BY_ID);
			ps.setInt(1, studentId);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("student_id");
				String name = rs.getString("name");
				double grade = rs.getDouble("grade");
				Date birthDay = rs.getDate("birthday");
				String address = rs.getString("address");
				String note = rs.getString("note");
				stu = new Student(id, name, grade, birthDay, address, note);
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
		return stu;
	}

	public boolean updateStudentByID(int studentId, String name, double grade, Date birthday, String address,
			String note) {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		int rowChanged = 0;
		try {
			ps = connection.prepareStatement(UPDATE_ROW_BY_ID);
			ps.setString(1, name);
			ps.setDouble(2, grade);
			ps.setDate(3, birthday);
			ps.setString(4, address);
			ps.setString(5, note);
			ps.setInt(6, studentId);
			rowChanged = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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
		if (rowChanged > 0)
			return true;
		return false;
	}

}
