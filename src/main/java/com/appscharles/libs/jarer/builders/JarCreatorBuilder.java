package com.appscharles.libs.jarer.builders;

import com.appscharles.libs.jarer.creators.IJarCreator;
import com.appscharles.libs.jarer.creators.JarCreator;
import com.appscharles.libs.jarer.models.Dependency;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Manifest;

/**
 * The type Jar creator 2 builder.
 */
public class JarCreatorBuilder {

    private Manifest manifest;

    private Class mainClass;

    private File jarFile;

    private List<Dependency> dependencies;

    private IJarCreator jarCreator;

    private JarCreatorBuilder() {
        this.dependencies = new ArrayList<>();
    }

    /**
     * Create jar creator 2 builder.
     *
     * @param projectName the project name
     * @param version     the version
     * @param mainClass   the main class
     * @param jarFile     the jar file
     * @return the jar creator 2 builder
     */
    public static JarCreatorBuilder create(String projectName, String version, Class mainClass, File jarFile) {
        JarCreatorBuilder instance = new JarCreatorBuilder();
        instance.mainClass = mainClass;
        instance.jarFile = jarFile;
        instance.manifest = ManifestBuilder.create(projectName, version, instance.mainClass).build();
        instance.jarCreator = new JarCreator(instance.jarFile, instance.manifest);
        return instance;
    }

    /**
     * Build jar creator 2.
     *
     * @return the jar creator 2
     */
    public IJarCreator build() {
        for (Dependency dependency : this.dependencies) {
            this.jarCreator.addDependency(dependency);
        }
        return this.jarCreator;
    }

    /**
     * Manifest.
     *
     * @param manifest the manifest
     */
    public JarCreatorBuilder manifest(Manifest manifest) {
        this.manifest = manifest;
        return this;
    }


    /**
     * Add dependency.
     *
     * @param dependency the dependency
     */
    public JarCreatorBuilder addDependency(Dependency dependency) {
        this.dependencies.add(dependency);
        return this;
    }


    /**
     * Add dependency.
     *
     * @param resource the resource
     * @param location the location
     */
    public JarCreatorBuilder addDependency(String resource, URL location) {
        this.dependencies.add(new Dependency(resource, location));
        return this;
    }
}