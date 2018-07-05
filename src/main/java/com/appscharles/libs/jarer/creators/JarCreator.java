package com.appscharles.libs.jarer.creators;

import com.appscharles.libs.jarer.exceptions.JarerException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

/**
 * The type Jar creator.
 */
public class JarCreator extends AbstractJarCreator {

    /**
     * Instantiates a new Jar creator.
     *
     * @param jarFile         the jar file
     * @param manifest        the manifest
     * @param locationClasses the location classes
     */
    public JarCreator(File jarFile, Manifest manifest, URL locationClasses) {
        super(jarFile, manifest, locationClasses);
    }

    @Override
    public void create() throws JarerException {
        try (FileOutputStream fos = new FileOutputStream(this.jarFile);
             JarOutputStream jos = new JarOutputStream(fos, this.manifest)) {
            loadClasses(jos);
            loadPackages(jos);
        } catch (IOException e) {
            throw new JarerException(e);
        }
    }
}
