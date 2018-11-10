package com.kaptan.data.factorydata.controller;

import com.kaptan.data.factorydata.entity.Person;
import com.kaptan.data.factorydata.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/native-query/persons")
@RequiredArgsConstructor
public class PersonController {

  private final PersonService personService;

  @GetMapping(path = "/by-jpa", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Person> getPersonFullByJPA() {
    return personService.findAllPersons();
  }

  @GetMapping(path = "/by-em", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Person> getPersonFullEntityManager() {
    return personService.getPersonList();
  }

  @GetMapping(path = "/partial-map/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Person getPersonPartial(@PathVariable("userId") Long userId) {
    return personService.getPerson(userId);
  }

}
