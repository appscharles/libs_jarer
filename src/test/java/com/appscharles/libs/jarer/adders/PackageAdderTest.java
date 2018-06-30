package com.appscharles.libs.jarer.adders;

import com.appscharles.libs.jarer.builders.JarCreatorBuilder;
import com.appscharles.libs.jarer.creators.IJarCreator;
import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.programs.Empter.Program3;
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

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 29.06.2018
 * Time: 11:01
 * Project name: jarer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class PackageAdderTest {

    @Rule
    public TemporaryFolder temp = new TemporaryFolder();

    @Test
    public void shouldCreateJarAndRunProgram() throws IOException, JarerException, ProcesserException {
        File jarFile = new File(this.temp.newFolder(), "file.jar");
        IJarCreator jarCreator = JarCreatorBuilder.create("myApp", "1.0.0.0-dev2", Program3.class, jarFile).build();
        jarCreator.addPackage(Program3.class.getPackage().getName());
        jarCreator.create();
        ICommanderCaller commanderCaller = new CommanderCaller();
        CommanderResult result = commanderCaller.call("java -jar " + jarFile.getPath());
        Assert.assertFalse(result.getOutput(), result.isError());
        Assert.assertTrue(result.getOutput().contains("launched"));
    }

}