package com.appscharles.libs.jarer.creators;

import com.appscharles.libs.jarer.adders.ClassAdder;
import com.appscharles.libs.jarer.adders.IAdder;
import com.appscharles.libs.jarer.adders.PackageAdder;
import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.resources.IPathResourceExtractor;
import com.appscharles.libs.jarer.resources.PathResource;
import com.appscharles.libs.jarer.resources.PathResourceExtractor;

import java.io.File;
import java.io.IOException;
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

    /**
     * The Classes.
     */
    protected List<Class> classes;

    /**
     * The Classes.
     */
    protected List<String> packages;

    /**
     * Instantiates a new Abstract jar creator.
     *
     * @param jarFile  the jar file
     * @param manifest the manifest
     */
    public AbstractJarCreator(File jarFile, Manifest manifest) {
        this.jarFile = jarFile;
        this.manifest = manifest;
        this.classes = new ArrayList<>();
        this.packages = new ArrayList<>();
    }

    /**
     * Add class.
     *
     * @param clazz the clazz
     */
    public void addClass(Class clazz){
        this.classes.add(clazz);
    }

    protected void loadClasses(JarOutputStream jarOutputStream) throws JarerException {
        for (Class clazz : this.classes) {
            IAdder adder = new ClassAdder(clazz, jarOutputStream);
            adder.add();
        }
    }

    protected void loadPackages(JarOutputStream jarOutputStream) throws JarerException {
        try {
            for (String packageName : this.packages) {
                IPathResourceExtractor rFR = new PathResourceExtractor(packageName);
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
