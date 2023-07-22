import main.CourseGrade;
import main.Transcript;
import util.Grade;

public class Main {
    public static void main(String[] args) {
        Transcript transcript = new Transcript(111);
        CourseGrade grade = new CourseGrade("ECE"); // ece , 100 , 4 , F
        CourseGrade grade1 = new CourseGrade("BUS",202,2, Grade.A); // ceng , 202 , 4 , B
        CourseGrade grade2 = new CourseGrade("COMP",201,3,Grade.C);

        transcript.addCourseTaken(grade);
        transcript.addCourseTaken(grade1);
        transcript.addCourseTaken(grade2);

        System.out.println(transcript);

    }

}
