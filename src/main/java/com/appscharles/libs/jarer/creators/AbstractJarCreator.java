package com.appscharles.libs.jarer.creators;

import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.includers.IDependencyIncluder;
import com.appscharles.libs.jarer.models.Dependency;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

/**
 * The type Abstract jar creator 2.
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
     * The Dependencies.
     */
    protected List<Dependency> dependencies;

    /**
     * The Dependency includers.
     */
    protected List<IDependencyIncluder> dependencyIncluders;

    protected List<String> addedZipEntryNames;

    /**
     * Instantiates a new Abstract jar creator 2.
     *
     * @param jarFile  the jar file
     * @param manifest the manifest
     */
    public AbstractJarCreator(File jarFile, Manifest manifest) {
        this.jarFile = jarFile;
        this.manifest = manifest;
        this.dependencies = new ArrayList<>();
        this.dependencyIncluders = new ArrayList<>();
this.addedZipEntryNames = new ArrayList<>();
    }

    @Override
    public void addDependency(Dependency dependency) {
        this.dependencies.add(dependency);
    }

    @Override
    public void addDependency(String resource, URL location) {
        this.dependencies.add(new Dependency(resource, location));
    }

    @Override
    public Manifest getManifest() {
        return this.manifest;
    }

    @Override
    public List<IDependencyIncluder> getDependencyIncluders() {
        return this.dependencyIncluders;
    }

    /**
     * Include dependency.
     *
     * @param dependency the dependency
     * @param jos        the jos
     */
    protected void includeDependency(Dependency dependency, JarOutputStream jos) throws JarerException {
        Boolean dependencyIncluded = false;

        for (IDependencyIncluder dependencyIncluder : this.dependencyIncluders) {
            if (dependencyIncluder.validate(dependency) == false) {
                continue;
            }
            dependencyIncluder.include(dependency, jos, this.addedZipEntryNames);
            dependencyIncluded = true;
        }
        if (dependencyIncluded == false) {
            throw new JarerException("Not include resource '" + dependency.getResource() + "' of dependency '" + dependency.getLocation() + "' to jar.");
        }
    }
}
