package com.appscharles.libs.jarer.resources;

import com.appscharles.libs.jarer.programs.Extruder.Extruder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 29.06.2018
 * Time: 16:41
 * Project name: jarer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class PathResourceExtractorTest {

    @Test
    public void shouldGetRelativeFilesOfPackage() throws IOException {
        IPathResourceExtractor pathResourceExtractor = new PathResourceExtractor(Extruder.class.getPackage().getName());
        List<PathResource> pathResources = pathResourceExtractor.getPathResources();
        Assert.assertTrue(pathResources.size() > 0);
    }
}