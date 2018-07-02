package com.appscharles.libs.jarer.resources;

import com.appscharles.libs.ioer.converters.RelativeFileConverter;
import com.appscharles.libs.ioer.models.RelativeFile;
import com.appscharles.libs.ioer.services.DirReader;
import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.extractors.IPathResourceExtractor;
import com.appscharles.libs.jarer.models.PathResource;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Unpacked resources.
 */
public class UnpackedResource implements IPathResourceExtractor {

    private URL packageURL;

    private String packageName;

    /**
     * Instantiates a new Unpacked resources.
     *
     * @param packageURL  the package url
     * @param packageName the package name
     */
    public UnpackedResource(URL packageURL, String packageName) {
        this.packageURL = packageURL;
        this.packageName = packageName;
    }

    @Override
    public List<PathResource> getPathResources() throws JarerException {
        try {
            List<PathResource> pathResources = new ArrayList<>();
            Path path = Paths.get(this.packageURL.toURI());
            List<File> files = DirReader.getFiles(path.toFile());
            List<RelativeFile> relativeFiles = RelativeFileConverter.convert(path.toFile(), files);
            for (RelativeFile relativeFile : relativeFiles) {
                if (relativeFile.getRelativePath().isEmpty() == false){
                    String relativePath = this.packageName.replace(".", "/") + relativeFile.getRelativePath().replace("\\", "/");
                    pathResources.add(new PathResource(relativeFile.isDirectory(), relativePath));
                }
            }
            return pathResources;
        } catch (IOException | URISyntaxException e) {
            throw new JarerException(e);
        }
    }
}
