package com.loco.SparkCraft.config;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.SparkSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SparkConfig {

    @Bean
    public SparkSession sparkSession() {
        SparkConf sparkConf = new SparkConf().setAppName("IPProcessing").setMaster("local[*]");
        return SparkSession.builder().config(sparkConf).getOrCreate();
    }
}
