package Day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day4b {

    List<String> allLines;

    public static void main(String[] args) {
        new Day4b();
    }

    Day4b() {
        readfile("input");
        int overlapping = 0;

        for (int i=0;i<allLines.size();i++) {
            String line = allLines.get(i);

            int startElf1 = Integer.parseInt(line.substring(0, line.indexOf("-")));
            int endElf1 = Integer.parseInt(line.substring(line.indexOf("-") + 1, line.indexOf(",")));

            line = line.substring(line.indexOf(",") + 1);

            int startElf2 = Integer.parseInt(line.substring(0, line.indexOf("-")));
            int endElf2 = Integer.parseInt(line.substring(line.indexOf("-") + 1));

            Boolean[] elf1 = new Boolean[100];
            Boolean[] elf2 = new Boolean[100];

            //set default to 0
            for (int j=0;j<elf1.length;j++)
            {
                elf1[j] = false;
                elf2[j] = false;
            }

            // fill out the array
            for (int j=startElf1;j<=endElf1;j++)
            {
                elf1[j] = true;
            }

            for (int j=startElf2;j<=endElf2;j++)
            {
                elf2[j] = true;
            }

            innerForLoop:
            for (int j=0;j<elf1.length;j++)
            {
                if (elf1[j] == true && elf2[j]==true) // are both marked?
                {
                    overlapping++;
                    break innerForLoop; // if one overlaps, that's enough
                }
            }
        }
        System.out.println("Overlapping  pair: " + overlapping);
    }


    private  void readfile(String filename)
    {
        try {
            System.out.println(Paths.get(Paths.get(".").toAbsolutePath().normalize().toString() ));
            allLines = Files.readAllLines(Paths.get(Paths.get(".").toAbsolutePath().normalize().toString() + "\\Day4\\" + filename +".txt"));

//            for (String line : allLines) {
//                System.out.println(line);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
