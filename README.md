# Microservices-tutotrial-v1
This tutorial is a small application that shows how an application based on a distributed architecture is organized using 
microservices. With 03 business microservices, a registration service and a proxy service (gateway).

## Architecture
### Eureka-service
- Simple spring boot service using Eureka-server.
### Gateway-service
- Simple spring boot service using spring-cloud-gateway to configure static and dynamic route, using spring-cloud-service breaker
### Customer-service
- Simple spring boot service using spring-data-rest (@RepositoryRestResource) to auto expose all rest api of customer entity.
### Product-service
- Simple spring boot service using spring-data-rest (@RepositoryRestResource) to auto expose all rest api of product entity.
### Billing-service
- Simple spring boot service using spring-data-rest (@RepositoryRestResource) to auto expose all rest api of bill and productItem entities. 
Also using feign client to consume local and remote rest api.

## Prerequisites
Java 8 or higher

## Start-up
You should run *eureka-service* first before running other services and run billing-service after 
*customer-service* and *product-service* have started because to initialize billing sample date it calls both *product-serve* and *customer-service*.
