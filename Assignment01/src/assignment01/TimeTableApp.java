package assignment01;

import java.util.Calendar;
import java.util.Scanner;

public class TimeTableApp {
	public static void main(String[] args) {
		Lecture lecture[] = new Lecture[10];
		lecture[0] = new Lecture("MONDAY", 1, "OOP", "mr.park", "ITBT808", 20);
		lecture[1] = new Lecture("TUESDAY", 2, "Security", "mr.park", "ITBT816", 20);
		lecture[2] = new Lecture("WEDNESDAY", 1, "Data Structure", "mr.park", "ITBT808", 25);
		lecture[3] = new Lecture("THURSDAY", 6, "Network", "mr.yang", "ITBT503", 20);
		lecture[4] = new Lecture("FRIDAY", 9, "Computer Architecture", "mr.han", "ITBT507", 20);
		lecture[5] = new Lecture("TUESDAY", 5, "Digital Logic", "mr.kim", "ITBT401", 15);
		lecture[6] = new Lecture("WEDNESDAY", 2, "OS", "mr.yoon", "ITBT606", 15);
		lecture[7] = new Lecture("THURSDAY", 3, "C-language", "mr.choi", "ITBT503", 20);
		lecture[8] = new Lecture("FRIDAY", 6, "Python", "mr.han", "ITBT504", 15);
		lecture[9] = new Lecture("TUESDAY", 9, "Ski-Board", "mr.kang", "ITBT404", 5);

		Scanner keyboard = new Scanner(System.in);
		Scanner scan = new Scanner(System.in);
		String[] weeks = { "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };
		Calendar cal = Calendar.getInstance();
		/* u can define variables */
		int enter = 0;
		int studentNum = 0;
		String studentName = "";
		int i = 0;
		int studentIndex = 0;
		int studentTotal = 0;
		Student student[] = new Student[100];
		TimeTableApp thisApp = new TimeTableApp();
				
		/* write code */
		
		//initialize student array
		for (i = 0; i < 100; i++) {
			student[i] = new Student("", 0);
		}
		
		System.out.println("학생수를 입력하세요");
		studentTotal = keyboard.nextInt();
		
		for(i = 0; i < studentTotal; i++)
		{ // new students
			studentIndex = i + 1; 
			
			System.out.println(studentIndex + " 학생의 이름을 입력하세요");
			studentName = keyboard.next();
			
			do {
				System.out.println(studentIndex + " 학생의 학번을 입력하세요");
				studentNum = keyboard.nextInt();
				if (studentNum > 0) {
					break;
				}
			} while (studentNum <= 0);
						
			student[studentIndex] = new Student(studentName, studentNum);
		}
		System.out.println();
		
		do {
			/* write code */
			System.out.println("학생의 시간표를 입력하려면 1번 누르세요");
			System.out.println("특정과목을 수강하는 학생수를 출력하려면 2번을 누르세요");
			System.out.println("학생들의 시간표를 비교하려면 3번을 누르세요");
			System.out.println("학생의 시간표를 지우려면 4번을 누르세요");
			System.out.println("시간표를 출력하려면 5번을 누르세요");
			System.out.println("해당 학생의 특정 날짜 시간표를 출력하려면 6번을 누르세요");
			System.out.println("프로그램을 종료하려면 7번을 누르세요");
			
			enter = keyboard.nextInt();
			
			switch (enter) {
			case 1:
				/* write code */
				int lectNum = 0;
				
				do {
					System.out.println("시간표를 입력할 학생의 학번을 입력하세요");
					studentNum = keyboard.nextInt();
					if (studentNum > 0) {
						break;
					}
				} while (studentNum <= 0);
				
				studentIndex = thisApp.ifStudentExist(student, studentNum);
				
				if (studentIndex == 0) { 
					System.out.println("입력된 학번은 등록되지 않은 학번입니다\n");
					break;
				}
				
				do {
					System.out.println("다음 중 추가할 시간표의 번호를 입력하세요 (1~10)");
					showClass();
					lectNum = keyboard.nextInt();
					if (lectNum > 0 && lectNum < 11)
						break;
				} while (lectNum <= 0 || lectNum > 10);
				
				if (lecture[lectNum - 1].checkLecture()) {
					student[studentIndex].setScheduleInformation(lecture[lectNum - 1]);
					System.out.println("시간이 정상적으로 추가되었습니다\n");
				}
				else
					System.out.println("강의를 추가할 수 없습니다. : 최대 수강 인원 초과\n");
				
				break;
							
			case 2:
				/* write code */
				int valid = 0;
				
				System.out.println("과목의 이름을 입력하세요 (eg. oop)");
				String className = scan.nextLine();	
				className = className.trim();
				
				for (i = 0; i < 10; i++) {
					if (lecture[i].getLectureName().equalsIgnoreCase(className)) {
						System.out.println(lecture[i].getLectureName() + " 과목을 수강하는 학생의 수는 " + lecture[i].getEnrolled() + '\n');
						valid = 1;
						break;
					}
				}
				
				if (valid == 0) 
					System.out.println("입력된 과목이 존재하지 않습니다\n");
				
				break;
				
			case 3:
				/* write code */
				int studentNum2 = 0;
				int studentIndex2 = 0;
				
				do { // 1st student code
					System.out.println("시간표를 비교할 첫번째 학생의 학번을 입력하세요");
					studentNum = keyboard.nextInt();
					if (studentNum > 0) {
						break;
					}
				} while (studentNum <= 0);
				
				studentIndex = thisApp.ifStudentExist(student, studentNum);
				if (studentIndex == 0) { 
					System.out.println("입력된 학번은 등록되지 않은 학번입니다\n");
					break;
				}
				
				do { // 2nd student code
					System.out.println("두번째 학생의 학번을 입력하세요");
					studentNum2 = keyboard.nextInt();
					if (studentNum2 > 0) {
						break;
					}
				} while (studentNum2 <= 0);
				
				studentIndex2 = thisApp.ifStudentExist(student, studentNum2);
				if (studentIndex2 == 0) { 
					System.out.println("입력된 학번은 등록되지 않은 학번입니다\n");
					break;
				}
				
				if (student[studentIndex].equals(student[studentIndex2]))
					System.out.println("두 학생의 시간표는 같습니다\n");
				else
					System.out.println("두 학생의 시간표는 다릅니다\n");	
				
				break;
				
			case 4:
				/* write code */
				String delDay = "";
				int delTime = 0;
				
				do {
					System.out.println("시간표를 삭제할 학생의 학번을 입력하세요");
					studentNum = keyboard.nextInt();
					if (studentNum > 0) {
						break;
					}
				} while (studentNum <= 0);
				
				studentIndex = thisApp.ifStudentExist(student, studentNum);
				if (studentIndex == 0) { 
					System.out.println("입력된 학번은 등록되지 않은 학번입니다\n");
					break;
				}
				else {
					do {
						System.out.println("지울 시간표의 요일을 입력하세요 (eg. monday)");
						delDay = keyboard.next();
						if (!delDay.isEmpty()) {
							delDay = delDay.toUpperCase();
							break;
						}
					} while (delDay.isEmpty());
					
					do {
						System.out.println("지울 시간표의 시간을 입력하세요 (1~10)");
						delTime = keyboard.nextInt();
						if (delTime > 0 && delTime < 11) {
							break;
						}
					} while (delTime <= 0 && delTime > 10);
									
					student[studentIndex].deleteSchedule(delDay, delTime);
					System.out.println();
					for (i = 0; i < 10; i++) {
						if (lecture[i].getDay().equals(delDay) && lecture[i].getTime() == delTime)
							lecture[i].decEnrolled();		
					}
				} // else
				System.out.println(student[studentIndex].showTimetable());
				break;

			case 5:
				/* write code */
				do {
					System.out.println("시간표를 출력할 학생의 학번을 입력하세요");
					studentNum = keyboard.nextInt();
					if (studentNum > 0) {
						break;
					}
				} while (studentNum <= 0);

				studentIndex = thisApp.ifStudentExist(student, studentNum);
				if (studentIndex == 0) { 
					System.out.println("입력된 학번은 등록되지 않은 학번입니다\n");
					break;
				}
				
				System.out.println(student[studentIndex].showTimetable());
				
				break;
				
			case 6:
				/* write code */
				String newDate = "";
				
				do {
					System.out.println("시간표를 출력할 학생의 학번을 입력하세요");
					studentNum = keyboard.nextInt();
					if (studentNum > 0) {
						break;
					}
				} while (studentNum <= 0);
				
				studentIndex = thisApp.ifStudentExist(student, studentNum);
				if (studentIndex == 0) { 
					System.out.println("입력된 학번은 등록되지 않은 학번입니다\n");
					break;
				}
								
				do {
					System.out.println("Enter the date (YYYYMMDD)");
					newDate = keyboard.next();
					if (newDate.length() == 8) {
						break;
					}
				} while (newDate.length() != 8);
				
				cal = student[studentIndex].setInputDate(newDate);
				int whichDay = cal.get(Calendar.DAY_OF_WEEK) - 1;
				
				System.out.println(student[studentIndex].oneDaySchedule(weeks[whichDay]));
				
				break;
				
			case 7:
				/* write code */
				System.exit(0);
				break;

			default:
				/* write code */
				System.out.println("Try again\n");
				break;
			} // do

		} while (true);
	} // main

	private static void showClass() {
		/* write code */
		System.out.println();
		System.out.println("(1) OOP - 월요일 - 1교시");
		System.out.println("(2) Security - 화요일 - 2교시");
		System.out.println("(3) Data Structure - 수요일 - 1교시");
		System.out.println("(4) Network - 목요일 - 6교시");
		System.out.println("(5) Computer Architecture - 금요일 - 9교시");
		System.out.println("(6) Digital Logic - 화요일 - 5교시");
		System.out.println("(7) OS - 수요일 - 2교시");
		System.out.println("(8) C-language - 목요일 - 3교시");
		System.out.println("(9) Python - 금요일 - 6교시");
		System.out.println("(10) Ski-Board - 화요일 - 9교시");
		System.out.println();
	}
	
	public int ifStudentExist(Student[] student, int stuCode) {
		int i, diff;
		
		for (i = 0; i < student.length; i++) {
			diff = Integer.compare(stuCode, student[i].getCode());
			if (diff == 0) {return i;}
		}
		
		return 0;
	}
}
