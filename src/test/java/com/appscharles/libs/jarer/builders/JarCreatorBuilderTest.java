package com.appscharles.libs.jarer.builders;

import com.appscharles.libs.jarer.creators.IJarCreator;
import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.programs.Tester.Program;
import com.appscharles.libs.jarer.programs.Tester.Sub.NamePrinter;
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
 * The type Jar creator builder test.
 */
public class JarCreatorBuilderTest {


    /**
     * The Temp.
     */
    @Rule
    public TemporaryFolder temp = new TemporaryFolder();

    /**
     * Should create jar file and launch.
     *
     * @throws IOException        the io exception
     * @throws JarerException     the jarer exception
     * @throws ProcesserException the processer exception
     */
    @Test
    public void shouldCreateJarFileAndLaunch() throws IOException, JarerException, ProcesserException {
        File jarFile = new File(this.temp.newFolder(), "file.jar");
        IJarCreator jarCreator = JarCreatorBuilder.create("myApp", "1.0.0.0-dev2", Program.class, jarFile).build();
        jarCreator.addClass(Program.class);
        jarCreator.addClass(NamePrinter.class);
        jarCreator.create();
        ICommanderCaller commanderCaller = new CommanderCaller();
        CommanderResult result = commanderCaller.call("java -jar " + jarFile.getPath());
        Assert.assertFalse(result.getOutput(), result.isError());
        Assert.assertTrue(result.getOutput().contains("launched"));
    }
}