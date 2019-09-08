package net.riking.lcn.consumer.orders.rest;

import net.riking.core.entity.Result;
import net.riking.lcn.consumer.orders.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 */
@RestController
@RequestMapping("orders")
public class OrdersController {

    private final IOrdersService iOrdersService;

    @Autowired
    public OrdersController(IOrdersService iOrdersService) {
        this.iOrdersService = iOrdersService;
    }


    @RequestMapping("/add")
    public Result execute(@RequestParam("value") String value, @RequestParam(value = "ex", required = false) String exFlag) {
        return iOrdersService.add(value, exFlag);
    }


}
