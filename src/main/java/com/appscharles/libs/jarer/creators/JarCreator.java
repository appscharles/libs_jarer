package com.appscharles.libs.jarer.creators;

import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.includers.ZipDependencyIncluder;
import com.appscharles.libs.jarer.includers.UnpackDependencyIncluder;
import com.appscharles.libs.jarer.models.Dependency;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

/**
 * The type Jar creator 2.
 */
public class JarCreator extends AbstractJarCreator {

    /**
     * Instantiates a new Jar creator 2.
     *
     * @param jarFile  the jar file
     * @param manifest the manifest
     */
    public JarCreator(File jarFile, Manifest manifest) {
        super(jarFile, manifest);
        this.dependencyIncluders.add(new UnpackDependencyIncluder());
        this.dependencyIncluders.add(new ZipDependencyIncluder());
    }

    @Override
    public void create() throws JarerException {
        try (FileOutputStream fos = new FileOutputStream(this.jarFile);
             JarOutputStream jos = new JarOutputStream(fos, this.manifest)) {
            for (Dependency dependency : this.dependencies) {
                includeDependency(dependency, jos);
            }
        } catch (IOException e) {
            throw new JarerException(e);
        }
    }
}
