package net.riking.provider.wallet.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.riking.provider.wallet.entity.Wallet;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface WalletMapper extends BaseMapper<Wallet> {


}