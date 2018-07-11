package com.appscharles.libs.jarer.adders;

import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.jarer.removers.AutostartUserRemover;
import com.appscharles.libs.processer.callers.CommanderCaller;
import com.appscharles.libs.processer.callers.CommanderResult;
import com.appscharles.libs.processer.callers.ICommanderCaller;
import com.appscharles.libs.processer.exceptions.ProcesserException;

import java.io.File;
import java.text.MessageFormat;

/**
 * The type Autostart system adder.
 */
public class AutostartUserAdder {

    /**
     * Add.
     *
     * @throws JarerException the jarer exception
     */
    public static void add(String key, File executableFile) throws JarerException {
        try {
            AutostartUserRemover.remove(key);
            final String REG_ADD_CMD = "cmd /c reg add \"HKEY_CURRENT_USER\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run\" /v \"{0}\" /d \"{1}\" /t REG_SZ";
            String cmdLine = MessageFormat.format(REG_ADD_CMD, new Object[]{"\""+ key + "\"", "\""+ executableFile.getAbsolutePath() + "\""});
            ICommanderCaller caller = new CommanderCaller();
            CommanderResult result = caller.call(cmdLine);
            if (result.isError()) {
                throw new JarerException(result.getOutput());
            }
        } catch (ProcesserException e) {
            throw new JarerException(e);
        }
    }
}
