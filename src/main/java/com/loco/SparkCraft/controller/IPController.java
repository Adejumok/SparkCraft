package com.loco.SparkCraft.controller;

import com.loco.SparkCraft.service.IPProcessingService;
import org.apache.logging.log4j.core.config.plugins.PluginLoggerContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api")
public class IPController {

    @Autowired
    private IPProcessingService ipProcessingService;

    @GetMapping("/process-ips")
    public String processIPs(@RequestParam String filePath) {
        try {
            ipProcessingService.processIPs(filePath);
            return "IP processing started successfully.";
        } catch (Exception e) {
            return "Error occurred: " + e.getMessage();
        }
    }
}