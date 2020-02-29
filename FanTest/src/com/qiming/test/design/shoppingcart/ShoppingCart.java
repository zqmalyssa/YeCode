package com.qiming.test.design.shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart extends Cart {

  private List<ItemAmount> items = new ArrayList();

  public List<ItemAmount> getItems() {
    return items;
  }

  public void setItems(List<ItemAmount> items) {
    this.items = items;
  }

  @Override
  public void addItem(Item item, int num) {

  }

  @Override
  protected int getProductInfo() {
    return 0;
  }

  @Override
  protected float getProductPrice() {
    return 0;
  }

  @Override
  protected float getFee() {
    return 0;
  }

  @Override
  protected float getTotalPrice() {
    return 0;
  }
}
