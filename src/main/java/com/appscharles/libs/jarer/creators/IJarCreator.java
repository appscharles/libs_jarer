package com.appscharles.libs.jarer.creators;

import com.appscharles.libs.jarer.exceptions.JarerException;

/**
 * The interface Jar creator 2.
 */
public interface IJarCreator extends IDependable, IManifestable, IDependencyIncludable, ICreatable {

    /**
     * Create.
     *
     * @throws JarerException the jarer exception
     */
    void create() throws JarerException;
}
