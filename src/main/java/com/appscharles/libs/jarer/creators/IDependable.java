package com.appscharles.libs.jarer.creators;

import com.appscharles.libs.jarer.models.Dependency;

import java.net.URL;

/**
 * The interface Dependable.
 */
public interface IDependable {

    /**
     * Add dependency.
     *
     * @param dependency the dependency
     */
    void addDependency(Dependency dependency);

    /**
     * Add dependency.
     *
     * @param resource the resource
     * @param location the location
     */
    void addDependency(String resource, URL location);
}
