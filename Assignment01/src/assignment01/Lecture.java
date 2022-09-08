package assignment01;

public class Lecture {
	private String day;
	private int time;
	private String lectureName;
	private String professor;
	private String roomNumber;
	private int enrolled;
	private int maxEnrolled;
	
	
	public Lecture()
	{
		/* write code */
		setLectureName("----");
		setProfessor("None");
		setRoomNumber("None");
	}
	
	public Lecture(String day, int time, String lectureName, String professor, String roomNumber, int maxEnrolled)
	{
		/* write code */
		setDay(day);
		setTime(time);
		setLectureName(lectureName);
		setProfessor(professor);
		setRoomNumber(roomNumber);
		setMaxEnrolled(maxEnrolled);
		this.enrolled = 0;
	}
	
	public Lecture(Lecture original) {
		if (original == null) {
			System.out.println("Fatal error");
			System.exit(0);
		}
		else {
			setDay(original.day);
			setTime(original.time);
			setLectureName(original.lectureName);
			setProfessor(original.professor);
			setRoomNumber(original.roomNumber);
			setMaxEnrolled(original.maxEnrolled);
			this.enrolled = original.enrolled;
		}
	}
	
	public String getDay() {
		/* write code */
		return this.day;		
	}

	public void setDay(String day) {
		/* write code */
		this.day = day;
	}

	public int getTime() {
		/* write code */
		return this.time;
	}

	public void setTime(int time) {
		/* write code */
		this.time = time;
	}

	public String getLectureName() {
		/* write code */
		return this.lectureName;
	}

	public void setLectureName(String lectureName) {
		/* write code */
		this.lectureName = lectureName;
	}

	public String getProfessor() {
		/* write code */
		return this.professor;
	}

	public void setProfessor(String professor) {
		/* write code */
		this.professor = professor;
	}

	public String getRoomNumber() {
		/* write code */
		return this.roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		/* write code */
		this.roomNumber = roomNumber;
	}
	
	public int getMaxEnrolled() {
		/* write code */
		return this.maxEnrolled;
	}
	
	public void setMaxEnrolled(int maxEnrolled) {
		/* write code */
		this.maxEnrolled = maxEnrolled;
	}
	public int getEnrolled() {
		/* write code */
		return this.enrolled;
	}
	public void incEnrolled() {
		/* write code */
		this.enrolled += 1;
	}
	public void decEnrolled() {
		/* write code */
		this.enrolled -= 1;
	}
	
	public boolean equals(Lecture s) {
		/* write code */
		if ((s.getLectureName() != "----") && this.lectureName.equals(s.getLectureName()) && this.professor.equals(s.getProfessor()) && this.roomNumber.equals(s.getRoomNumber()))
			return true;
		else
			return false;
	}

	public boolean checkLecture() {
		/* write code */
		return (this.enrolled < this.maxEnrolled);	
	}
	
}