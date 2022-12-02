package Day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day2b {

    List<String> allLines;

    public static void main(String[] args) {
        new Day2b();
    }

    Day2b() {
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

        String DRAW = "DRAW";
        String LOSE = "LOSE";
        String WIN = "WIN";

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
                    PLAYER2 = LOSE;
                    break;
                case "Y":
                    PLAYER2 = DRAW;
                    break;
                case "Z":
                    PLAYER2 = WIN;
                    break;
            }


            if (PLAYER2.equals(WIN)) {
                score += pointsWin;

                if (PLAYER1.equals(ROCK)) {
                    score += pointsPaper;  // I need to draw paper to win
                } else if (PLAYER1.equals(SCISSORS)) {
                    score += pointsRock; // I need to draw rock to win
                } else if (PLAYER1.equals(PAPER)) {
                    score += pointsScissors; // I need to draw scissors to win
                }
            } else if (PLAYER2.equals(DRAW)) {
                score += pointsDraw;

                if (PLAYER1.equals(ROCK)) {
                    score += pointsRock;  // I need to draw rock to draw
                } else if (PLAYER1.equals(SCISSORS)) {
                    score += pointsScissors; // I need to draw scissors to draw
                } else if (PLAYER1.equals(PAPER)) {
                    score += pointsPaper; // I need to draw paper to draw
                }

            } else if (PLAYER2.equals(LOSE)) {
                score += pointsLose;

                if (PLAYER1.equals(ROCK)) {
                    score += pointsScissors;  // I need to draw rock to lose
                } else if (PLAYER1.equals(SCISSORS)) {
                    score += pointsPaper; // I need to draw scissors to lose
                } else if (PLAYER1.equals(PAPER)) {
                    score += pointsRock; // I need to draw paper to lose
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
