package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day3 {

    List<String> allLines;

    public static void main(String[] args) {
        new Day3();
    }

    Day3() {
        readfile("input");
        int score = 0;

        for (int i = 0;i<allLines.size();i++) {
            // for 1 line
            String firstPart = allLines.get(i).substring(0, allLines.get(i).length() / 2);
            String secondPart = allLines.get(i).substring(allLines.get(i).length() / 2);

            innerForLoop:
            for (int j = 0; j < (firstPart.length()); j++) {
                //find the letter which occurs in both
                if (secondPart.indexOf(firstPart.substring(j,j+1)) !=-1) // this means the letter is the second bag
                {
                   score+= convertLetterToPointsValue(firstPart.substring(j,j+1));
                   break innerForLoop;
                }
            }
        }

        System.out.println("Score: " + score);
    }

    private int convertLetterToPointsValue(String input) {
        char character = input.charAt(0);
        int ascii = (int) character;

        // is it a lowercase char?
        if (Character.isLowerCase(character)) {
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
