package com.appscharles.libs.jarer.models;

import java.net.URL;

/**
 * The type Package.
 */
public class Package {

    private String packageName;

    private String projectGroup;

    private String projectArtifact;

    private String version;

    private URL packageURL;

    /**
     * Instantiates a new Package.
     *
     * @param packageName the package name
     */
    public Package(String packageName) {
        this(packageName, null, null, null, null);
    }

    /**
     * Instantiates a new Package.
     *
     * @param packageURL the package url
     */
    public Package(String packageName, URL packageURL ) {
        this(packageName, null, null, null, packageURL);
    }

    /**
     * Instantiates a new Package.
     *
     * @param packageName     the package name
     * @param projectGroup    the project group
     * @param projectArtifact the project artifact
     * @param version         the version
     */
    public Package(String packageName, String projectGroup, String projectArtifact, String version) {
        this(packageName, projectGroup, projectArtifact, version, null);
    }


    /**
     * Instantiates a new Package.
     *
     * @param packageName     the package name
     * @param projectGroup    the project group
     * @param projectArtifact the project artifact
     * @param version         the version
     * @param packageURL      the package url
     * @param resourcePackage the resource package
     */
    public Package(String packageName, String projectGroup, String projectArtifact, String version, URL packageURL) {
        this.packageName = packageName;
        this.projectGroup = projectGroup;
        this.projectArtifact = projectArtifact;
        this.version = version;
        this.packageURL = packageURL;
    }

    /**
     * Gets package name.
     *
     * @return the package name
     */
    public String getPackageName() {
        return packageName;
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
     * Gets version.
     *
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * Gets package url.
     *
     * @return the package url
     */
    public URL getPackageURL() {
        return packageURL;
    }

}
