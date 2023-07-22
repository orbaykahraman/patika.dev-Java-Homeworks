package main;

import util.Grade;

import java.util.Arrays;
import java.util.List;

public class CourseGrade {

    private String courseDepartment;
    private int courseCode;
    private int courseCredit;
    private Grade gradeTaken;

    private List<String> departments = Arrays.asList("CENG","COMP","ECE","ME","MATH");
    public CourseGrade(String courseDepartment) {
       this(courseDepartment,100);
    }

    public CourseGrade(String courseDepartment, int courseCode) {
        this(courseDepartment,courseCode,4);
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit) {
        this(courseDepartment,courseCode,courseCredit,Grade.F);
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit, Grade gradeTaken) {
        setCourseDepartment(courseDepartment);
        setCourseCode(courseCode);
        setCourseCredit(courseCredit);
        setGradeTaken(gradeTaken);
    }

    public String getCourseDepartment() {
        return courseDepartment;
    }

    public void setCourseDepartment(String courseDepartment) {
        boolean isExist = false;
        if(courseDepartment.length() > 4) {
            this.courseDepartment = "CENG";
            return;
        }
        for(String x : departments) {
            if(courseDepartment.equalsIgnoreCase(x)) {
                isExist = true;
            }
        }
        if(!isExist) {
            this.courseDepartment = "CENG";
        }
        else {
            this.courseDepartment = courseDepartment;
        }
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        if(courseCode < 100 || courseCode > 599) {
            this.courseCode = 100;
        }
        else {
            this.courseCode = courseCode;
        }
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        if(courseCredit != 3) {
            this.courseCredit = 4;
        }
        else {
            this.courseCredit = 3;
        }
    }

    public Grade getGradeTaken() {
        return gradeTaken;
    }

    public void setGradeTaken(Grade gradeTaken) {
        this.gradeTaken = gradeTaken;
    }
    public void setGradeTaken(double val) {
        if(val < 0.0 || val > 4.0) {
            this.gradeTaken = Grade.F;
        }
        else {
            val = Math.round(val);
            int val1 = (int) val;
            switch (val1) {
                case 0 : this.gradeTaken = Grade.F;

                case 1 : this.gradeTaken = Grade.D;

                case 2 : this.gradeTaken = Grade.C;

                case 3 : this.gradeTaken = Grade.B;

                case 4 : this.gradeTaken = Grade.A;

            }
        }
    }

    @Override
    public String toString() {
        return "Department : " + courseDepartment + " CourseCode : " + courseCode + " Credit : " + courseCredit + " Grade : " + gradeTaken.getStringValue();
    }
}
