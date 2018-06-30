package com.appscharles.libs.jarer.preparators;

import com.appscharles.libs.jarer.programs.Tester.Program;
import org.junit.Assert;
import org.junit.Test;

/**
 * The type Path class preparator test.
 */
public class PathClassPreparatorTest {

    /**
     * Should prepare class name to specific requires.
     */
    @Test
    public void shouldPrepareClassNameToSpecificRequires(){
        Assert.assertFalse(PathPreparator.forJarEntry(Program.class).contains("\\"));
        Assert.assertTrue(PathPreparator.forJarEntry(Program.class).contains("/"));
        Assert.assertTrue(PathPreparator.forJarEntry(Program.class).endsWith(".class"));
    }
}