package com.kaptan.data.factorydata.service;

import com.kaptan.data.factorydata.entity.Person;
import com.kaptan.data.factorydata.repository.PersonRepositoryCustom;
import com.kaptan.data.factorydata.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

  private final UserRepository repository;

  private final PersonRepositoryCustom repositoryCustom;

  public List<Person> getPersonList() {
    return repositoryCustom.personList();
  }

  public Person getPerson(Long id) {
    return repositoryCustom.getPerson(id);
  }

  public List<Person> findAllPersons() {
    return repository.findAllPersonsFromNativeXml();
  }

}
