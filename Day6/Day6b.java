package Day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day6b {

    List<String> allLines;

    public static void main(String[] args) {
        new Day6b();
    }

    Day6b() {

        readfile("input");

        String input = "";
        input = allLines.get(0);
//        input = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw";

        int messageLength = 14;
        int start = 0;

        String[] temp = new String[messageLength];
        boolean[] result = new boolean[messageLength];
        boolean resultFound = false;

        while (resultFound == false)
        {
            String workString = input.substring(start,start+messageLength);
            boolean globalTrue = true;
            for (int i = 0;i<=messageLength-1;i++)
            {
                temp[i] = workString.replace(workString.substring(i,i+1),"");
                if (temp[i].length() == messageLength-1)
                {
                    result[i] = true; // there is exactly 1 of this
                }
                else
                {
                    result[i] = false; // there are multiple of the same letter
                }
            }
            checkForLoop:
            for (int i = 0;i<messageLength-1;i++)
            {
                if (result[i] == false)
                {
                    globalTrue = false;
                    break checkForLoop;
                }
                else {
                    globalTrue = true;
                }
            }

            if (globalTrue== true)
            {
                resultFound = true;
            }
            else
            {
                start++;
            }
        }
        System.out.println(start+messageLength);
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
