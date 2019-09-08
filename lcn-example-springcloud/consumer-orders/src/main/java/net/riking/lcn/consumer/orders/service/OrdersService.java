package net.riking.lcn.consumer.orders.service;

import com.codingapi.txlcn.common.util.Transactions;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tracing.TracingContext;
import net.riking.core.entity.Result;
import net.riking.lcn.consumer.orders.dao.OrdersMapper;
import net.riking.lcn.consumer.orders.entity.Orders;
import net.riking.lcn.consumer.orders.remote.ProviderFruitsRemote;
import net.riking.lcn.consumer.orders.remote.ProviderWalletRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;

@Service
public class OrdersService implements IOrdersService {
    private final OrdersMapper ordersMapper;

    private final ProviderFruitsRemote providerFruitsRemote;

    private final ProviderWalletRemote providerWalletRemote;

    @Autowired
    public OrdersService(OrdersMapper ordersMapper, ProviderFruitsRemote providerFruitsRemote, ProviderWalletRemote providerWalletRemote) {
        this.ordersMapper = ordersMapper;
        this.providerFruitsRemote = providerFruitsRemote;
        this.providerWalletRemote = providerWalletRemote;
    }

    @Override
    @Transactional
    @LcnTransaction //分布式事务注解
    public Result add(String name,String exFlag) {

        System.out.println("GroupId:"+(TracingContext.tracing().groupId())+"AppName:"+(Transactions.getApplicationId()));
        // step1. call remote ServiceFruits
        Result fruitsResult = providerFruitsRemote.provider(name);
        Double  price= fruitsResult.isSuccess()?     (Double)fruitsResult.getData(): 0d;
        // step2. call remote Wallet
        Result walletResult = providerWalletRemote.provider(price);
        // step3. execute local transaction
        Orders  orders= new  Orders();
        orders.setName(name);
        orders.setOrderMoney(price);
        orders.setOrderCreatetimer(new Date());
        orders.setOrderState(1);
        ordersMapper.insert(orders);
        // 置异常标志，DTX 回滚
        if (Objects.nonNull(exFlag)) {
            throw new IllegalStateException("by exFlag");
        }
        if(fruitsResult.isSuccess()&&walletResult.isSuccess())
            return   Result.success();
        return Result.fail("fruitsResult:"+fruitsResult.isSuccess()+"----walletResult:"+walletResult.isSuccess()+"----ordersResult:"+"OK");
    }
}
