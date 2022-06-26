package io.github.jeanolivsou.ChallengeJava.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileToObjectService {
    public ArrayList<String> ReadLineFromFile(String fileName) throws FileNotFoundException {

        String dir = "data/";

        File file = new File(dir+fileName);

        Scanner read = new Scanner(file);

        String line = read.nextLine();

        String[] splitList = line.split("(\\s{2,}\\s)|(0{2,})");

        ArrayList<String> lineList = new ArrayList<>();
        System.out.println(Arrays.stream(splitList).toList());
        lineList.add(splitList[1]);
        lineList.add(splitList[2]);
        lineList.add(splitList[3]);
        lineList.add(splitList[4]);
        lineList.add(splitList[5].substring(0,(splitList[5].length() - 8)));
        lineList.add(splitList[5].substring((splitList[5].length() - 8)));

        return lineList;
    }
}
