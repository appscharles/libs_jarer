package com.appscharles.libs.jarer.adders;

import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.removers.AutostartUserRemover;
import org.junit.Test;

import java.io.File;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 11.07.2018
 * Time: 14:35
 * Project name: jarer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class AutostartSystemAdderTest {

    @Test
    public void shouldAddKeyAndValue() throws JarerException {
        AutostartUserRemover.remove("key.jar");
        AutostartUserAdder.add("key.jar", new File("exe.jar"));
        AutostartUserRemover.remove("key.jar");
    }
}