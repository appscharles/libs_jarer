package com.appscharles.libs.jarer.resources;

import com.appscharles.libs.jarer.programs.Extruder.Extruder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 29.06.2018
 * Time: 17:13
 * Project name: jarer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class UnpackedResourcesTest {

    @Test
    public void shouldGetFilesFromPackage() throws IOException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL packageURL =  loader.getResource(Extruder.class.getPackage().getName().replace(".", "/"));

        IPathResourceExtractor unpackedResources = new UnpackedResources(packageURL, Extruder.class.getPackage().getName());
        List<PathResource> pathResources =  unpackedResources.getPathResources();
        Assert.assertTrue(pathResources.size() > 0);
    }
}