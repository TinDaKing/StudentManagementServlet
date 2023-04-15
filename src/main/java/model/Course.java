package model;

public class Course {
	private int id;
	private String name;
	private String lecturer;
	private int year;
	private String note;

	
	public Course(int id, String name, String lecturer, int year, String note) {
		super();
		this.id = id;
		this.name = name;
		this.lecturer = lecturer;
		this.year = year;
		this.note = note;
	}
	
	public Course(int id, String name, String lecturer, int year) {
		super();
		this.id = id;
		this.name = name;
		this.lecturer = lecturer;
		this.year = year;
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", lecturer=" + lecturer + ", year=" + year + ", note=" + note
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
