package com.mazhiwei.mapper;

import com.mazhiwei.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 马治伟
 * @version 1.0
 */
public interface BrandMapper {
    /**
     * 查询所有
     */
    List<Brand> selectAll();

    /**
     * 添加功能
     */
    void add(Brand brand);

    /**
     * 查询单条数据
     */
    Brand selectByIdBrand(@Param("id") int id);

    /**
     * 修改功能
     */
    void update(Brand brand);

    /**
     *
     * 删除功能
     */
    void delete(@Param("id") int id);
}
