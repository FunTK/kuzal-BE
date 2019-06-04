package com.kuzal.kuzalcompetition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class KuzalcompetitionApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(KuzalcompetitionApplication.class);
        application.addListeners(new ApplicationPidFileWriter());
        application.run(args);
    }

}
