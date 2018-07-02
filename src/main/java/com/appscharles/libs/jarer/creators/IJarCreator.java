package com.appscharles.libs.jarer.creators;

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
     * @param packageName the package name
     * @param moduleName  the module name
     */
    void addPackage(String name, String projectGroup, String projectArtifact);
}
