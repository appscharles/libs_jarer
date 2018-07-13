package com.appscharles.libs.jarer.models;

import java.net.URL;

/**
 * The type Location.
 */
public class Dependency {

    private String resource;

    private URL location;


    /**
     * Instantiates a new Location.
     *
     * @param sourceCodeLocationURL the source code location url
     * @param resource              the resource
     */
    public Dependency(String resource, URL location) {
        this.resource = resource;
        this.location = location;
    }

    /**
     * Getter for property 'resource'.
     *
     * @return Value for property 'resource'.
     */
    public String getResource() {
        return resource;
    }

    /**
     * Setter for property 'resource'.
     *
     * @param resource Value to set for property 'resource'.
     */
    public void setResource(String resource) {
        this.resource = resource;
    }

    /**
     * Getter for property 'location'.
     *
     * @return Value for property 'location'.
     */
    public URL getLocation() {
        return location;
    }

    /**
     * Setter for property 'location'.
     *
     * @param location Value to set for property 'location'.
     */
    public void setLocation(URL location) {
        this.location = location;
    }
}
