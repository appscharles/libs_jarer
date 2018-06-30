package com.appscharles.libs.jarer.preparators;

import com.appscharles.libs.jarer.programs.Tester.Program;
import org.junit.Assert;
import org.junit.Test;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 29.06.2018
 * Time: 08:58
 * Project name: jarer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class PathClassPreparatorTest {

    @Test
    public void shouldPrepareClassNameToSpecificRequires(){
        Assert.assertFalse(PathPreparator.forJarEntry(Program.class).contains("\\"));
        Assert.assertTrue(PathPreparator.forJarEntry(Program.class).contains("/"));
        Assert.assertTrue(PathPreparator.forJarEntry(Program.class).endsWith(".class"));
    }
}