package com.appscharles.libs.jarer.programs.Packager;

import com.appscharles.libs.ioer.services.DirReader;
import com.appscharles.libs.jarer.builders.JarCreatorBuilder;
import com.appscharles.libs.jarer.builders.ManifestBuilder;
import com.appscharles.libs.jarer.creators.IJarCreator;
import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.programs.Direr.Direr;
import com.appscharles.libs.processer.callers.CommanderCaller;
import com.appscharles.libs.processer.callers.CommanderResult;
import com.appscharles.libs.processer.callers.ICommanderCaller;
import com.appscharles.libs.processer.exceptions.ProcesserException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.jar.Manifest;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 12.07.2018
 * Time: 16:11
 * Project name: jarer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class PackagerTest {

    @Rule
    public TemporaryFolder temp = new TemporaryFolder();

    @Test
    public void shouldRunDirerJar() throws IOException, JarerException, ProcesserException {
        File jarFile = new File(this.temp.newFolder(), "file22.jar");
        Manifest manifest = ManifestBuilder.create("myApp", "1.0.0.0-dev2", Packager.class).build();
        IJarCreator jarCreator = JarCreatorBuilder.create("myApp", "1.0.0.0-dev2", Packager.class, jarFile)
                .addDependency("com/appscharles/libs/jarer", Direr.class.getProtectionDomain().getCodeSource().getLocation())
                .addDependency("com/appscharles/libs/ioer", DirReader.class.getProtectionDomain().getCodeSource().getLocation())
                .build();
        jarCreator.create();
        ICommanderCaller commanderCaller = new CommanderCaller();
        CommanderResult result = commanderCaller.call("java -jar " + jarFile.getPath());
        Assert.assertFalse(result.getOutput(), result.isError());
    }
}