package net.riking.lcn.consumer.orders.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.riking.lcn.consumer.orders.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrdersMapper extends BaseMapper<Orders> {


}