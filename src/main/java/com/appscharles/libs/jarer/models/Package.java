package com.appscharles.libs.jarer.models;

/**
 * The type Package.
 */
public class Package {

    private String name;

    private String projectGroup;

    private String projectArtifact;

    private Boolean module;

    /**
     * Instantiates a new Package.
     *
     * @param name the name
     */
    public Package(String name) {
        this(name, null, null);
    }

    /**
     * Instantiates a new Package.
     *
     * @param name            the name
     * @param projectGroup    the project group
     * @param projectArtifact the project artifact
     */
    public Package(String name, String projectGroup, String projectArtifact) {
        this.name = name;
        this.projectGroup = projectGroup;
        this.projectArtifact = projectArtifact;
        this.module = this.projectGroup != null;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets project group.
     *
     * @return the project group
     */
    public String getProjectGroup() {
        return projectGroup;
    }

    /**
     * Gets project artifact.
     *
     * @return the project artifact
     */
    public String getProjectArtifact() {
        return projectArtifact;
    }

    /**
     * Is module boolean.
     *
     * @return the boolean
     */
    public Boolean isModule() {
        return module;
    }
}