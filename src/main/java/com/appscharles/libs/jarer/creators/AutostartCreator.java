package com.appscharles.libs.jarer.creators;

import com.appscharles.libs.ioer.services.FileWriter;
import com.appscharles.libs.jarer.adders.AutostartUserAdder;
import com.appscharles.libs.jarer.exceptions.JarerException;

import java.io.File;
import java.io.IOException;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 11.07.2018
 * Time: 15:00
 * Project name: jarer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class AutostartCreator {

    public static void create(String regKey, File batFile, String command) throws JarerException {
        try {
            FileWriter.write(batFile, command);
            AutostartUserAdder.add(regKey, batFile);
        } catch (JarerException | IOException e) {
            throw new JarerException(e);
        }

    }
}
