package com.appscharles.libs.jarer.programs.Resourcer;

import java.io.IOException;
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
public class Program2 {

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args) throws IOException {
        String text = new Scanner(Program2.class.getResourceAsStream("/com/appscharles/libs/jarer/programs/Resourcer/data/file.txt"), "UTF-8").useDelimiter("\\A").next();
        System.out.println("Program 2 launched with text: " + text);
    }
}
