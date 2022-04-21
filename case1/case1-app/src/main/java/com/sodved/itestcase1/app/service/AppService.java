package com.sodved.itestcase1.app.service;

import org.springframework.stereotype.Service;

@Service
public class AppService {

    public String getServiceName() {
        return this.getClass().getCanonicalName();
    }
}
