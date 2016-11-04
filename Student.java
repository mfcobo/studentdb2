import java.io.Serializable;
public class Student implements Serializable{

    private String studentNumber;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private String course;
    private int yearLevel;
    private String crushName;
    private Course faveSubject;

    public Student(String studentNumber, String firstName, char middleInitial, String lastName, String course, int yearLevel, String crushName, Course faveSubject){
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.course = course;
        this.yearLevel = yearLevel;
        this.crushName = crushName;
        this.faveSubject = faveSubject;
    }
    public String getFirstName(){ return firstName; }
    public void setFirstName(String name){ firstName = name; }
    public String getStudentNumber() { return studentNumber; }
    public void setStudentNumber(String num) { studentNumber = num; }
    public char getMiddleInitial() { return middleInitial; }
    public void setMiddleInitial(char initial) { middleInitial = initial; }
    public String getLastName() { return lastName; }
    public void setLastName(String name) { lastName = name; }
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    public int getYearLevel() { return yearLevel; }
    public void setYearLevel(int yearLevel) { this.yearLevel = yearLevel; }
    public void setCrushName(String crushName){this.crushName = crushName;}
    public void setCourseCode(String courseCode){this.faveSubject.setCourseCode(courseCode);}
    public void setCourseDescription(String courseDescription){this.faveSubject.setCourseDescription(courseDescription);}

    public String toString() {
        return "Student Number: " + studentNumber + "\nName: " + lastName + "," + firstName + "," + middleInitial + "\nProgram: " + course +"\nYear Level: " + yearLevel + "\nCrush Name: " + crushName + "\nFavorite Subject: " + faveSubject;
    }
}