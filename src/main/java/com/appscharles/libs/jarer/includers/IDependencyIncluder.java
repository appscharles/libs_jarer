package com.appscharles.libs.jarer.includers;

import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.models.Dependency;

import java.util.List;
import java.util.jar.JarOutputStream;

/**
 * The interface Dependency includer.
 */
public interface IDependencyIncluder {

    /**
     * Include boolean.
     *
     * @param dependency the dependency
     * @param jos        the jos
     * @param addedZipEntryNames
     * @return the boolean
     */
    void include(Dependency dependency, JarOutputStream jos, List<String> addedZipEntryNames) throws JarerException;

    Boolean validate(Dependency dependency);
}
