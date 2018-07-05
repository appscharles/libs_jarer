package com.appscharles.libs.jarer.programs.Logger;

import com.appscharles.libs.jarer.programs.Tester.Sub.NamePrinter;
import com.appscharles.libs.logger.configurations.Log4j2Configurator;
import com.appscharles.libs.logger.services.LoggerConfigurator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type Program logger.
 */
public class ProgramLogger {

    static {
        Log4j2Configurator config = new Log4j2Configurator(Level.DEBUG);
        LoggerConfigurator.config(config);
    }
    private static final Logger logger = LogManager.getLogger(ProgramLogger.class);

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String[] args){
        System.out.println("Program launched");
        logger.debug("debug");
        NamePrinter.print("myName");
    }
}
