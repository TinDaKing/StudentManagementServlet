package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Course;
import model.Student;
import util.Connector;

public class CourseDAO {
	private static CourseDAO instance;

	public static CourseDAO getInstance() {
		if (instance == null) {
			instance = new CourseDAO();
		}
		return instance;
	}

	private CourseDAO() {
	}

	private static final String GET_ALL_COURSES = "SELECT * FROM studentmanagement.course;";
	private static final String GET_STUDENTS_OF_COURSE = "SELECT s.* FROM studentcourse c "
			+ "JOIN student s on c.student_id = s.student_id\r\n"
			+ "WHERE c.class_id=?;";
	private static final String GET_ALL_COURSES_SORT_BY = "SELECT * FROM studentmanagement.course " 
			+ "ORDER BY ";
	private static final String GET_COURSES_BY_NAME = "SELECT * FROM studentmanagement.course "
			+ "WHERE name LIKE '%";
	private static final String DELETE_COURSE_BY_ID = "DELETE FROM course WHERE class_id=?;";
	private static final String DELETE_REGISTER_RECORD_OF_COURSE = "DELETE FROM studentcourse "
			+ "WHERE class_id = ? ;";
	private static final String ADD_A_COURSE = "INSERT INTO course(name,lecturer,year,note) " + "VALUES (?,?,?,?);";
	private static final String GET_A_COURSE_BY_ID = "SELECT * FROM course WHERE class_id=?;";
	private static final String UPDATE_ROW_BY_ID = "UPDATE course "
			+ "SET name = ?, lecturer = ?, year = ?, note = ? " 
			+ "WHERE class_id = ?;";
	private String prePivot;
	private String nextOrder;

	public List<Course> getAllCourses() {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Course> courseList = new ArrayList<>();
		try {
			ps = connection.prepareStatement(GET_ALL_COURSES);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("class_id");
				String name = rs.getString("name");
				String lecturer = rs.getString("lecturer");
				int year = rs.getInt("year");
				String note = rs.getString("note");
				courseList.add(new Course(id, name, lecturer, year, note));
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

		return courseList;
	}

	public List<Course> getAllCoursesSortBy(String pivot) {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Course> courseList = new ArrayList<>();
		try {
			String query = "";
			if (prePivot != null && pivot.equals(prePivot)) {
				query = GET_ALL_COURSES_SORT_BY + prePivot + nextOrder;
				if (nextOrder == " DESC;")
					nextOrder = " ASC;";
				else
					nextOrder = " DESC;";
			} else {
				if (pivot.equals("name")) {
					query = GET_ALL_COURSES_SORT_BY + "name;";
					prePivot = "name";
					nextOrder = " DESC;";
				} else {
					query = GET_ALL_COURSES_SORT_BY + "class_id;";
					prePivot = "class_id";
					nextOrder = " DESC;";
				}
			}
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("class_id");
				String name = rs.getString("name");
				String lecturer = rs.getString("lecturer");
				int year = rs.getInt("year");
				String note = rs.getString("note");
				courseList.add(new Course(id, name, lecturer, year, note));
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

		return courseList;
	}

	public List<Course> getCoursesByName(String nameInput) {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Course> courseList = new ArrayList<>();
		try {
			ps = connection.prepareStatement(GET_COURSES_BY_NAME + nameInput + "%';");
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("class_id");
				String name = rs.getString("name");
				String lecturer = rs.getString("lecturer");
				int year = rs.getInt("year");
				String note = rs.getString("note");
				courseList.add(new Course(id, name, lecturer, year, note));
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

		return courseList;
	}

	public List<Student> getAllStudentsOfCourse(int courseId) {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Student> studentList = new ArrayList<>();
		try {
			ps = connection.prepareStatement(GET_STUDENTS_OF_COURSE);
			ps.setInt(1, courseId);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("student_id");
				String name = rs.getString("name");
				double grade = rs.getDouble("grade");
				Date birthday = rs.getDate("birthday");
				String address = rs.getString("address");
				String note = rs.getString("note");
				studentList.add(new Student(id, name, grade, birthday, address, note));
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

	public boolean deleteCourseByID(int courseId) {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		int rowChanged = 0;
		try {
			ps = connection.prepareStatement(DELETE_COURSE_BY_ID);
			ps.setInt(1, courseId);
			rowChanged = ps.executeUpdate();
			
			ps2 = connection.prepareStatement(DELETE_REGISTER_RECORD_OF_COURSE);
			ps2.setInt(1, courseId);
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

	public boolean addACourse(String name, String lecturer, int year, String note) {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		int rowChanged = 0;
		try {
			ps = connection.prepareStatement(ADD_A_COURSE);
			ps.setString(1, name);
			ps.setString(2, lecturer);
			ps.setInt(3, year);
			ps.setString(4, note);
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

	public Course getCourseByID(int courseId) {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Course cou = null;
		try {
			ps = connection.prepareStatement(GET_A_COURSE_BY_ID);
			ps.setInt(1, courseId);
			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("class_id");
				String name = rs.getString("name");
				String lecturer = rs.getString("lecturer");
				int year = rs.getInt("year");
				String note = rs.getString("note");
				cou = new Course(id, name, lecturer, year, note);
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
		return cou;
	}

	public boolean updateCourseByID(int courseId, String name, String lecturer, int year, String note) {
		Connection connection = Connector.makeConnection();
		PreparedStatement ps = null;
		int rowChanged = 0;
		try {
			ps = connection.prepareStatement(UPDATE_ROW_BY_ID);
			ps.setString(1, name);
			ps.setString(2, lecturer);
			ps.setInt(3, year);
			ps.setString(4, note);
			ps.setInt(5, courseId);
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
