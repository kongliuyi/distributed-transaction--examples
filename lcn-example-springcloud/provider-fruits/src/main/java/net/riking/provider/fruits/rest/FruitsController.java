package net.riking.provider.fruits.rest;

import net.riking.core.entity.Result;

import net.riking.provider.fruits.service.IFruitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/fruits")
public class FruitsController {

    @Autowired
    IFruitsService iFruitsService;


    @GetMapping("add")
    public Result add(@RequestParam String name) {
        return  Result.success(iFruitsService.add(name)) ;
    }


    @GetMapping("provider")
    public Result provider(@RequestParam String name , @RequestParam(value = "ex", required = false) String exFlag) {
        return  Result.success(iFruitsService.updateByName(name)) ;
    }

}
