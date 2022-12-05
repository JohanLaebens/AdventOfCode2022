package Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day5 {

    List<String> allLines;
    List<String> allStacks;
    String[] stacks = null;

    public static void main(String[] args) {
        new Day5();
    }

    Day5() {
        // I split up the files so there is a file with start stacks && the moves
        String intputOrExample = "input";
        readfile(intputOrExample);

        // process the files
        String contentOfLastLine = allStacks.get(allStacks.size()-1);
        int numberOfStacks = Integer.parseInt(contentOfLastLine.substring(contentOfLastLine.lastIndexOf(" ")+1));

        stacks = new String[numberOfStacks+1];

        for (int i = 0;i<stacks.length;i++)
        {
            stacks[i] = "";
        }

        for (int j = 1; j<numberOfStacks+1;j++) {
            int startPosition = -3 + (j*4);
            for (int i = allStacks.size(); i > 1; i--) {
                stacks[j] = stacks[j] + allStacks.get(allStacks.size() - i).substring(startPosition,startPosition+1);
            }
            stacks[j] = reverseList(stacks[j]).trim();
        }


     // process the moving
     for (int i = 0;i<allLines.size();i++)
     {
         int howManyCrates = 0;
         int fromStack = 0;
         int toStack = 0;

         String currentProcessingLine = allLines.get(i);
         howManyCrates = Integer.parseInt(currentProcessingLine.substring(currentProcessingLine.indexOf(" ")+1,currentProcessingLine.indexOf(" from ")));
         fromStack = Integer.parseInt(currentProcessingLine.substring(currentProcessingLine.indexOf(" from ")+6,currentProcessingLine.indexOf(" to ")));
         toStack = Integer.parseInt(currentProcessingLine.substring(currentProcessingLine.indexOf(" to ")+4));

         String blocksToMove = stacks[fromStack].substring(stacks[fromStack].length()-howManyCrates);
         blocksToMove = reverseList(blocksToMove);

         stacks[toStack] = stacks[toStack] + blocksToMove; // move to ToStack
         stacks[fromStack] = stacks[fromStack].substring(0,stacks[fromStack].length()-howManyCrates); // remove from fromStrack

     }

     // read the top crates
        String solution = "";
        for (int i = 1;i<stacks.length;i++) {
            solution = solution + stacks[i].substring(stacks[i].length()-1);
        }
        System.out.println("SOLUTION: " + solution);
    }

    private String reverseList(String blocksToMove) {
        String temp = "";
        int size = blocksToMove.length();
        for (int i = 0;i<size;i++)
        {
            temp = temp+ blocksToMove.substring(blocksToMove.length()-1);
            blocksToMove = blocksToMove.substring(0,blocksToMove.length()-1);
        }
        return  temp;
    }

    private  void readfile(String filename)
    {
        try {
            System.out.println(Paths.get(Paths.get(".").toAbsolutePath().normalize().toString() ));
            allLines = Files.readAllLines(Paths.get(Paths.get(".").toAbsolutePath().normalize().toString() + "\\Day5\\" + filename +".txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(Paths.get(Paths.get(".").toAbsolutePath().normalize().toString() ));
            allStacks = Files.readAllLines(Paths.get(Paths.get(".").toAbsolutePath().normalize().toString() + "\\Day5\\" + filename +"Stack.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
