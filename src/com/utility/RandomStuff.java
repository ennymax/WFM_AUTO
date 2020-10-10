package com.utility;

import org.apache.commons.lang.RandomStringUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomStuff {
    private static Random rand = new Random();
    public long RandomNumbers() {
        LocalDateTime date = LocalDateTime.now();
        long seconds;
        seconds = Duration.between(date.withSecond(0).withMinute(0).withHour(0), date).getSeconds();
        System.out.println(seconds);
        return seconds;
    }

    public String RandomWords() {
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
        return generatedString;
    }


    public String ListRandom() {

        String fileName = System.getProperty("user.dir") + "\\Config\\words.txt";
        File wordList = new File(fileName);
        List<String> words = new ArrayList<>();
        Scanner reader = null;

        try {
            reader = new Scanner(wordList);
        } catch (FileNotFoundException e) {
            System.out.println("file \"" + fileName + "\" not found");
            System.exit(0);
        }

        while (reader.hasNextLine()) {
            String word = reader.nextLine();
            words.add(word);
        }

        int wordNum = words.size();
        int place;
        place = rand.nextInt(wordNum);
        String s = words.get(place);
        System.out.println(s);
        return s;
    }
}

