# SparkCraft Project

This project is a sample implementation of a Spring Boot application integrated with Apache Spark. It demonstrates how to run Spark jobs within a Spring Boot context and includes a specific IP processing service.

## Project Structure

- `src/main/java`: Contains the Java source code.
- `src/main/resources`: Contains application configuration files.
- `pom.xml`: Maven configuration file.
- `README.md`: This file.

## Requirements

- Java 11 or later
- Apache Maven
- Apache Spark 3.1.2 or later(compatible with Scala 2.12)
- IntelliJ IDEA or another preferred IDE

## Installation

### Prerequisites

1. **Java**: Ensure Java is installed on your system.
   ```bash
   java -version

2. **Maven**: Ensure Maven is installed on your system.
   ```bash
   mvn -version

4. **Apache Spark**: Download and extract Apache Spark.
   ```bash
   https://downloads.apache.org/spark

5. **Set Environment Variables**: Set environment variables for Spark and Java.
   Add the following to your .bashrc, .zshrc, or equivalent file.
   ```bash
   export SPARK_HOME=/path/to/spark-3.1.2-bin-hadoop3.2
   export PATH=$PATH:$SPARK_HOME/bin
   export JAVA_HOME=/path/to/java11

## Project Setup
1. **Clone the repository**:
   ```bash    
   git clone https://github.com/Adejumok/SparkCraft.git
   cd SparkCraft
2. **Build the project**:
   ```bash
   mvn clean install







