package com.example.concurrent.controller;


import com.example.concurrent.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author missj
 * @since 2018-12-10
 */
@RestController
@RequestMapping("/product/order-model")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping("/purchase")
    @ResponseBody
    public Result purchase(int userId, int productId, int num){
        boolean bo = orderService.purchase(userId, productId, num);
        Result result = new Result(bo, bo == true ? "抢购成功" : "抢购失败");
        return result;
    }

}
