package com.kaptan.data.factorydata.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Person implements Serializable {

  private Long id;

  private String name;

  private BigDecimal age;

  public Person(String name, BigDecimal age) {
    this.name = name;
    this.age = age;
  }
}
