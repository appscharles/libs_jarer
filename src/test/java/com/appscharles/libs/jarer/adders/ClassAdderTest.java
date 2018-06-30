package com.appscharles.libs.jarer.adders;

import com.appscharles.libs.jarer.builders.ManifestBuilder;
import com.appscharles.libs.jarer.creators.JarCreator;
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
import java.util.jar.Manifest;

/**
 * The type Class adder test.
 */
public class ClassAdderTest {

    /**
     * The Temp.
     */
    @Rule
    public TemporaryFolder temp = new TemporaryFolder();

    /**
     * Should create jar and run program.
     *
     * @throws IOException        the io exception
     * @throws JarerException     the jarer exception
     * @throws ProcesserException the processer exception
     */
    @Test
    public void shouldCreateJarAndRunProgram() throws IOException, JarerException, ProcesserException {
        File jarFile = new File(this.temp.newFolder(), "file.jar");
        Manifest manifest = ManifestBuilder.create("myApp", "1.0.0.0-dev2", Program.class).build();
        JarCreator jarCreator = new JarCreator(jarFile, manifest);
        jarCreator.addClass(Program.class);
        jarCreator.addClass(NamePrinter.class);
        jarCreator.create();
        ICommanderCaller commanderCaller = new CommanderCaller();
        CommanderResult result = commanderCaller.call("java -jar " + jarFile.getPath());
        Assert.assertFalse(result.getOutput(), result.isError());
        Assert.assertTrue(result.getOutput().contains("launched"));
    }
}