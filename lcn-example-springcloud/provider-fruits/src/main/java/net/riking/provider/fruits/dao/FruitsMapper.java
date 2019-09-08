package net.riking.provider.fruits.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.riking.provider.fruits.entity.Fruits;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface FruitsMapper extends BaseMapper<Fruits> {


}