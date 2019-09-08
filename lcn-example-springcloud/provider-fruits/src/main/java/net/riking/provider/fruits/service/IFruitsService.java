package net.riking.provider.fruits.service;


import net.riking.provider.fruits.entity.Fruits;

public interface IFruitsService {

    Fruits add(String name);

    Double updateByName(String name );

}
