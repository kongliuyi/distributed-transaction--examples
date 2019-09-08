package net.riking.lcn.consumer.orders.remote;

import com.codingapi.txlcn.tc.support.DTXUserControls;
import com.codingapi.txlcn.tracing.TracingContext;
import net.riking.core.entity.Result;
import net.riking.core.exception.SystemErrorType;
import org.springframework.stereotype.Component;

@Component
public class ProviderRemoteFallback implements ProviderFruitsRemote , ProviderWalletRemote {
    @Override
    public Result provider(String name) {
        DTXUserControls.rollbackGroup(TracingContext.tracing().groupId());
        return Result.fail(SystemErrorType.SYSTEM_BUSY);
    }

    @Override
    public Result provider(Double balance)
    {
        DTXUserControls.rollbackGroup(TracingContext.tracing().groupId());
        return Result.fail(SystemErrorType.SYSTEM_BUSY);
    }
}
