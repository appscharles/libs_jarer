package com.appscharles.libs.jarer.resources;

import com.appscharles.libs.jarer.extractors.IPathResourceExtractor;
import com.appscharles.libs.jarer.models.PathResource;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * The type Jar resources.
 */
public class JarResource implements IPathResourceExtractor {

    private URL packageURL;

    private String packageName;

    /**
     * Instantiates a new Jar resources.
     *
     * @param packageURL  the package url
     * @param packageName the package name
     */
    public JarResource(URL packageURL, String packageName) {
        this.packageURL = packageURL;
        this.packageName = packageName;
    }

    @Override
    public List<PathResource> getPathResources() throws IOException {
        try {
            List<PathResource> pathResources = new ArrayList<>();
            JarURLConnection connection = (JarURLConnection) this.packageURL.openConnection();
            ZipInputStream zIS = new ZipInputStream(connection.getJarFileURL().openStream());
            while(true) {
                ZipEntry entry = zIS.getNextEntry();
                if (entry == null)
                    break;
                String name = entry.getName();
                if (name.startsWith(this.packageName.replace(".", "/"))) {
                    pathResources.add(new PathResource(entry.isDirectory(), name));
                }
            }
            return pathResources;
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
}
