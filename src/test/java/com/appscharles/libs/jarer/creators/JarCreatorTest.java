package com.appscharles.libs.jarer.creators;

import com.appscharles.libs.jarer.builders.ManifestBuilder;
import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.models.Dependency;
import com.appscharles.libs.jarer.programs.Logger.ProgramLogger;
import com.appscharles.libs.logger.configurations.Log4j2Configurator;
import com.appscharles.libs.processer.callers.CommanderCaller;
import com.appscharles.libs.processer.callers.CommanderResult;
import com.appscharles.libs.processer.callers.ICommanderCaller;
import com.appscharles.libs.processer.exceptions.ProcesserException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Core;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.jar.Manifest;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 13.07.2018
 * Time: 20:26
 * Project name: jarer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class JarCreatorTest {

    @Rule
    public TemporaryFolder temp = new TemporaryFolder();

    @Test
    public void shouldAddLocationsToJar() throws IOException, JarerException, URISyntaxException, ProcesserException {
        File jarFile = new File(this.temp.newFolder(), "file.jar");
        Manifest manifest = ManifestBuilder.create("myApp", "1.0.0.0-dev2", ProgramLogger.class).build();
        IJarCreator jarCreator2 = new JarCreator(jarFile, manifest);

        jarCreator2.addDependency("com", Dependency.class.getProtectionDomain().getCodeSource().getLocation());
        jarCreator2.addDependency("com", Log4j2Configurator.class.getProtectionDomain().getCodeSource().getLocation());
        jarCreator2.addDependency("org", Level.class.getProtectionDomain().getCodeSource().getLocation());
        jarCreator2.addDependency("META-INF/services", Level.class.getProtectionDomain().getCodeSource().getLocation());

        jarCreator2.addDependency("org", Core.class.getProtectionDomain().getCodeSource().getLocation());
        jarCreator2.addDependency("META-INF/services", Core.class.getProtectionDomain().getCodeSource().getLocation());
        jarCreator2.create();
        ICommanderCaller commanderCaller = new CommanderCaller();
        CommanderResult result = commanderCaller.call("java -jar " + jarFile.getPath());
        Assert.assertFalse(result.getOutput(),result.isError());
        Assert.assertTrue(result.getOutput().contains("ProgramLogger launched"));
    }
}