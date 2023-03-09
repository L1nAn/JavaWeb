package com.mazhiwei.mybatisTest;

import com.mazhiwei.mybatis.mapper.BrandMapper;
import com.mazhiwei.mybatis.pojo.Brand;
import com.mazhiwei.mybatis.pojo.Dept;
import com.mazhiwei.mybatis.pojo.Emp;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.mazhiwei.utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * Map 作为参数
     */
    @Test
    public void selectAll1() {
        String brandName = "华为";
        String companyName = "华为";
        Integer status = 1;
        Integer id = 2;
        brandName = "%" + brandName + "%";
        companyName = "%" + companyName + "%";
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        map.put("companyName",companyName);
        List<Brand> brands = mapper.selectAll1(map);
        for (Brand brand : brands) {
            System.out.println(brand);
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
        //有另外一种说法
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

    @Test
    public void deleteMore() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        String ids = "1,2,3";
        mapper.deleteMore(ids);
        sqlSession.commit();
        sqlSession.close();
    }
    /**
     * 查询总记录数
     */
    @Test
    public void getCount() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int count = mapper.getCount();
        System.out.println(count);
        sqlSession.close();
    }
    /**
     *
     * 查询一条数据Map集合
     */
    @Test
    public void selectMap() {
        int id = 2;
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Map<String, Object> map = mapper.selectByIdMap(id);
        System.out.println(map);
        sqlSession.close();
    }

    /**
     * 动态切换表明
     */
    @Test
    public void selectAll0() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Object> list = mapper.selectAllo("tb_brand");
        System.out.println(list);
    }

    /**
     *
     * 查询员工信息以及对应的部门信息
     */
    @Test
    public void selectAllM() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Emp> emps = mapper.selectAllEmp(7499);
        for(Emp e : emps) {
            System.out.println(e);
        }
        sqlSession.close();
    }

    /**
     * 分布查询
     */
    @Test
    public void selectAllv() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Emp empByStep = mapper.getEmpByStep(7499);
        System.out.println(empByStep.getDeptno());
        sqlSession.close();
    }

    @Test
    public void selectAllf() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Dept deptEmpByDeptno = mapper.getDeptEmpByDeptno(20);
        System.out.println(deptEmpByDeptno);
        sqlSession.close();
    }

    @Test
    public void selectAllp() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Dept deptByStep = mapper.getDeptByStep(20);
        System.out.println(deptByStep);
        sqlSession.close();
    }
}
