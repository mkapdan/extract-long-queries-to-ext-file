package com.kaptan.data.factorydata.repository;

import com.kaptan.data.factorydata.entity.Person;
import com.kaptan.data.factorydata.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

  User findUserByUsername(String username);

  @Query(value = "Select u FROM User u Where u.username = :userparam")
  User findUserWithNamed(@Param("userparam") String userparam);

  User selectByName(@Param("username") String username);

  @Query(name = "Person.ListAll", nativeQuery = true)
  List<Person> findAllPersonsFromNativeXml();

}
