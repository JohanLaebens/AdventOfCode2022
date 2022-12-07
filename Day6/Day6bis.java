package Day6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day6bis {

    List<String> allLines;

    public static void main(String[] args) {
        new Day6bis();
    }

    Day6bis() {
        // same as Day6b but a bit optimised


        readfile("input");

        long startTime = System.nanoTime();

        String input = "";
        input = allLines.get(0);
      //  input = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw";

        int messageLength = 14;
        int start = 0;

        String[] temp = new String[messageLength];
        boolean resultFound = false;

        while (resultFound == false)
        {
            String workString = input.substring(start,start+messageLength);

            checkForLoop:
            for (int i = 0;i<=messageLength-1;i++)
            {
                temp[i] = workString.replace(workString.substring(i,i+1),"");
                if (temp[i].length() == messageLength-1)
                {
                    if (i==messageLength-1) // we ran through the entire message and found no duplicates
                    {
                        resultFound=true; // so we can escape the while
                    }
                }
                else
                {
                    start++; // move on to the next
                    break checkForLoop;
                }
            }
        }
        System.out.println(start+messageLength);
        long endTime = System.nanoTime();
        System.out.println("Executed in " + ((endTime - startTime)/1000000) + " ms");  //divide by 1000000 to get milliseconds.
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
