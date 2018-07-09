package com.appscharles.libs.jarer.creators;

import java.net.URL;
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
     * @param packageName     the package name
     * @param projectGroup    the project group
     * @param projectArtifact the project artifact
     * @param version         the version
     */
    void addPackage(String packageName, String projectGroup, String projectArtifact, String version);

    /**
     * Add package.
     *
     * @param packageName the package name
     */
    void addPackage(String packageName);

    /**
     * Add package.
     *
     * @param packageName the package name
     * @param packageURL  the package url
     */
    void addPackage(String packageName, URL packageURL);

    /**
     * Gets manifest.
     *
     * @return the manifest
     */
    Manifest getManifest();
}
