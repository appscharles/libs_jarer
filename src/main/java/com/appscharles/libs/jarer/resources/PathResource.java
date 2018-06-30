package com.appscharles.libs.jarer.resources;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 29.06.2018
 * Time: 17:32
 * Project name: jarer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class PathResource {

    private Boolean directory;

    private String pathResource;

    public PathResource(Boolean directory, String pathResource) {
        this.directory = directory;
        this.pathResource = pathResource;
    }

    /**
     * Getter for property 'directory'.
     *
     * @return Value for property 'directory'.
     */
    public Boolean isDirectory() {
        return this.directory;
    }

    /**
     * Getter for property 'relativePath'.
     *
     * @return Value for property 'relativePath'.
     */
    public String getPathResource() {
        return this.pathResource;
    }
}
