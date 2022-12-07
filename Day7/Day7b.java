package Day7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day7b {

    List<String> allLines;
    //List<String> directories = new ArrayList<>();
    ArrayList<ArrayList<String>> directories = new ArrayList<>();

    public static void main(String[] args) {
        new Day7b();
    }

    Day7b() {
       readfile("input");
        long startTime = System.nanoTime();

       String currentDir = "";

        // is the current line a command
        for (int i = 0;i<allLines.size();i++) {
//            System.out.println("CurrentLine: " + allLines.get(i));
            switch (allLines.get(i).substring(0,1)){
                case ("$"): // a command
                {
                    switch (allLines.get(i).substring(2,4)){
                        case ("cd"): // change directory
                            if (allLines.get(i).substring(allLines.get(i).lastIndexOf( " ")+1).equals( "..")) // going up 1 directory
                            {
                                currentDir = currentDir.substring(0,currentDir.lastIndexOf("/"));
                                if (currentDir.equals(""))
                                {
                                    currentDir = "/";
                                }
                            }
                            else // going into a new directory
                            {
                                if (currentDir.equals(""))
                                {
                                    currentDir = "/";
                                }
                                else
                                {
                                    if (currentDir.equals("/"))
                                    {
                                        currentDir = currentDir +  allLines.get(i).substring(allLines.get(i).lastIndexOf(" ") + 1);
                                    }
                                    else {
                                        currentDir = currentDir + "/" + allLines.get(i).substring(allLines.get(i).lastIndexOf(" ") + 1);
                                    }
                                }
                            }
                        break;
                        case ("ls"): // list files/directories
                            int countFileSize = 0;
                            boolean endOfListing = false;
                            // count all files till you get a command again
                                while (endOfListing==false)
                                {
                                    i++;
                                    String firstWord = "";
                                    if (i!=allLines.size()) { // end of file
                                         firstWord= allLines.get(i).substring(0, allLines.get(i).indexOf(" "));
                                    }

                                    if (firstWord.equals("$") || firstWord.equals("")) // we've reached the end of the listing or end of file (when firstword = "")
                                    {
                                        ArrayList<String> data = new ArrayList<>();
                                        data.add(currentDir);
                                        //data.add(countFileSize + "");
                                        data.add("0");
                                        directories.add(data);

//                                        System.out.println(currentDir + " " + countFileSize);

                                        boolean stillSomeParentDirectories = true;

                                        //String tempDir = currentDir.substring(0,currentDir.lastIndexOf("/")+1);
                                        String tempDir = currentDir;
                                        while (stillSomeParentDirectories == true)
                                        {
                                            innerFor:
                                            for (int j = 0;j<directories.size();)
                                            {
                                                if (directories.get(j).get(0).equals(tempDir))
                                                {
                                                    String temp2 = ""  + (Integer.parseInt(directories.get(j).get(1)) + countFileSize);
                                                    directories.get(j).remove(1);
                                                    directories.get(j).add(temp2);

                                                    int lengthOfFolderWithoutSlashes = tempDir.replaceAll("/","").length();

                                                    if (lengthOfFolderWithoutSlashes == 0) // only slash remained
                                                    {
                                                        tempDir = "";
                                                    }
                                                    else if (lengthOfFolderWithoutSlashes + 1 == tempDir.length()) // there is only 1 "folder"
                                                    {
                                                            tempDir = "/"; //only the root remains to be done
                                                    }
                                                    else
                                                    {
                                                        tempDir = tempDir.substring(0,tempDir.lastIndexOf("/"));
                                                    }

                                                    j = 0; // restart the loop
                                                    if (tempDir.equals(""))
                                                    {
                                                        stillSomeParentDirectories = false;
                                                        break innerFor;
                                                    }
                                                }
                                                else {
                                                    j++;
                                                }
                                            }
                                        }
                                        i--; // we still need this line to be processed, so we need to count 1 back to redo this line
                                        endOfListing = true;
                                    } else  if (!firstWord.equals("dir")) // it's a file and we can ignore directories
                                    {
                                     countFileSize = countFileSize + Integer.parseInt(firstWord);
                                    }
                                }
                        break;
                    }
                }

            }
        }

        // show all directories
//        int sumOfAllBelow100000 = 0;
//        for (int i = 0;i<directories.size();i++)
//        {
//            System.out.println(directories.get(i).get(0) + " " + directories.get(i).get(1));
//            if (Integer.parseInt(directories.get(i).get(1)) < 100000)
//            {
//                sumOfAllBelow100000 = sumOfAllBelow100000 + Integer.parseInt(directories.get(i).get(1));
//            }
//        }
//
//        System.out.println("SumOfAllBelow10000 : " + sumOfAllBelow100000);


        int FILESIZE_MAX = 70000000;
        int FILESIZE_NEEDED = 30000000;

        int CURRENTLY_AVAILABLE_SPACE = FILESIZE_MAX - Integer.parseInt(directories.get(0).get(1));
        int NEEDED_FREE_SPACE = FILESIZE_NEEDED -CURRENTLY_AVAILABLE_SPACE;

        int smallestDifferent = Integer.MAX_VALUE;

        for (int i = 0;i<directories.size();i++)
        {
            int CURRENT_DIR_SPACE = Integer.parseInt(directories.get(i).get(1));
            if (CURRENT_DIR_SPACE > NEEDED_FREE_SPACE)
            {
                if (CURRENT_DIR_SPACE < smallestDifferent)
                {
                    smallestDifferent = CURRENT_DIR_SPACE;
                }
            }
        }
        System.out.println("smallestDifferent : " + smallestDifferent);
        long endTime = System.nanoTime();
        System.out.println("Executed in " + ((endTime - startTime)/1000000) + " ms");  //divide by 1000000 to get milliseconds.

    }

    private  void readfile(String filename)
    {
        try {
            System.out.println(Paths.get(Paths.get(".").toAbsolutePath().normalize().toString() ));
            allLines = Files.readAllLines(Paths.get(Paths.get(".").toAbsolutePath().normalize().toString() + "\\Day7\\" + filename +".txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
