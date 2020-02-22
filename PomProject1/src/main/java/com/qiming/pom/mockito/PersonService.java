package com.qiming.pom.mockito;

public class PersonService {
  private final PersonDao personDao;

  public PersonService(PersonDao personDao) {
    this.personDao = personDao;
  }

  //在开发过程中，PersonDAO很可能尚未开发完成，那就mock一个PersonDAO对象
  public boolean update(int id, String name) {
    Person person = personDao.getPerson(id);
    if (person == null) {
      return false;
    }

    Person personUpdate = new Person(person.getId(), name);
    return personDao.update(personUpdate);
  }
}
