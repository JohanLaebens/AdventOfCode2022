package Day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day6 {

    List<String> allLines;

    public static void main(String[] args) {
        new Day6();
    }

    Day6() {

        readfile("input");
        String input = allLines.get(0);

//        String input = "mjqjpqmgbljsphdztnvjfqwrcgsmlb";
//        input = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw";

        int start = 0;
        String[] temp = new String[4];
        boolean resultFound = false;

        while (resultFound == false)
        {
            String workString = input.substring(start,start+4);

            for (int i = 0;i<=3;i++)
            {
                temp[i] = workString.replace(workString.substring(i,i+1),"");
            }
            if (temp[0].length() == 3 && temp[1].length() == 3 && temp[2].length() == 3 && temp[3].length() == 3) // this one is unique
            {
                System.out.println(workString);
                resultFound= true;
            }
            else
            {
                start++;
            }
        }
        System.out.println(start+4);
    }

    private  void readfile(String filename)
    {
        try {
            System.out.println(Paths.get(Paths.get(".").toAbsolutePath().normalize().toString() ));
            allLines = Files.readAllLines(Paths.get(Paths.get(".").toAbsolutePath().normalize().toString() + "\\Day6\\" + filename +".txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
