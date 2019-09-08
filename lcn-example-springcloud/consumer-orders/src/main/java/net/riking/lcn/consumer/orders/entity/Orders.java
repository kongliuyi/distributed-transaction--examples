package net.riking.lcn.consumer.orders.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Orders {

    private  Long id;

    private  String name;

    private Date orderCreatetimer;

    private  Double orderMoney;

    private  int orderState;

   // private  Long commodityId;

}
