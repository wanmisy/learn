package com.example.concurrent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.concurrent.entity.OrderModel;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author missj
 * @since 2018-12-10
 */
public interface IOrderService extends IService<OrderModel> {
    boolean purchase(int userId, int productId, int num);

}
