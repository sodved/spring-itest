package com.sodved.itestcase1.app;

import com.sodved.itestcase1.app.service.AppService;
import com.sodved.itestcase1.lib.service.LibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableScheduling
@EnableAsync(proxyTargetClass=true)
@SpringBootApplication(scanBasePackages={"com.sodved.itestcase1"})
public class Case1Application implements CommandLineRunner {

    @Autowired
    private LibService libService;

    @Autowired
    private AppService appService;

    public static void main(String[] args) {
        log.info("STARTING THE APPLICATION");
        ConfigurableApplicationContext context = SpringApplication.run(Case1Application.class, args);
        log.info("APPLICATION FINISHED");
        context.close();
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Application running...");
        log.info("Lib Service: {}", libService.getServiceName());
        log.info("App Service: {}", appService.getServiceName());
    }

}
