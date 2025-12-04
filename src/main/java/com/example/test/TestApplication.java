package com.example.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
Overview:
Build the following functionalities of a concurrent order management system. Define an order entity of your choice having multiple order items.
Requirements:
Develop a RESTful API using Java Spring Boot to handle concurrent operations for managing orders.
Implement following endpoints:
Creating a new order ( Order can contain one or more order items)
Updating the status of an order
Utilize concurrent data structures or mechanisms to support concurrent access to orders.

Am i audible>
Order -- Phone-- charger
Status -- order placed -- in way -- delivered
create a new order -- Phone --
POST /craete_order(phoen)
PUT status_update(Status staus)


 */

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

}
