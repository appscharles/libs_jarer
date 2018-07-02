package com.appscharles.libs.jarer.programs.Logger;

import com.appscharles.libs.jarer.programs.Tester.Sub.NamePrinter;
import com.appscharles.libs.logger.configurations.Log4j2Configurator;
import com.appscharles.libs.logger.services.LoggerConfigurator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 02.07.2018
 * Time: 15:15
 * Project name: jarer
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class ProgramLogger {

    static {
        Log4j2Configurator config = new Log4j2Configurator(Level.DEBUG);
        LoggerConfigurator.config(config);
    }
    private static final Logger logger = LogManager.getLogger(ProgramLogger.class);

    public static void main(String[] args){
        System.out.println("Program launched");
        logger.debug("debug");
        NamePrinter.print("myName");
    }
}
