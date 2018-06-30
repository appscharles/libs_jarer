package com.appscharles.libs.jarer.programs.Resourcer;

import java.io.IOException;
import java.util.Scanner;

/**
 * The type Program 2.
 */
public class Program2 {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        String text = new Scanner(Program2.class.getResourceAsStream("/com/appscharles/libs/jarer/programs/Resourcer/data/file.txt"), "UTF-8").useDelimiter("\\A").next();
        System.out.println("Program 2 launched with text: " + text);
    }
}
