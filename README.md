# Nuts Read-me

This project has an objective to make a consumer of as API of Countries, 
and make some filters to delivery for your costumer.
For the construction of this service I used Spring for the architecture and 
FeignClient to consume a client service, the service have a little configuration inside the application.yaml
did only to FeignClient.

## Exercise 1

- For the first exercise I create a class DivisibleNumber only for this exercise, this clas have an Int number
and a loop to do the conditions of the exercise.

### How we can improve that it

We can make an improvement and this exercise with many ways.

- the first one is to create the method only to receive the variable value.
- The second one is to create the method to make a validation fot the conditions.

We can though many way for this, those two examples is only two more common to create. 

## Exercise 2

The Exercise 2 consist in to receive a json format with countries and list of languages for make some filters with the json.
<br/>
For simulate a mock with this endpoint I'm using MockApi.io, I created a project in this application and a method  GET to return 
our Json of countries.

<br/>
The endpoint of project as follows:
<br/>

- https://63b9974f3329392049f821c2.mockapi.io/countries

<br/>
For to receive the json, I'm using FeignClient make our code more simple and clean to read.

For each specification to this exercise was created a method inside controller class, and calls the service.
On the root of project we have a folder with mane postman, in this folder have a Nuts-service postman collection, 
and this collection have some examples to do tests of each endpoint inside the project.

## Unit Tests

The project hava unit tests for the was created a folder only to do a helper for write more clean and to separate better the things.
On the Controller folder we have integrations tests.