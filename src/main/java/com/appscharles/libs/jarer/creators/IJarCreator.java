package com.appscharles.libs.jarer.creators;

/**
 * The interface Jar creator.
 */
public interface IJarCreator extends ICreateable {

    /**
     * Add class.
     *
     * @param clazz the clazz
     */
    void addClass(Class clazz);

    /**
     * Add package.
     *
     * @param name the name
     */
    void addPackage(String name);
}
