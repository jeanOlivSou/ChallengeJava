package io.github.jeanolivsou.ChallengeJava;

import io.github.jeanolivsou.ChallengeJava.services.FileToObjectService;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ChallengeJava {
    public static void main(String[] args) throws FileNotFoundException {

        FileToObjectService file = new FileToObjectService();

        ArrayList list = file.ReadLineFromFile("data_1.txt");

        list.stream().forEach(System.out::println);

    }
}
