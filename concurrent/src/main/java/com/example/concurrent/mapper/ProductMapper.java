package com.example.concurrent.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.concurrent.entity.ProductModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.io.Serializable;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author missj
 * @since 2018-12-10
 */
public interface ProductMapper extends BaseMapper<ProductModel> {
    @Update("UPDATE product set stock = stock - #{num}, version = version + 1 " +
            "where id = #{id} and version = #{version}")
    boolean decreaseProduct(@Param("id") int id, @Param("num") int num);

    @Select("select  * from product where id = #{productId} for update")
    ProductModel selectModelById(int productId);

    @Update("UPDATE product set stock = stock - #{num}, version = version + 1 " +
            "where id = #{id} and version = #{version}")
    boolean decreaseProduct2(@Param("id") int id, @Param("num") int num, @Param("version") int version);
}
