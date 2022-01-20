package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// Написать функциональный интерфейс с методом, который принимает две строки и возвращает тоже строку.
// Написать реализацию такого интерфейса в виде лямбда-выражения, возвращающего ту строку, которая длиннее. rdy
// Продемонстрировать работу интерфейса на задаче поиска самой длинной строки в файле.
public class Main {

    public static void main(String[] args) {
        SearchMaxString searchMaxString = (first_str, second_str) -> {
            if (first_str.length() > second_str.length()) {
                return first_str;
            } else if (first_str.length() == second_str.length()) {
                return first_str;
            } else {
                return second_str;
            }
        };


        SearchMaxStringFile searchMaxStringFile = (file) -> {
            try {
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                String memory = "";
                int counter = 0;
                long line_length = Files.lines(Path.of(file.getPath())).count();
                while (counter < line_length - 1) {
                    String next_line = reader.readLine();
                    if (memory.length() > next_line.length()){
                        memory = memory;
                    }
                    else{
                        memory = next_line;
                    }
                    counter += 1;
                }
                return memory;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        };

        String test = searchMaxString.get_max_str("firstsssssss", "secondxxx");
//        System.out.println(test);
        File file = new File("C:\\Users\\Sandro\\IdeaProjects\\lambdas(max_string)\\src\\com\\company\\teststr.txt");
        String test_1 = searchMaxStringFile.get_max_str_file(file);
        System.out.println(test_1);
    }
}
