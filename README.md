# Transaction-Spring
### Real-Time Bitcoin Trading System

## Project Overview
- This project is a real-time Bitcoin trading platform that allows users to buy and sell Bitcoin.
- **Technology Stack**: Spring Cloud, Spring MVC, Spring Boot, Docker, Kafka, Redis, MySQL, Zookeeper, Python.

## Functional Modules
- **Config**:
    - Spring Cloud configuration server, providing configuration information for other microservices.
- **Common**:
    - Includes common services and classes used by various microservices.
    - Contains a custom ORM framework, a wrapper class for JdbcTemplate.
        - Implements convenient chain queries for simple operations.
        - Allows direct use of JdbcTemplate for complex operations.
- **Trading Engine**:
    - Contains asset trading computation, order processing, and matching features.
    - Processes orders sequenced by the Sequencer module and retrieves them from Kafka.
    - Generates tick information and sends it to Kafka.
- **Trading API**:
    - Responsible for handling various API requests.
    - Includes multiple security authentication features, such as username/password, Token, and API Key.
    - Securely calls other internal APIs and sends received order messages to the Sequencer for sequencing via Kafka.
- **Sequencer**:
    - Responsible for assigning a unique sequence number to orders.
- **Quotation**:
    - Retrieves tick information from Kafka, generates various types of K-line charts.
    - Stores the latest K-line charts in Redis.
- **Push**:
    - Establishes WebSocket through Vert.x and subscribes to Redis notifications, pushing messages to clients.
- **UI**:
    - The system's interface, implemented with Vue.js.

## Technical Details
- **Docker**:
    - Uses Docker for containerized deployment, including services like Kafka, Redis, MySQL, Zookeeper.
- **Database**:
    - Utilizes MySQL database, includes complete SQL database files.
- **Data Generation**:
    - Uses Python scripts to generate simulated trading data.
