package com.example.concurrent.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.concurrent.entity.ProductModel;
import com.example.concurrent.mapper.ProductMapper;
import com.example.concurrent.service.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author missj
 * @since 2018-12-10
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, ProductModel> implements IProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public boolean decreaseProduct(int id, int num) {
        return productMapper.decreaseProduct(id, num);
    }

    @Override
    public ProductModel selectModelById(int productId) {
        return productMapper.selectModelById(productId);
    }

    @Override
    public boolean decreaseProduct2(int id, int num, int version) {
        return productMapper.decreaseProduct2(id, num, version);
    }

}
