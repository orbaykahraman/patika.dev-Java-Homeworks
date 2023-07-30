package main;

import util.Grade;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateTranscript {

    Scanner scanner = new Scanner(System.in);
    public Transcript takeInputFromUser() {
        System.out.print("Enter Student Id : ");
        int studentId = scanner.nextInt();
        System.out.print("Enter Department : ");
        String courseDepartment = scanner.next();
        System.out.print("Enter Course Code : ");
        int courseCode = scanner.nextInt();
        System.out.print("Enter Course Credit : ");
        int courseCredit = scanner.nextInt();
        System.out.print("Enter Grade(0-4) : ");
        double gradeTaken = scanner.nextDouble();

        Transcript transcript = new Transcript(studentId);
        CourseGrade courseGrade = new CourseGrade(courseDepartment,courseCode,courseCredit);
        courseGrade.setGradeTaken(gradeTaken);
        transcript.addCourseTaken(courseGrade);

        return transcript;
    }

    public Transcript takeInputFromFile() {
        System.out.print("Enter filename: ");
        String fileName = "hw3/src/file/" + scanner.next() + ".txt";
        Transcript transcript;

        try {
            File file = new File(fileName);
            scanner = new Scanner(file);

            int studentId = Integer.parseInt(scanner.nextLine());
            transcript = new Transcript(studentId);

            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                String[] splittedLineArray = nextLine.split(" ");
                CourseGrade courseGrade = new CourseGrade(splittedLineArray[0],Integer.parseInt(splittedLineArray[1]),Integer.parseInt(splittedLineArray[2]));
                courseGrade.setGradeTaken(Double.parseDouble(splittedLineArray[3]));
                transcript.addCourseTaken(courseGrade);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            throw new RuntimeException(e);
        }
        return transcript;
    }

}
