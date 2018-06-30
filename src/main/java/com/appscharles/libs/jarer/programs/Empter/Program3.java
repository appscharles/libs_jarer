package com.appscharles.libs.jarer.programs.Empter;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 29.06.2018
 * Time: 13:46
 * Project name: jarer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class Program3 {

    /**
     * Main.
     *
     * @param args the args
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
