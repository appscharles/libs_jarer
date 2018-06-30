package com.appscharles.libs.jarer.resources;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * The type Relative files resource.
 */
public class PathResourceExtractor implements IPathResourceExtractor {

    private String packageName;

    /**
     * Instantiates a new Relative files resource.
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
                IPathResourceExtractor unpackedResources = new UnpackedResources(new URL(packageURL), this.packageName);
                return unpackedResources.getPathResources();
            } else if (packageURL.startsWith("jar:file:/")) {
                IPathResourceExtractor jarResources = new JarResources(new URL(packageURL),this.packageName);
                return jarResources.getPathResources();
            } else {
                throw new IOException("URL is not supported: " + packageURL);
            }
        } catch (IOException e) {
            throw new IOException(e);
        }
    }

    private URL getPackageURL() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        return loader.getResource(this.packageName.replace(".", "/"));
    }
}
