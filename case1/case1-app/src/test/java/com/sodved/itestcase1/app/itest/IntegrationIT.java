package com.sodved.itestcase1.app.itest;

import com.sodved.itestcase1.app.service.AppService;
import com.sodved.itestcase1.lib.service.LibService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith({SpringExtension.class})
@SpringBootTest(classes=DummyApplicationContext.class)
public class IntegrationIT {

    @Autowired
    private LibService libService;

    @Autowired
    private AppService appService;

    @Test
    public void testApplicationLoaded() {
        log.info("Application loaded OK");
    }

    @Test
    public void testLibSerivce() {
        log.info("Lib Service: {}", libService.getServiceName());
    }

    @Test
    public void testAppSerivce() {
        log.info("App Service: {}", appService.getServiceName());
    }

}
