package com.appscharles.libs.jarer.models;

/**
 * The type Path resource.
 */
public class PathResource {

    private Boolean directory;

    private String pathResource;

    /**
     * Instantiates a new Path resource.
     *
     * @param directory    the directory
     * @param pathResource the path resource
     */
    public PathResource(Boolean directory, String pathResource) {
        this.directory = directory;
        this.pathResource = pathResource;
    }

    /**
     * Is directory boolean.
     *
     * @return the boolean
     */
    public Boolean isDirectory() {
        return this.directory;
    }

    /**
     * Gets path resource.
     *
     * @return the path resource
     */
    public String getPathResource() {
        return this.pathResource;
    }
}
