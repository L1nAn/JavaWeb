package com.mazhiwei.mybatis.mapper;

import com.mazhiwei.mybatis.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 马治伟
 * @version 1.0
 */
public interface BrandMapper {
    List<Brand> selectAll();

    Brand selectById(@Param("id") Integer id);

    //模糊查询
//  List<Brand> selectByAll(@Param("status")Integer status,@Param("companyName")String companyName,@Param("brandName")String brandName);
    List<Brand> selectByAll(Brand brand);

    /**
     * 单条件动态查询
     * @param brand
     * @return
     */
    List<Brand> selectByConditionSingle(Brand brand);

    /**
     * 添加数据
     */
    void insertBrand(Brand brand);

    /**
     * 修改功能
     */
    void updateBrand(Brand brand);

    /**
     * 删除一行数据
     */
    void deleteId(@Param("id") Integer id);

    /**
     * 批量删除
     */
    void deleteAll(@Param("ids") int[] ids);
}
