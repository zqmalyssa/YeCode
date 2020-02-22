package com.qiming.test.constructor;

public abstract class BaseAction {
  private Action action;
  private Request request;

  public enum Action {
    CREATE,
    UPDATE,
    DELETE
  }

  class Request {

    private String id;
    private String poolId;
    private String businessId;
    private String regionName;
    private String projectId;

  }
}
