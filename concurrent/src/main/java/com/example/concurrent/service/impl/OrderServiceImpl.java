package com.example.concurrent.service.impl;

import com.example.concurrent.entity.OrderModel;
import com.example.concurrent.entity.ProductModel;
import com.example.concurrent.mapper.OrderMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.concurrent.service.IOrderService;
import com.example.concurrent.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author missj
 * @since 2018-12-10
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderModel> implements IOrderService {

    @Autowired
    private IProductService productService;


    @Override
    @Transactional
    public boolean purchase(int userId, int productId, int num) {
        for (int i=0; i < 3; i++){
            // 无锁
            ProductModel model = productService.getById(productId);
            // 乐观锁
            //ProductModel model = productService.selectModelById(productId);
            if (model == null){
                // 无该产品
                return false;
            } else {
                if (model.getStock() < num){
                    // 库存不足
                    return false;
                }

                // 修改库存
                //productService.decreaseProduct(model.getId(), num);
                boolean des = productService.decreaseProduct2(model.getId(), num, model.getVersion());

                // 初始化购买记录
                if (des){
                    OrderModel orderModel = new OrderModel();
                    orderModel.setUserId(userId);
                    orderModel.setNumber(num);
                    orderModel.setPrice(model.getPrice());
                    orderModel.setTotalPrice(model.getPrice().multiply(new BigDecimal(num)));
                    orderModel.setProductId(productId);
                    orderModel.setOrderTime(LocalDateTime.now());
                    boolean bo = super.save(orderModel);
                    if (bo){
                        // 购买成功
                        return true;
                    }
                }
            }

        }
        return false;
    }
}
