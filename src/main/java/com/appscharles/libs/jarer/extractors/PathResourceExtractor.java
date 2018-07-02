package com.appscharles.libs.jarer.extractors;

import com.appscharles.libs.jarer.models.PathResource;
import com.appscharles.libs.jarer.resources.JarResource;
import com.appscharles.libs.jarer.resources.UnpackedResource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * The type Path resource extractor.
 */
public class PathResourceExtractor implements IPathResourceExtractor {

    private String packageName;

    /**
     * Instantiates a new Path resource extractor.
     *
     * @param packageName the package name
     */
    public PathResourceExtractor(String packageName) {
        this.packageName = packageName;
    }

    public List<PathResource> getPathResources() throws IOException {
        try {
            String packageURL = getPackageURL().toString();
            if (packageURL.startsWith("file:/")) {
                IPathResourceExtractor unpackedResources = new UnpackedResource(new URL(packageURL), this.packageName);
                return unpackedResources.getPathResources();
            } else if (packageURL.startsWith("jar:file:/")) {
                IPathResourceExtractor jarResources = new JarResource(new URL(packageURL),this.packageName);
                return jarResources.getPathResources();
            } else {
                throw new IOException("URL is not supported: " + packageURL);
            }
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    private URL getPackageURL() throws MalformedURLException {
        URL classesLocation = PathResourceExtractor.class.getProtectionDomain().getCodeSource().getLocation();
        return new URL(classesLocation.toString() + "/" + this.packageName.replace(".", "/"));
    }
}
