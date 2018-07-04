package com.appscharles.libs.jarer.creators;

import java.util.jar.Manifest;

/**
 * The interface Jar creator.
 */
public interface IJarCreator extends ICreatable {

    /**
     * Add class.
     *
     * @param clazz the clazz
     */
    void addClass(Class clazz);

    /**
     * Add package.
     *
     * @param packageName the package name
     */
    void addPackage(String packageName);

    /**
     * Add package.
     *
     * @param name            the name
     * @param projectGroup    the project group
     * @param projectArtifact the project artifact
     */
    void addPackage(String name, String projectGroup, String projectArtifact);

    /**
     * Gets manifest.
     *
     * @return the manifest
     */
    Manifest getManifest();
}
