package Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1b {

    List<String> allLines;
    List<Integer> elves = new ArrayList<Integer>();

    public static void main(String[] args) {
        new Day1b();
    }

    Day1b() {
        readfile("input");

        int currentElf = 0;
        for (int i=0;i<allLines.size();i++)
        {
            if (!allLines.get(i).equals(""))
            {
                currentElf = currentElf+ Integer.parseInt(allLines.get(i));
            }
            else
            {
                elves.add(currentElf);
                currentElf=0;
            }
        }
        Collections.sort(elves);


        int top3elves = 0;
        for (int i= 1;i<=3;i++)
        {
            top3elves = top3elves + elves.get(elves.size()-i);
        }
        System.out.println("Top 3 elves: " + top3elves);

    }


    private  void readfile(String filename)
    {
        try {
            System.out.println(Paths.get(Paths.get(".").toAbsolutePath().normalize().toString() ));
            allLines = Files.readAllLines(Paths.get(Paths.get(".").toAbsolutePath().normalize().toString() + "\\Day1\\" + filename +".txt"));

//            for (String line : allLines) {
//                System.out.println(line);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
