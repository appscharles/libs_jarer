package com.appscharles.libs.jarer.extractors;

import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.models.Package;
import com.appscharles.libs.jarer.models.PathResource;
import com.appscharles.libs.jarer.resources.JarResource;
import com.appscharles.libs.jarer.resources.UnpackedResource;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * The type Path resource extractor.
 */
public class PathResourceExtractor implements IPathResourceExtractor {

    private Package aPackage;

    private URL locationClasses;

    /**
     * Instantiates a new Path resource extractor.
     *
     * @param aPackage        the a package
     * @param locationClasses the location classes
     */
    public PathResourceExtractor(Package aPackage, URL locationClasses) {
        this.aPackage = aPackage;
        this.locationClasses = locationClasses;
    }

    public List<PathResource> getPathResources() throws JarerException {
        try {
            String packageURL = PackageURLExtractor.extract(this.aPackage, this.locationClasses).toString();
            if (packageURL.startsWith("file:/")) {
                IPathResourceExtractor unpackedResources = new UnpackedResource(new URL(packageURL), this.aPackage.getPackageName());
                return unpackedResources.getPathResources();
            } else if (packageURL.startsWith("jar:file:/")) {
                IPathResourceExtractor jarResources = new JarResource(new URL(packageURL),this.aPackage.getPackageName());
                return jarResources.getPathResources();
            } else {
                throw new IOException("URL is not supported: " + packageURL);
            }
        } catch (JarerException | IOException e) {
            throw new JarerException(e);
        }
    }

}
