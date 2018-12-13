package com.example.concurrent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.concurrent.entity.ProductModel;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author missj
 * @since 2018-12-10
 */
public interface IProductService extends IService<ProductModel> {
    boolean decreaseProduct(int id, int num);

    boolean decreaseProduct2(int id, int num, int version);

    ProductModel selectModelById(int productId);
}
