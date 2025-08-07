# Tech Stack: Ingredient Safety Scanner

This document outlines the recommended technology stack for the backend of the Ingredient Safety Scanner project, built with Java and Spring Boot.

# Tech Stack: Ingredient Safety Scanner

This document outlines the recommended technology stack for the backend of the Ingredient Safety Scanner project, built with Java and Spring Boot.

## Backend

- **Core Framework:** [**Spring Boot**](https://spring.io/projects/spring-boot)
  - *Reasoning:* Provides a robust, convention-over-configuration framework for building RESTful APIs quickly and efficiently.

- **Language:** [**Java 17+**](https://www.oracle.com/java/)
  - *Reasoning:* A mature, stable, and high-performance language with a vast ecosystem of libraries and tools.

- **API Layer:** [**Spring Web**](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
  - *Reasoning:* The standard module for building web applications and RESTful APIs in Spring.

- **External API Communication:** [**Spring RestTemplate or WebClient**](https://docs.spring.io/spring-framework/reference/integration/rest-clients.html)
  - *Reasoning:* These are the standard Spring tools for making HTTP requests to external services, such as the Open Food Facts API.

- **OCR (Optical Character Recognition):** [**Tess4J**](http.tess4j.sourceforge.net/) or a Cloud-based Vision API
  - *Reasoning:* To fulfill requirement **FR4**, an OCR solution is necessary. 
    - **Tess4J** is a Java wrapper for the Tesseract OCR engine, which can be self-hosted.
    - **Google Cloud Vision / AWS Textract** are powerful, managed alternatives that may offer higher accuracy.

- **Build Tool:** [**Maven**](https://maven.apache.org/)
  - *Reasoning:* A standard build automation tool for Java projects, used for managing dependencies and packaging the application.

## Database

- **Primary Database:** None at this stage.

