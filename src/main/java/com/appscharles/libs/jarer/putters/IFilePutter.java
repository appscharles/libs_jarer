package com.appscharles.libs.jarer.putters;

import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.models.Dependency;

import java.io.File;
import java.util.List;
import java.util.jar.JarOutputStream;

/**
 * The interface Dependency includer.
 */
public interface IFilePutter {

    /**
     * Include boolean.
     *
     * @param dependency the dependency
     * @param file
     * @param jos        the jos
     * @param addedZipEntryNames
     * @return the boolean
     */
    void put(Dependency dependency, File file, JarOutputStream jos, List<String> addedZipEntryNames) throws JarerException;
}
