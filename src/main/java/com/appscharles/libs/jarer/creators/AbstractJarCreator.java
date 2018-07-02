package com.appscharles.libs.jarer.creators;

import com.appscharles.libs.jarer.adders.ClassAdder;
import com.appscharles.libs.jarer.adders.IAdder;
import com.appscharles.libs.jarer.adders.PackageAdder;
import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.extractors.IPathResourceExtractor;
import com.appscharles.libs.jarer.extractors.PathResourceExtractor;
import com.appscharles.libs.jarer.models.PathResource;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

/**
 * The type Abstract jar creator.
 */
public abstract class AbstractJarCreator implements IJarCreator {

    /**
     * The Jar file.
     */
    protected File jarFile;

    /**
     * The Manifest.
     */
    protected Manifest manifest;

    protected URL locationClasses;

    /**
     * The Classes.
     */
    protected List<Class> classes;

    /**
     * The Packages.
     */
    protected List<String> packages;

    /**
     * Instantiates a new Abstract jar creator.
     *
     * @param jarFile  the jar file
     * @param manifest the manifest
     */
    public AbstractJarCreator(File jarFile, Manifest manifest, URL locationClasses) {
        this.jarFile = jarFile;
        this.manifest = manifest;
        this.locationClasses = locationClasses;
        this.classes = new ArrayList<>();
        this.packages = new ArrayList<>();
    }

    public void addClass(Class clazz){
        this.classes.add(clazz);
    }

    /**
     * Load classes.
     *
     * @param jarOutputStream the jar output stream
     * @throws JarerException the jarer exception
     */
    protected void loadClasses(JarOutputStream jarOutputStream) throws JarerException {
        for (Class clazz : this.classes) {
            IAdder adder = new ClassAdder(clazz, jarOutputStream);
            adder.add();
        }
    }

    /**
     * Load packages.
     *
     * @param jarOutputStream the jar output stream
     * @throws JarerException the jarer exception
     */
    protected void loadPackages(JarOutputStream jarOutputStream) throws JarerException {
        try {
            for (String packageName : this.packages) {
                IPathResourceExtractor rFR = new PathResourceExtractor(packageName, this.locationClasses);
                List<PathResource> pathResources = rFR.getPathResources();
                IAdder adder = new PackageAdder(pathResources, jarOutputStream);
                adder.add();
            }
        } catch (IOException e) {
            throw new JarerException(e);
        }
    }

    public void addPackage(String name){
        this.packages.add(name);
    }
}
