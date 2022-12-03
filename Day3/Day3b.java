package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day3b {

    List<String> allLines;

    public static void main(String[] args) {
        new Day3b();
    }

    Day3b() {
        readfile("input");
        int score = 0;

        for (int i = 0;i<allLines.size();) {
            System.out.print(i + " ");
            // add 3 lines into 1 string
            char abc = findLetterWhichOccurs3Times(allLines.get(i),allLines.get(i+1),allLines.get(i+2));

            score+=convertLetterToPointsValue(abc);
            i=i+3;
        }

        System.out.println("Score: " + score);
    }

    private char findLetterWhichOccurs3Times(String elf1, String elf2, String elf3) {
        for (int i=0;i<elf1.length();i++)
        {
            char searchForChar = elf1.charAt(i);

            if (elf2.indexOf(searchForChar) !=-1 && elf3.indexOf(searchForChar) !=-1)
                {
                    System.out.println(i + " " + searchForChar);
                    return searchForChar;
            }
        }
        return elf1.charAt(0);
    }

    private int convertLetterToPointsValue(char input) {
       // char character = input.charAt(0);
        int ascii = (int) input;

        // is it a lowercase char?
        if (Character.isLowerCase(input)) {
            return ascii - 96;
        }
        else //it's an uppercase char
        {
            return ascii - 38;
        }
    }


    private  void readfile(String filename)
    {
        try {
 //           System.out.println(Paths.get(Paths.get(".").toAbsolutePath().normalize().toString() ));
            allLines = Files.readAllLines(Paths.get(Paths.get(".").toAbsolutePath().normalize().toString() + "\\Day3\\" + filename +".txt"));

//            for (String line : allLines) {
//                System.out.println(line);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
