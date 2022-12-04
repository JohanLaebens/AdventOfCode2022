package Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day4 {

    List<String> allLines;

    public static void main(String[] args) {
        new Day4();
    }

    Day4() {
        readfile("input");
        int fullyOverlapping = 0;

        for (int i=0;i<allLines.size();i++) {
            String line = allLines.get(i);

            int startElf1 = Integer.parseInt(line.substring(0, line.indexOf("-")));
            int endElf1 = Integer.parseInt(line.substring(line.indexOf("-") + 1, line.indexOf(",")));

            line = line.substring(line.indexOf(",") + 1);

            int startElf2 = Integer.parseInt(line.substring(0, line.indexOf("-")));
            int endElf2 = Integer.parseInt(line.substring(line.indexOf("-") + 1));

            //is 2 fully within 1
            if ((startElf1 <= startElf2) && (endElf1 >= endElf2)) {
                fullyOverlapping++;
            } else if (((startElf2 <= startElf1) && (endElf2 >= endElf1))) {
                fullyOverlapping++;
            }

        }
        System.out.println("Number of Fully Overlapping: " + fullyOverlapping);
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
