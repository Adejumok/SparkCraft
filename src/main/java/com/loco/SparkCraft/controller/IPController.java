package com.loco.SparkCraft.controller;

import com.loco.SparkCraft.service.IPProcessingService;
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
    public void processIPs(@RequestParam String filePath) {
        ipProcessingService.processIPs(filePath);
    }
}