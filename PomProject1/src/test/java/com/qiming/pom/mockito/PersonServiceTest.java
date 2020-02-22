package com.qiming.pom.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.LinkedList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class PersonServiceTest {

  private PersonDao     mockDao;
  private PersonService personService;

  //前置mock设置
  @Before
  public void setUp() throws Exception {
    //模拟PersonDao对象
    mockDao = mock(PersonDao.class);
    when(mockDao.getPerson(1)).thenReturn(new Person(1, "Person1"));
    when(mockDao.update(isA(Person.class))).thenReturn(true);

    personService = new PersonService(mockDao);
  }

  //执行成功
  @Test
  public void testUpdate() throws Exception {
    boolean result = personService.update(1, "new name");
    assertTrue("must true", result);
    //验证是否执行过一次getPerson(1)
    verify(mockDao, times(1)).getPerson(eq(1));
    //验证是否执行过一次update
    verify(mockDao, times(1)).update(isA(Person.class));
  }

  //执行失败
  @Test
  public void testUpdateNotFind() throws Exception {
    boolean result = personService.update(2, "new name");
    assertFalse("must true", result);
    //验证是否执行过一次getPerson(1)
    verify(mockDao, times(1)).getPerson(eq(1));
    //验证是否执行过一次update
    verify(mockDao, never()).update(isA(Person.class));
  }


  //可以mock的东西还有java的接口list
  @Test
  public void testVerify() throws Exception {
    //mock creation
    List mockedList = mock(List.class);

    //using mock object
    mockedList.add("one");
    mockedList.add("two");
    mockedList.add("two");
    mockedList.clear();

    //verification
    verify(mockedList).add("one");//验证是否调用过一次 mockedList.add("one")方法，若不是（0次或者大于一次），测试将不通过
    verify(mockedList, times(2)).add("two");
    //验证调用过2次 mockedList.add("two")方法，若不是，测试将不通过
    verify(mockedList).clear();//验证是否调用过一次 mockedList.clear()方法，若没有（0次或者大于一次），测试将不通过
  }


  //可以mock的东西还有java的具体类linkedlist
  @Test
  public void testStubbing() throws Exception {
    //你可以mock具体的类，而不仅仅是接口
    LinkedList mockedList = mock(LinkedList.class);

    //设置桩
    when(mockedList.get(0)).thenReturn("first");
    when(mockedList.get(1)).thenThrow(new RuntimeException());

    //打印 "first"
    System.out.println(mockedList.get(0));

    //这里会抛runtime exception
    System.out.println(mockedList.get(1));

    //这里会打印 "null" 因为 get(999) 没有设置
    System.out.println(mockedList.get(999));

    //Although it is possible to verify a stubbed invocation, usually it's just redundant
    //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
    //If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
    verify(mockedList).get(0);
  }

}
