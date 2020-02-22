package com.qiming.pom.mockito;

public interface PersonDao {

  Person getPerson(int id);
  boolean update(Person person);

}
