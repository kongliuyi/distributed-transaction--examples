package net.riking.provider.fruits.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.codingapi.txlcn.common.util.Transactions;
import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.codingapi.txlcn.tracing.TracingContext;
import net.bytebuddy.asm.Advice;
import net.riking.provider.fruits.dao.FruitsMapper;
import net.riking.provider.fruits.entity.Fruits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FruitsService implements  IFruitsService {

    @Autowired
    FruitsMapper fruitsMapper;

    public Fruits add(String name) {
        Fruits      fruits =new Fruits();
        fruits.setName(name);
        fruits.setPrice(5d);
        fruits.setStock(100L);
        fruitsMapper.insert(fruits);
        return  fruits;
    }

    @Override
    @TxcTransaction(propagation = DTXPropagation.SUPPORTS)
    @Transactional  //本地事务注解
    public Double updateByName(String name) {
        System.out.println("GroupId:"+(TracingContext.tracing().groupId())+"AppName:"+(Transactions.getApplicationId()));
        QueryWrapper<Fruits> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        Fruits fruits = fruitsMapper.selectOne(queryWrapper);
        fruits.setStock(fruits.getStock()-1);
        fruitsMapper.updateById(fruits);
         return   fruits.getPrice();
    }



}
