import main.CourseGrade;
import main.GenerateTranscript;
import main.Transcript;
import util.Grade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GenerateTranscript generateTranscript = new GenerateTranscript();
        List<Transcript> transcripts = new ArrayList<>();


        System.out.print("1-Generate Transcript From Input\n2-Generate Transcript From File\n3-Exit\n");
        System.out.print("Pick one of them: ");
        int choose = scanner.nextInt();
        int choose2 = 1;
        while (true) {
            if(choose == 1 && choose2 == 1) {
                transcripts.add(generateTranscript.takeInputFromUser());
                System.out.print("1-Generate Transcript From Input\n2-Exit\n");
                choose2 = scanner.nextInt();
            }
            else if(choose == 2) {
                Transcript transcript = generateTranscript.takeInputFromFile();
                System.out.println(transcript);
                break;
            }
            else if(choose == 3 || choose2 == 2) {
                for(Transcript t : transcripts) {
                    System.out.println(t);
                }
                break;
            }
        }

    }

}
