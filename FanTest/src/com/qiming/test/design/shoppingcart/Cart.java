package com.qiming.test.design.shoppingcart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 有四个问题：
 *
 * 1）用户没登陆用户名和密码,添加商品, 关闭浏览器再打开后 不登录用户名和密码　问：购物车商品还在吗？
 *
 * 2）用户登陆了用户名密码,添加商品,关闭浏览器再打开后 不登录用户名和密码　问:购物车商品还在吗？
 *
 * 3）用户登陆了用户名密码,添加商品, 关闭浏览器,然后再打开,登陆用户名和密码  问:购物车商品还在吗？
 *
 * 4）用户登陆了用户名密码,添加商品, 关闭浏览器 外地老家打开浏览器  登陆用户名和密码 问：购物车商品还在吗？
 *
 * 京东来看，分别是
 *
 * １）在，户没有登录, 添加商品, 此时的商品是被添加到了浏览器的Cookie中, 所以当再次访问时(不登录),商品仍然在Cookie中, 所以购物车中的商品还是存在的.
 * ２）不在了，用户登录了,添加商品, 此时会将Cookie中和用户选择的商品都添加到购物车中, 然后删除Cookie中的商品. 所以当用户再次访问(不登录),此时Cookie中的购物车商品已经被删除了, 所以此时购物车中的商品不在了.
 * ３）在，用户登录, 添加商品,此时商品被添加到数据库做了持久化存储, 再次打开登录用户名和密码, 该用户选择的商品肯定还是存在的, 所以购物车中的商品还是存在的.
 * ４）在，同3
 *
 * 这里再说下 没登录 保存商品到Cookie的优点以及保存到Session和数据库的对比:
 * 1: Cookie：优点：保存用户浏览器（不用浪费我们公司的服务器） 缺点：Cookie禁用，不提供保存
 * 2: Session：（Redis ：浪费大量服务器内存：实现、禁用Cookie） 速度很快
 * 3: 数据库（Mysql、Redis、SOlr） 能持久化的就数据库 速度太慢
 *
 * 用户没登陆：购物车添加到Cookie中
 * 用户登陆：保存购物车到Redis中 （不用数据库）
 *
 * 加入购物车，传递skuId和amount，非登录，获取cookie中的购物车，没有，创建购物车对象，将当前款商品追加到购物车，保存购物车到cookie中，cookie写回浏览器
 * 登录，将cookie中的购物车再取出，没有，创建购物车对象，将当前款追加到购物车中，将购物车追加到redis中，清空cookie
 *
 * 结算，非登录，取cookie中的购物车，没有购物车，回显，跳转购物页面
 * 登录，取cookie中的购物车，有购物车保存到redis中，取出redis中的购物车，没有，创建购物车，回显，跳转购物页面
 *
 * 展示：商品名字，单价，数量，总价，优惠，运费
 * 哪些要被存储
 *
 */

public abstract class Cart implements Serializable {


  private static final long serialVersionUID = 1L;

  protected abstract void addItem(Item item, int num);

  protected abstract int getProductInfo();

  protected abstract float getProductPrice();

  protected abstract float getFee();

  protected abstract float getTotalPrice();


}
