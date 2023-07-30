package main;

import java.util.ArrayList;
import java.util.List;

public class Transcript {
    public int studentId;
    public double GPA;

    List<CourseGrade> courseGradesList;

    public Transcript(int studentId) {
        this.studentId = studentId;
        this.GPA = 0.0;
        courseGradesList = new ArrayList<>();
    }

    public void addCourseTaken(CourseGrade courseGrade) {
        if(courseGrade == null) {
            System.out.println("Course grade can not be null");
        }

        else {
            courseGradesList.add(courseGrade);
            GPA = calculateGpa(courseGradesList);
        }
    }
    private double calculateGpa(List<CourseGrade> courseGradesList) {
        double listLenght = courseGradesList.size();
        double credits = 0;
        for(CourseGrade c : courseGradesList) {
            credits += c.getGradeTaken().getNumericValue();
        }
        return credits/listLenght;
    }

    private String printCourseGrades() {
        String result= "";
        for(CourseGrade c : courseGradesList) {
            result += "Department : " + c.getCourseDepartment() + " Code : " + c.getCourseCode() + " Credit : " + c.getCourseCredit() + " Grade : " + c.getGradeTaken();
            result += "\n";
        }
        return result;
    }
    @Override
    public String toString() {
        return "Student ID : " + studentId +  "\n" +printCourseGrades() + "GPA : " + GPA;
    }

}
