package com.appscharles.libs.jarer.creators;

import com.appscharles.libs.jarer.adders.ClassAdder;
import com.appscharles.libs.jarer.adders.IAdder;
import com.appscharles.libs.jarer.adders.PackageAdder;
import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.extractors.IPathResourceExtractor;
import com.appscharles.libs.jarer.extractors.PathResourceExtractor;
import com.appscharles.libs.jarer.models.Package;
import com.appscharles.libs.jarer.models.PathResource;
import com.appscharles.libs.jarer.services.PathResourceUnduplicator;

import java.io.File;
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

    /**
     * The Location classes.
     */
    protected URL locationClasses;

    /**
     * The Classes.
     */
    protected List<Class> classes;

    /**
     * The Packages.
     */
    protected List<Package> packages;

    /**
     * Instantiates a new Abstract jar creator.
     *
     * @param jarFile         the jar file
     * @param manifest        the manifest
     * @param locationClasses the location classes
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
        List<PathResource> pathResources = new ArrayList<>();
        for (Package aPackage : this.packages) {
            IPathResourceExtractor rFR = new PathResourceExtractor(aPackage, this.locationClasses );
            List<PathResource> p = rFR.getPathResources();
            pathResources.addAll(p);
        }
        pathResources = PathResourceUnduplicator.unduplicate(pathResources);
        IAdder adder = new PackageAdder(pathResources, jarOutputStream);
        adder.add();
    }

    public void addPackage(String packageName, String projectGroup, String projectArtifact, String version){
        this.packages.add(new Package(packageName, projectGroup, projectArtifact, version));
    }

    public void addPackage(String packageName){
        this.packages.add(new Package(packageName));
    }

    /**
     * Add package.
     *
     * @param packageURL the package url
     */
    public void addPackage(String packageName, URL packageURL){
        this.packages.add(new Package(packageName,packageURL));
    }

    public Manifest getManifest() {
        return this.manifest;
    }
}
