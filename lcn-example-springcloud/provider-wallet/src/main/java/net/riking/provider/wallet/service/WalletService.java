package net.riking.provider.wallet.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.codingapi.txlcn.common.util.Transactions;
import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.TccTransaction;
import com.codingapi.txlcn.tracing.TracingContext;
import net.riking.provider.wallet.dao.WalletMapper;
import net.riking.provider.wallet.entity.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WalletService implements  IWalletService {
    @Autowired
    WalletMapper walletMapper;

    @Override
    public Wallet add(Double balance) {
        Wallet wallet=   new Wallet();
        wallet.setUserId(1L);
        wallet.setBalance(balance);
        walletMapper.insert(wallet);
        return wallet;
    }

    @Override
    @TccTransaction(propagation = DTXPropagation.SUPPORTS)
    @Transactional  //本地事务注解
    public void updateByUserId(Double balance) {
        System.out.println("GroupId:"+(TracingContext.tracing().groupId())+"AppName:"+(Transactions.getApplicationId()));
        QueryWrapper<Wallet> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", 1);
        Wallet wallet = walletMapper.selectOne(queryWrapper);
        wallet.setBalance(wallet.getBalance()-balance);
        walletMapper.updateById(wallet);
    }
}
