package com.appscharles.libs.jarer.resources;

import com.appscharles.libs.jarer.extractors.IPathResourceExtractor;
import com.appscharles.libs.jarer.extractors.PathResourceExtractor;
import com.appscharles.libs.jarer.models.PathResource;
import com.appscharles.libs.jarer.programs.Extruder.Extruder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * The type Path resource extractor test.
 */
public class PathResourceExtractorTest {

    /**
     * Should get relative files of package.
     *
     * @throws IOException the io exception
     */
    @Test
    public void shouldGetRelativeFilesOfPackage() throws IOException {
        IPathResourceExtractor pathResourceExtractor = new PathResourceExtractor(Extruder.class.getPackage().getName());
        List<PathResource> pathResources = pathResourceExtractor.getPathResources();
        Assert.assertTrue(pathResources.size() > 0);
    }
}