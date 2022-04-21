package com.sodved.itestcase1.lib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibService {

    public String getServiceName() {
        return this.getClass().getCanonicalName();
    }

}
