package com.appscharles.libs.jarer.resources;

import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.extractors.IPathResourceExtractor;
import com.appscharles.libs.jarer.extractors.PathResourceExtractor;
import com.appscharles.libs.jarer.models.Package;
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
    public void shouldGetRelativeFilesOfPackage() throws  JarerException {
        IPathResourceExtractor pathResourceExtractor = new PathResourceExtractor(new Package(Extruder.class.getPackage().getName()), Extruder.class.getProtectionDomain().getCodeSource().getLocation());
        List<PathResource> pathResources = pathResourceExtractor.getPathResources();
        Assert.assertTrue(pathResources.size() > 0);
    }
}