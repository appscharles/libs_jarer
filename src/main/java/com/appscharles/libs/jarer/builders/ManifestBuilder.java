package com.appscharles.libs.jarer.builders;

import java.util.jar.Attributes;
import java.util.jar.Manifest;

/**
 * The type Manifest builder.
 */
public class ManifestBuilder {

    private Manifest manifest;

    private ManifestBuilder(){
        this.manifest = new Manifest();
    }

    /**
     * Create manifest builder.
     *
     * @param projectName the project name
     * @param version     the version
     * @param mainClass   the main class
     * @return the manifest builder
     */
    public static ManifestBuilder create(String projectName, String version, Class mainClass){
        ManifestBuilder instance = new ManifestBuilder();
        instance.manifest.getMainAttributes().put(Attributes.Name.IMPLEMENTATION_TITLE, projectName);
        instance.manifest.getMainAttributes().put(Attributes.Name.IMPLEMENTATION_VERSION, version);
        instance.manifest.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, version);
        instance.manifest.getMainAttributes().put(Attributes.Name.MAIN_CLASS, mainClass.getName());
        return instance;
    }

    /**
     * Add main attribute manifest builder.
     *
     * @param name  the name
     * @param value the value
     * @return the manifest builder
     */
    public ManifestBuilder addMainAttribute(Attributes.Name name, Object value){
        this.manifest.getMainAttributes().put(name, value);
        return this;
    }

    /**
     * Build manifest.
     *
     * @return the manifest
     */
    public Manifest build(){
        return this.manifest;
    }

    /**
     * Gets manifest.
     *
     * @return the manifest
     */
    public Manifest getManifest() {
        return this.manifest;
    }
}
