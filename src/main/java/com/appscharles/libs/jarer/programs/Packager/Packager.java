package com.appscharles.libs.jarer.programs.Packager;

import com.appscharles.libs.ioer.services.DirReader;
import com.appscharles.libs.jarer.builders.JarCreatorBuilder;
import com.appscharles.libs.jarer.creators.IJarCreator;
import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.programs.Direr.Direr;
import com.appscharles.libs.jarer.programs.Tester.Program;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 12.07.2018
 * Time: 16:07
 * Project name: jarer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class Packager {

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args) throws JarerException, IOException {
        System.out.println("Packager launched");
        File jarFile = Files.createTempFile("file", "jar").toFile();
        jarFile.delete();
        IJarCreator jarCreator = JarCreatorBuilder.create("myApp", "1.0.0.0-dev2", Program.class, jarFile)
                .addDependency("com/appscharles/libs/jarer/programs/Direr", Direr.class.getProtectionDomain().getCodeSource().getLocation())
                .addDependency("com/appscharles/libs/ioer", DirReader.class.getProtectionDomain().getCodeSource().getLocation())
                .build();
        jarCreator.create();
    }
}
