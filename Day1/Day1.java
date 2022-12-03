package Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day1 {

    List<String> allLines;

    public static void main(String[] args) {
        new Day1();
    }

    Day1() {
        readfile("");

        int currentElf = 0;
        int maxCarryingElf = 0;
        for (int i=0;i<allLines.size();i++)
        {
            if (!allLines.get(i).equals(""))
            {
                currentElf = currentElf+ Integer.parseInt(allLines.get(i));
            }
            else
            {
                if (currentElf > maxCarryingElf)
                {
                    maxCarryingElf = currentElf;
                    System.out.println("CurrentElf: "+ currentElf);
                }
                currentElf=0;
            }
        }
        System.out.println(maxCarryingElf);
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
