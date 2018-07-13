package com.appscharles.libs.jarer.programs.Direr;

import com.appscharles.libs.ioer.services.DirReader;
import com.appscharles.libs.jarer.exceptions.JarerException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 12.07.2018
 * Time: 16:10
 * Project name: jarer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class Direr {

    public static void main(String[] args) throws JarerException, IOException {
        System.out.println("Direr launched");
        File jarFile = Files.createTempDirectory("file").toFile();
        DirReader.getFiles(jarFile);
    }
}
