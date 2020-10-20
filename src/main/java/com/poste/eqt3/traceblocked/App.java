/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poste.eqt3.traceblocked;

import com.poste.eqt3.traceblocked.utils.ListFiles;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.File;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 *
 * @author Alex
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.poste")
@Configuration
@PropertySource("classpath:traceblocked.properties")
public class App
    implements CommandLineRunner {

  final static Logger logger
    = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

  @Override
  public void run (String... args) {
    logger.info("Starting EQT3 Trace Blocked Tool version "+this.version);
    logger.debug("listing files in directory '"+lsfFiles.getPath()+"'");
    try {
      File[] files
        = lsfFiles.list();
      if (files!=null) {
        logger.debug("prepare for examining files");
        for (int i = 0; i < files.length; i++) {
          if (files[i].isFile()) {
            logger.debug("File '" + files[i].getName() + "'");
          } else if (files[i].isDirectory()) {
            logger.debug("Directory " + files[i].getName());
          }
        } // for        
      } // if
    } // try
    catch (Exception ex) {
      logger.error(ex.getLocalizedMessage());
    } // catch
  }

  @Value("${version}")
  private String version;

  @Autowired
  private ListFiles lsfFiles;

} // class App
