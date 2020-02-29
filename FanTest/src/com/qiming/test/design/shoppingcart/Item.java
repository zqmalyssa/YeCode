package com.qiming.test.design.shoppingcart;

import java.io.Serializable;

public class Item extends Sku implements Serializable {

  private static final long serialVersionUID = 1L;

  private boolean isHave = true;

  enum Color {
    RED,
    GREEN,
    BLACK,
  }

  enum Size {
    S,
    M,
    L,
    XL,
  }

  private int productId;

  private String description;

  private int price;

  private int star;

  public boolean isHave() {
    return isHave;
  }

  public void setHave(boolean have) {
    isHave = have;
  }

  @Override
  public int hashCode() {
    int result = productId;
    result = 31 * result + price;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) //比较地址
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;
    Item other = (Item) obj;
    return this.productId == other.productId && this.price == other.price;
  }


}
