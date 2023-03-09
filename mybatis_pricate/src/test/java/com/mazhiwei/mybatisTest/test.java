package com.mazhiwei.mybatisTest;

import com.mazhiwei.mybatis.mapper.BrandMapper;
import com.mazhiwei.mybatis.pojo.Brand;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.mazhiwei.utils.SqlSessionUtil;

import java.util.List;

/**
 * @author 马治伟
 * @version 1.0
 */
public class test {

    @Test
    public void selectAll() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();

        for (Brand brand : brands) {
            System.out.println(brand);
        }
        sqlSession.close();
    }

    /**
     * 查询详情
     */
    @Test
    public void selectById() {
        int id = 1;
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);
        System.out.println(brand);
        sqlSession.close();
    }

    /**
     * 模糊查询
     */
    @Test
    public void selectByAll() {
        String brandName = "华为";
        String companyName = "华为";
        Integer status = 1;
        brandName = "%" + brandName + "%";
        companyName = "%" + companyName + "%";
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand();
//        brand.setCompanyName(companyName);
//        brand.setStatus(status);
        brand.setBrandName(brandName);
//        List<Brand> brands = mapper.selectByAll(status, companyName, brandName);
        List<Brand> brands = mapper.selectByAll(brand);
        for (Brand brand1 : brands) {
            System.out.println(brand1);
        }
        sqlSession.close();
    }

    /**
     * 单条件查询
     */
    @Test
    public void selectByConditionSingle() {
        String brandName = "华为";
        String companyName = "华为";
        Integer status = 1;
        brandName = "%" + brandName + "%";
        companyName = "%" + companyName + "%";
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = new Brand();
//        brand.setCompanyName(companyName);
//        brand.setStatus(status);
//        brand.setBrandName(brandName);
        List<Brand> brands = mapper.selectByConditionSingle(brand);
        for (Brand brand1 : brands) {
            System.out.println(brand1);
        }
        sqlSession.close();
    }

    /**
     * 添加数据
     */
    @Test
    public void insertBrand() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand();
        brand.setBrandName("京东");
        brand.setCompanyName("京东物流");
        brand.setOrdered(100);
        brand.setDescription("我要去京东");
        brand.setStatus(1);
        mapper.insertBrand(brand);

        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 主键返回
     */
    @Test
    public void addBrand() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand();
        brand.setBrandName("京东");
        brand.setCompanyName("京东物流");
        brand.setOrdered(100);
        brand.setDescription("我要去京东");
        brand.setStatus(1);
        mapper.insertBrand(brand);
        sqlSession.commit();
        System.out.println(brand.getId());
        sqlSession.close();
    }

    /**
     * 修改功能
     */
    @Test
    public void updateBrand() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = new Brand();
        brand.setBrandName("波导手机");
        brand.setCompanyName("波导");
        brand.setOrdered(55);
        brand.setDescription("手机中的战斗机");
        brand.setStatus(0);
        brand.setId(4);

        mapper.updateBrand(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 删除数据
     */
    @Test
    public void delete() {
        int id = 6;
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteId(id);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 批量删除数据
     */
    @Test
    public void deleteAll() {
        int[] ids = {1,3,5};
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteAll(ids);
        sqlSession.commit();
        sqlSession.close();
    }
}
