package com.kaptan.data.factorydata.repository;

import com.kaptan.data.factorydata.entity.Person;

import java.util.List;

public interface PersonRepositoryCustom {

  Person getPerson(Long id);

  List<Person> personList();
}
