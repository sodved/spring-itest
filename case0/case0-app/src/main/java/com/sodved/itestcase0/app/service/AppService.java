package com.sodved.itestcase0.app.service;

import org.springframework.stereotype.Service;

@Service
public class AppService {

    public String getServiceName() {
        return this.getClass().getCanonicalName();
    }
}
