package com.appscharles.libs.jarer.programs.Empter;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * The type Program 3.
 */
public class Program3 {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        String text = new Scanner(Program3.class.getResourceAsStream("/com/appscharles/libs/jarer/programs/Empter/data/file.txt"), "UTF-8").useDelimiter("\\A").next();
        System.out.println("Program 3 launched with text: " + text);
        URL url = Program3.class.getResource("/com/appscharles/libs/jarer/programs/Empter/data/emptyDir");
        if (url == null){
            throw new IOException("Url is null");
        }
    }
}
