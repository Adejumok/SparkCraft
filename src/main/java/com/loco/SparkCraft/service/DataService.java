package com.loco.SparkCraft.service;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Autowired
    private SparkSession sparkSession;

    public void processData() {
        Dataset<Row> df = sparkSession.read().option("header", "true").csv("src/main/resources/SPARK_DATA.csv");

        Dataset<Row> result = df.groupBy("product").sum("revenue");

        result.show();
    }
}
