package com.loco.SparkCraft.service;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.apache.spark.sql.functions.col;

@Service
public class IPProcessingService {

    @Autowired
    private SparkSession sparkSession;

    private static final String IPV4_REGEX = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
            + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
            + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
            + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

    private static final String IPV6_REGEX = "([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|"
            + "([0-9a-fA-F]{1,4}:){1,7}:|"
            + "([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|"
            + "([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|"
            + "([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|"
            + "([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|"
            + "([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|"
            + "[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|"
            + ":((:[0-9a-fA-F]{1,4}){1,7}|:)|"
            + "fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|"
            + "::(ffff(:0{1,4}){0,1}:){0,1}"
            + "((25[0-5]|(2[0-4]|1{0,1}[0-9]|)[0-9])\\.){3,3}"
            + "(25[0-5]|(2[0-4]|1{0,1}[0-9]|)[0-9])|"
            + "([0-9a-fA-F]{1,4}:){1,4}:"
            + "((25[0-5]|(2[0-4]|1{0,1}[0-9]|)[0-9])\\.){3,3}"
            + "(25[0-5]|(2[0-4]|1{0,1}[0-9]|)[0-9])";

    public void  processIPs(String filePath) {
        Dataset<Row> df = sparkSession.read().option("header", "true").csv(filePath);

        Dataset<Row> validatedIPv4 = df.withColumn("isValidIPv4", col("ip_address").rlike(IPV4_REGEX));

        Dataset<Row> validatedIPv6 = df.withColumn("isValidIPv6", col("ip_address").rlike(IPV6_REGEX));

        validatedIPv4.show(false);
        validatedIPv6.show(false);

    }
}
