# Kogito Template for CIB Seven External Tasks

This project shows how Kogito can be used as a BPMN-driven external task worker for CIB Seven / Camunda 7 compatible external tasks.

It contains:

- a polling worker process that fetches and locks external tasks from CIB Seven
- a handler process that completes external tasks back to CIB Seven
- a simple Kogito service-task example for local process and API experimentation
- Quarkus Dev UI, Swagger UI, health checks, and a testable Java service layer

# Advantages

## Decision Makers

The process itself becomes living documentation. Business and technical stakeholders can understand which task is fetched, how it is processed, and how it is completed without reverse-engineering large amounts of Java code.

## Developers

The service logic stays small and explicit. BPMN models describe orchestration, while Java beans focus on business logic and remote calls. This keeps the project easier to test, easier to extend, and easier to discuss with non-developers.

## Reusable Company No-Code Repository

Kogito makes it straightforward to build reusable internal process patterns. Fetching, handling, and completing external tasks can be modeled once and adapted for additional services with less boilerplate and more consistency.

# Included Processes

This repository currently contains these BPMN examples:

- `ShortPollWorkerExample.bpmn`
  Fetches and locks external tasks from CIB Seven via `CibSevenFunctions.fetchAndLock(...)`
- `ShortPollHandlerExample.bpmn`
  Completes external tasks in CIB Seven via `CibSevenFunctions.complete(...)`
- `ComplexServiceExample.bpmn`
  Demonstrates a plain Kogito service task using `ServiceExample.doSomething(...)`

# Project Structure

- `src/main/resources/BPMN`
  BPMN process definitions
- `src/main/java/de/cib/kogito/worker/cibs`
  CIB Seven REST client and helper functions used by service tasks
- `src/main/java/de/cib/kogito/worker/service`
  Example business service for direct BPMN service-task usage
- `src/test/java`
  Integration test for the `ComplexServiceExample` process

# How to use it

To experiment with the processes, open the project in Visual Studio Code and use the Kogito / BPMN tooling for modeling.

## Configure the target system

Set the CIB Seven REST base URL in [application.properties](/Users/mp/Documents/VSC-Projekte/Know-How/kogito/Kogito%20CIB%20Flow%20External%20Task%20Worker/src/main/resources/application.properties):

```properties
quarkus.rest-client.cib-seven.url=http://localhost:7093
cib-seven.auth.username=demo
cib-seven.auth.password=demo
```

Adjust these values to the CIB Seven / Camunda 7 engine and credentials you want to call.

## Start the service

Development mode:

```bash
mvn quarkus:dev
```

Build and test:

```bash
mvn clean install
```

# How to use Quarkus

Start developing:

```bash
mvn quarkus:dev
```

Open Quarkus Dev UI:

- press `d` in the terminal, or
- open `http://localhost:8080/q/dev`

Open Swagger UI:

- `http://localhost:8080/q/swagger-ui`

Change code and continue developing:

- save the file, Quarkus reloads automatically

Change BPMN models and continue modeling:

- save the BPMN file, Kogito reloads generated assets automatically

# API first?!

Yes. Kogito generates REST endpoints for the BPMN processes, and Quarkus exposes OpenAPI documentation automatically.

Once the application is running, you can inspect generated schemas and process endpoints in Swagger UI. This is especially useful for:

- process input models
- process output models
- service-task payload structures

# How to write delegates to use services in your process

Usually, you do not need delegate boilerplate here.

Write a normal Java bean, annotate it as a CDI bean such as `@Singleton`, and reference it from a BPMN service task.

This repository includes:

- `ServiceExample`
  A simple Java service called directly from `ComplexServiceExample.bpmn`
- `CibSevenFunctions`
  A helper bean used by BPMN service tasks to fetch, complete, and fail CIB Seven external tasks

# Test

A simple integration test is included in [ComplexServiceExampleProcessIT.java](/Users/mp/Documents/VSC-Projekte/Know-How/kogito/Kogito%20CIB%20Flow%20External%20Task%20Worker/src/test/java/de/cib/kogito/worker/process/ComplexServiceExampleProcessIT.java).

It verifies that:

- the `ComplexServiceExample` process completes
- the process output contains the expected `resultText`

# Notes

- The project uses Quarkus `3.15.3` and Kogito `10.1.0`
- Kogito Dev Services are disabled in local config to avoid automatic Data Index container startup during development
- The banner displayed in dev mode is configured in `application.properties`

Copyright 2026 www.PiU.de
