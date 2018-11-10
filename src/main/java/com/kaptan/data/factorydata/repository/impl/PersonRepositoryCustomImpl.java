package com.kaptan.data.factorydata.repository.impl;

import com.kaptan.data.factorydata.entity.Person;
import com.kaptan.data.factorydata.repository.PersonRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

  @PersistenceContext
  private EntityManager em;

  @Override
  public Person getPerson(Long id) {
    Query query = em.createNamedQuery("Person.SearchById");
    query.setParameter("id", new Long("2"));
    List<Person> persons = query.getResultList();
    Person person = persons.get(0);
    System.out.println("Person First : " + person);
    return person;
  }

  @Override
  public List<Person> personList() {
    Query query = em.createNamedQuery("Person.ListAll");
    List<Person> persons = query.getResultList();
    return persons;
  }
}
