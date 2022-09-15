# **Programming Assignment #1**

### **Goal:**
Create a **timetable application** for students' use
- Days: Mon-Fri
- Period: 1-10

<br/>

`Class` Lecture
- private String day
- private int time
- private String lectureName
- private String professor
- private String roomNumber
- private int enrolled
- private int maxEnrolled
- public Lecture()
    - constructor that initializes variables lectureName = "----", professor = "None", and roomNumber = "None"
- public Lecture(String day, int time, String lectureName, String professor, String roomNumber, int maxEnrolled)
    - constructor which takes parameters to initialize variables
    - value of enrolled is initialized to O
- declare accessor & mutator for each variable
- public boolean equals(Lecture s) --> check if they are the same class
    - compare lectureName, professor, roomNumber
- public void incEnrolled()
    - increase enrolled by 1
- public void decEnrolled()
    - decrease enrolled by 1
- public boolean checkLecture() -- > check whether lecture can be added or not
    - check name of lecture if it is "----"

<br/>

`Class` Student
- private String studentName
- private int studentCode
- Lecture timetable[][] = new Lecture[10][5] 
- public enum DAYS
    - Monday to Friday
- public Student()
    - constructor that initialized all timetables
- public Student(String studentName , int studentCode)
    - constructor that takes given parameters to initialize timetable when called
- declare accessor & mutator of each variable
- public void setScheduleInformation(Lecture lecture)
    - when the max capacity is not exceeded, add lecture (taken as argument) into timetable
    - call the checkLecture() method from class Lecture to check whether the lecture can be added
    - use DAYS to access 2D array index of timetable
    - increase current enrolled students by 1
- public String showTimetable()
    - return student's timetable as String type
    - use DAYS
    - only print name of lecture
    - use nested loop
- public boolean equals(Student stu)
    - compare the timetable of student taken from argument and timetable from method
    - call equals method of class Lecture
    - method used to compare students' timetable
- public void deleteSchedule(String day, int period)
    - reduce enrolled students of lecture with this day and period by 1
    - erase lecture of day(String) and period(int) -> change to default state
- public Calendar setInputDate()
    - use Calendar class
    - take input of year, month, day from keyboard and return object of class Calendar 
- public String oneDaySchedule(String day)
    - return only the timetable of the day taken as argument as String type 
    - return only day and lecture name

<br/>

`Class` TimeTableApp
- `main` method
    - 10 lectures are initialized
    - take number of students as input and take names and student numbers using Scanner
    - construct main menu by using infinity loop
- **Case 1:** Create student's timetable
    - take the student number of the student (to make a timetable) as input and show the lectures that can be enrolled. when the lecture number is taken as input, add the lecture into timetable
    - call setScheduleInformation() method
    - when a lecture with max capacity of 5 already has 5 enrolled students print the following output (max capacity reached)
- **Case 2:** Print the number of students enrolled in a certain lecture
    - take lecture name as input and print the number of students enrolled in the class
    - use Lecture array
- **Case 3:** Compare students' timetables
    - take the student number of 2 students as input and compare their timetables
    - use equals() method of Student class
- **Case 4:** Erase student's timetable
    - take student number of student as input
    - take the day and time of lecture to be erased as input
    - call deleteSchedule() method of Student class
    - after deleting, call the showTimetable() method of Student class and print the timetable
- **Case 5:** Print student's timetable
    - take student number of student as input and print the student's timetable
    - call showTimeTable() method of Student class
- **Case 6:** Print timetable of a certain day
    - take student number of student and year month date as input and print only the timetable of that day
    - call setInputDate() of Student class and save the date's information 
    - call oneDaySchedule() method and print the timetable of that date
- **Case 7:** End program
- **default**
    - print "Try again" message and print menu selection page
- private static void showClass()
    - method tht prints the current lectures tht can be added

<br/>

Calendar class
- Calendar class is a abstract class provided by Java to handle date and time 
- includes various field and methods
- to use Calendar class, import it using java.util.Calendar