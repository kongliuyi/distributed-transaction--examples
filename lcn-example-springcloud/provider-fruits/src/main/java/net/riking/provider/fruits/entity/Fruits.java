package net.riking.provider.fruits.entity;

import lombok.Data;

@Data
public class Fruits {

private  Long id;
//商品名称
private  String name;
//库存
private  Long  stock;
//价格
private  Double  price;
}
