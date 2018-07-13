package com.appscharles.libs.jarer.creators;

import com.appscharles.libs.jarer.includers.IDependencyIncluder;

import java.util.List;

/**
 * The interface Dependy adder getable.
 */
public interface IDependencyIncludable {

    /**
     * Gets dependency adders.
     *
     * @return the dependency adders
     */
    List<IDependencyIncluder> getDependencyIncluders();
}
