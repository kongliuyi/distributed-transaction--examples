package net.riking.provider.wallet.rest;

import net.riking.core.entity.Result;
import net.riking.provider.wallet.service.IWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    IWalletService iWalletService;

    @GetMapping("add")
    public Result add(@RequestParam Double balance) {
        return  Result.success(iWalletService.add(balance)) ;
    }



    @GetMapping("provider")
    public Result provider(@RequestParam Double balance) {
        iWalletService.updateByUserId(balance);
        return  Result.success() ;
    }

}
