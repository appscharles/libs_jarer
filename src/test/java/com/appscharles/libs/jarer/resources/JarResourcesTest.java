package com.appscharles.libs.jarer.resources;

import com.appscharles.libs.jarer.builders.JarCreatorBuilder;
import com.appscharles.libs.jarer.creators.IJarCreator;
import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.extractors.IPathResourceExtractor;
import com.appscharles.libs.jarer.models.PathResource;
import com.appscharles.libs.jarer.programs.Extruder.Extruder;
import com.appscharles.libs.processer.callers.CommanderCaller;
import com.appscharles.libs.processer.callers.CommanderResult;
import com.appscharles.libs.processer.exceptions.ProcesserException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * The type Jar resources test.
 */
public class JarResourcesTest {

    /**
     * The Temp.
     */
    @Rule
    public TemporaryFolder temp = new TemporaryFolder();

    /**
     * Should get resources from jar file.
     *
     * @throws IOException        the io exception
     * @throws JarerException     the jarer exception
     * @throws ProcesserException the processer exception
     */
    @Test
    public void shouldGetResourcesFromJarFile() throws IOException, JarerException, ProcesserException {
        File jarFile = new File(this.temp.newFolder(), "file.jar");
        IJarCreator jarCreator = JarCreatorBuilder.create("myApp", "1.0.0.0-dev2", Extruder.class, jarFile).build();
        jarCreator.addPackage(Extruder.class.getPackage().getName());
        jarCreator.create();

        URL url = new URL("jar:file:\\"+ jarFile.getPath()+ "!/");
        IPathResourceExtractor pathResourceExtractor = new JarResource(url, Extruder.class.getPackage().getName());
        List<PathResource> pathResources =  pathResourceExtractor.getPathResources();
        Assert.assertTrue(pathResources.size() > 0);

        CommanderResult result = new CommanderCaller().call("java -jar "+ jarFile.getPath());
        Assert.assertTrue(result.isError());
    }
}