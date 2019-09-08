package net.riking.lcn.consumer.orders.remote;


import net.riking.core.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "provider-fruits", fallback = ProviderRemoteFallback.class)
public interface ProviderFruitsRemote {
    @GetMapping("/fruits/provider")
    Result provider(@RequestParam("name") String name);

}
