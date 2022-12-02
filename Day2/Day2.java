package Day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day2 {

    List<String> allLines;

    public static void main(String[] args) {
        new Day2();
    }

    Day2() {
        readfile("input");
        int score = 0;

        int pointsWin = 6;
        int pointsDraw = 3;
        int pointsLose = 0;

        int pointsRock = 1;
        int pointsPaper = 2;
        int pointsScissors = 3;

        String ROCK = "ROCK";
        String PAPER = "PAPER";
        String SCISSORS = "SCISSORS";

        for (int i = 0;i<allLines.size();i++) {
            // the procedure of 1 round
            String PLAYER1 = allLines.get(i).substring(0, 1);
            String PLAYER2 = allLines.get(i).substring(2, 3);

            switch (PLAYER1) {
                case "A":
                    PLAYER1 = ROCK;
                    break;
                case "B":
                    PLAYER1 = PAPER;
                    break;
                case "C":
                    PLAYER1 = SCISSORS;
                    break;
            }
            switch (PLAYER2) {
                case "X":
                    PLAYER2 = ROCK;
                    break;
                case "Y":
                    PLAYER2 = PAPER;
                    break;
                case "Z":
                    PLAYER2 = SCISSORS;
                    break;
            }


            if (PLAYER2.equals(ROCK)) {
                score += pointsRock;

                if (PLAYER1.equals(ROCK)) {
                    score += pointsDraw;
                } else if (PLAYER1.equals(SCISSORS)) {
                    score += pointsWin;
                } else if (PLAYER1.equals(PAPER)) {
                    score += pointsLose;
                }
            } else if (PLAYER2.equals(PAPER)) {
                score += pointsPaper;

                if (PLAYER1.equals(PAPER)) {
                    score += pointsDraw;
                } else if (PLAYER1.equals(ROCK)) {
                    score += pointsWin;
                } else if (PLAYER1.equals(SCISSORS)) {
                    score += pointsLose;
                }

            } else if (PLAYER2.equals(SCISSORS)) {
                score += pointsScissors;

                if (PLAYER1.equals(SCISSORS)) {
                    score += pointsDraw;
                } else if (PLAYER1.equals(PAPER)) {
                    score += pointsWin;
                } else if (PLAYER1.equals(ROCK)) {
                    score += pointsLose;
                }
            }
        }

        System.out.println("Score: " + score);
    }


    private  void readfile(String filename)
    {
        try {
 //           System.out.println(Paths.get(Paths.get(".").toAbsolutePath().normalize().toString() ));
            allLines = Files.readAllLines(Paths.get(Paths.get(".").toAbsolutePath().normalize().toString() + "\\Day2\\" + filename +".txt"));

//            for (String line : allLines) {
//                System.out.println(line);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
