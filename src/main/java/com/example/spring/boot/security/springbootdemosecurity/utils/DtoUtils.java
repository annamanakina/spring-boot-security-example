package com.example.spring.boot.security.springbootdemosecurity.utils;

import org.modelmapper.ModelMapper;



public class DtoUtils {

//todo do like here!!!
    //todo https://stackoverflow.com/questions/32711436/service-dao-pattern-dto-and-relational-database

    //todo https://www.javadevjournal.com/spring/data-conversion-spring-rest-api/

    //todo https://habr.com/ru/post/343960/
    //todo https://lankydanblog.com/2017/03/11/passing-data-transfer-objects-with-get-in-spring-boot/

    public DTOEntity convertToDto(Object obj, DTOEntity mapper) {
        return new ModelMapper().map(obj, mapper.getClass());
    }

    public Object convertToEntity(Object obj, DTOEntity mapper) {
        return new ModelMapper().map(mapper, obj.getClass());
    }

    /*DTO is an abbreviation for Data Transfer Object, so it is used to transfer the data between classes and modules of your application.
     DTO should only contain private fields for your data, getters, setters and constructors.
     It is not recommended to add business logic methods to such classes, but it is OK to add some util methods.

     DTO is an object that carries data between processes. When you're working with a remote interface, each call it is expensive.
     As a result you need to reduce the number of calls. The solution is to create a Data Transfer Object that can hold all the data for the call.
     It needs to be serializable to go across the connection. Usually an assembler is used on the server side to transfer data between the DTO and any domain objects.
     It's often little more than a bunch of fields and the getters and setters for them.

DAO is an abbreviation for Data Access Object, so it should encapsulate the logic for retrieving,
saving and updating data in your data storage (a database, a file-system, whatever).
Here is an example how the DAO and DTO interfaces would look like:

interface PersonDTO {
    String getName();
    void setName(String name);
    //.....
}

interface PersonDAO {
    PersonDTO findById(long id);
    void save(PersonDTO person);
    //.....
}*/
}
