package com.appscharles.libs.jarer.resources;

import com.appscharles.libs.jarer.extractors.IPathResourceExtractor;
import com.appscharles.libs.jarer.models.PathResource;
import com.appscharles.libs.jarer.programs.Extruder.Extruder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * The type Unpacked resources test.
 */
public class UnpackedResourcesTest {

    /**
     * Should get files from package.
     *
     * @throws IOException the io exception
     */
    @Test
    public void shouldGetFilesFromPackage() throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL packageURL =  loader.getResource(Extruder.class.getPackage().getName().replace(".", "/"));

        IPathResourceExtractor unpackedResources = new UnpackedResource(packageURL, Extruder.class.getPackage().getName());
        List<PathResource> pathResources =  unpackedResources.getPathResources();
        Assert.assertTrue(pathResources.size() > 0);
    }
}