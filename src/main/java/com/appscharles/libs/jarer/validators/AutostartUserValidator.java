package com.appscharles.libs.jarer.validators;

import com.appscharles.libs.jarer.exceptions.JarerException;
import com.appscharles.libs.processer.callers.CommanderCaller;
import com.appscharles.libs.processer.callers.CommanderResult;
import com.appscharles.libs.processer.callers.ICommanderCaller;
import com.appscharles.libs.processer.exceptions.ProcesserException;

import java.text.MessageFormat;

/**
 * The type Autostart user remover.
 */
public class AutostartUserValidator {

    /**
     * Remove.
     *
     * @param key the key
     * @throws JarerException the jarer exception
     */
    public static Boolean exist(String key) throws JarerException {
        try {
            final String REG_ADD_CMD = "cmd /c REG QUERY \"HKEY_CURRENT_USER\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run\" /v \"{0}\"";
            String cmdLine = MessageFormat.format(REG_ADD_CMD, new Object[]{"\""+ key + "\""});
            ICommanderCaller caller = new CommanderCaller();
            CommanderResult result = caller.call(cmdLine);
            if (result.isError() && result.getOutput().contains("unable to find")){
                return false;
            } else if (result.isError()){
                throw new JarerException("Error validate exist ket in registry.");
            }
        } catch (ProcesserException e) {
            throw new JarerException(e);
        }
        return true;
    }
}
