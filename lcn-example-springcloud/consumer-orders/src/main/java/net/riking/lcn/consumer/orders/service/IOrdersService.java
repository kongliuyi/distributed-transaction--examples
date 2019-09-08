package net.riking.lcn.consumer.orders.service;


import net.riking.core.entity.Result;

public interface IOrdersService {

    Result add(String name, String exFlag);

}
