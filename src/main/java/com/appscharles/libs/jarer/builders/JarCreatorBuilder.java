package com.appscharles.libs.jarer.builders;

import com.appscharles.libs.jarer.creators.IJarCreator;
import com.appscharles.libs.jarer.creators.JarCreator;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Manifest;

/**
 * The type Jar creator builder.
 */
public class JarCreatorBuilder {

    private Manifest manifest;

    private Class mainClass;

    private File jarFile;

    private List<Class> classes;

    private List<String> packages;

    private IJarCreator jarCreator;

    private URL locationClasses;

    private JarCreatorBuilder() {
        this.classes = new ArrayList<>();
        this.packages = new ArrayList<>();
    }

    /**
     * Create jar creator builder.
     *
     * @param projectName the project name
     * @param version     the version
     * @param mainClass   the main class
     * @param jarFile     the jar file
     * @return the jar creator builder
     */
    public static JarCreatorBuilder create(String projectName, String version, Class mainClass, File jarFile, URL locationClasses) {
        JarCreatorBuilder instance = new JarCreatorBuilder();
        instance.mainClass = mainClass;
        instance.jarFile = jarFile;
        instance.locationClasses = locationClasses;
        instance.manifest = ManifestBuilder.create(projectName, version, instance.mainClass).build();
        instance.jarCreator = new JarCreator(instance.jarFile, instance.manifest, instance.locationClasses);
        return instance;
    }

    /**
     * Build jar creator.
     *
     * @return the jar creator
     */
    public IJarCreator build() {
        for (Class clazz : this.classes) {
            this.jarCreator.addClass(clazz);
        }
        for (String packageName : this.packages) {
            this.jarCreator.addPackage(packageName);
        }
        return this.jarCreator;
    }

    /**
     * Manifest.
     *
     * @param manifest the manifest
     */
    public void manifest(Manifest manifest) {
        this.manifest = manifest;
    }

    /**
     * Add class.
     *
     * @param clazz the clazz
     */
    public void addClass(Class clazz){
        if (this.classes.contains(clazz) == false){
            this.classes.add(clazz);
        }
    }

    /**
     * Add package.
     *
     * @param packageName the package name
     */
    public void addPackage(String packageName){
        if (this.packages.contains(packageName) == false){
            this.packages.add(packageName);
        }
    }

    /**
     * Jar creator.
     *
     * @param jarCreator the jar creator
     */
    public void jarCreator(IJarCreator jarCreator) {
        this.jarCreator = jarCreator;
    }
}