package assignment01;

import java.util.Calendar;
import java.util.Scanner;

public class Student {
	private String studentName;
	private int studentCode;
	Lecture timeTable[][] = new Lecture[10][5];

	public enum DAYS {
		/* write code */
		MONDAY,
		TUESDAY,
		WEDNESDAY, 
		THURSDAY, 
		FRIDAY;
	}

	public Student() {
		/* write code */
		this.studentName = "None";
		this.studentCode = 0;
		
		for (int a = 0; a < 10; a++) {
			for (int b = 0; b < 5; b++) {
				this.timeTable[a][b] = new Lecture();
			}
		}
	}

	public Student(String studentName, int studentCode) {
		/* write code */
		setStudentName(studentName);
		setStudentCode(studentCode);
		this.timeTable = new Lecture[10][5];
	}

	public String getStudentName() {
		/* write code */
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		/* write code */
		this.studentName = studentName;
	}

	public int getStudentCode() {
		/* write code */
		return this.studentCode;
	}

	public void setStudentCode(int studentCode) {
		/* write code */
		this.studentCode = studentCode;
	}

	public void setScheduleInformation(Lecture lecture) {
		/* write code */
		if (lecture.checkLecture()) {
			int lectureDay = DAYS.valueOf(lecture.getDay()).ordinal();
			this.timeTable[lecture.getTime() - 1][lectureDay] = new Lecture(lecture);
			lecture.incEnrolled();
		}
	}
	
	public String showTimetable() {
		/* write code */
		DAYS[] weekday = DAYS.values();
		System.out.print("  ");
		for (int g = 0; g < 5; g++) {
			System.out.printf("%22s",weekday[g]);
		}
		System.out.println();
		
		for (int m = 0; m < 10; m++) {
			for (int n = 0; n < 6; n++) {
				if (n == 0) {
					System.out.printf("%2d", m + 1);
				}
				else {
					if (this.timeTable[m][n - 1] != null)
						System.out.printf("%22s",this.timeTable[m][n - 1].getLectureName());
					else {
						String empty = "----";
						System.out.printf("%22s", empty);
					}
				}
			}
			System.out.println();
		}
		return ("");
	}

	public boolean equals(Student stu) {
		/* write code */
		int anyDiff = 0;
		
		for (int e = 0; e < 10; e++) {
			for (int f = 0; f < 5; f++) {
				if (this.timeTable[e][f] != null && stu.timeTable[e][f] != null && !this.timeTable[e][f].equals(stu.timeTable[e][f])) {
					anyDiff = 1;
					break;
				}
				else if ((this.timeTable[e][f] != null && stu.timeTable[e][f] == null) || (this.timeTable[e][f] == null && stu.timeTable[e][f] != null)) {
					anyDiff = 1;
					break;
				}
			} // for f
			if (anyDiff > 0) {break;}
		} //for e
		
		if (anyDiff > 0) 
			return false;
		else 
			return true; 
	}
	
	public void deleteSchedule(String day, int period)
	{
		/* write code */
		int lectureDay = DAYS.valueOf(day).ordinal();
		if (this.timeTable[period - 1][lectureDay] != null) {
			this.timeTable[period - 1][lectureDay].decEnrolled();
			this.timeTable[period - 1][lectureDay] = new Lecture();
		}
		
	}
	
	public Calendar setInputDate(String dateStr)
	{
		/* write code */
		Calendar cal = Calendar.getInstance();
		
		int date, month, year;
				
		year = Integer.parseInt(dateStr.substring(0,4));
		month = Integer.parseInt(dateStr.substring(4,6));
		date = Integer.parseInt(dateStr.substring(6,8));
		month -= 1;
		
		cal.set(year, month, date);
				
		return cal;
	}
	
	public String oneDaySchedule(String day) {
		/* write code */
		int lectureDay = DAYS.valueOf(day).ordinal();
		
		System.out.println("\n" + DAYS.valueOf(day).toString());
		for (int period = 0; period < 10; period++) {
			if (this.timeTable[period][lectureDay] != null)
				System.out.println(this.timeTable[period][lectureDay].getLectureName());
			else
				System.out.println("----");
		}

		return ("");
	}
	
	public int getCode() {
		return this.studentCode;
	}

}
