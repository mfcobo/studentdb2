import java.io.Serializable;

/**
 * Created by mfcobo on 11/4/16.
 */
public class Course implements Serializable {
    private String courseCode;
    private String courseDescription;

    public Course(String courseCode,String courseDescription) {
        this.courseCode = courseCode;
        this.courseDescription = courseDescription;
    }
    public void setCourseCode(String courseCode){this.courseCode = courseCode;}
    public void setCourseDescription(String courseDescription){this.courseDescription = courseDescription;}

    @Override
    public String toString() {
        return  "Course Code = " + courseCode +
                "\n\t\t   Course Description = " + courseDescription + "\n";
    }
}