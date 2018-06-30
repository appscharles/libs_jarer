package com.appscharles.libs.jarer.programs.Extruder;

import com.appscharles.libs.jarer.builders.JarCreatorBuilder;
import com.appscharles.libs.jarer.creators.IJarCreator;
import com.appscharles.libs.jarer.programs.Resourcer.Program2;

import java.io.File;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 29.06.2018
 * Time: 15:09
 * Project name: jarer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class Extruder {

    public static void main(String[] args) {
        try {
            File jarFile = new File("file.jar");
            IJarCreator jarCreator = JarCreatorBuilder.create("myApp", "1.0.0.0-dev2", Program2.class, jarFile).build();
            jarCreator.addPackage(Program2.class.getPackage().getName());
            jarCreator.create();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
