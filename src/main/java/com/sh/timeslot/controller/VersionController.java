package com.sh.timeslot.controller;

import com.sh.timeslot.common.ServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController (value ="/version")
public class VersionController {
    private ServiceConfig serviceConfig;

    @Autowired
    public VersionController(ServiceConfig serviceConfig) {
        this.serviceConfig = serviceConfig;
    }

    @RequestMapping(method={RequestMethod.GET})
    public String getVersion() {

        return serviceConfig.getVersion().toString();
    }
}