package com.mazhiwei.mybatis.mapper;

import com.mazhiwei.mybatis.pojo.Brand;
import com.mazhiwei.mybatis.pojo.Dept;
import com.mazhiwei.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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

    List<Brand> selectAll1(Map<String, Object> map);

    /**
     * 单条件动态查询
     *
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

    void deleteMore(@Param("ids") String ids);

    /**
     * 查询总记录数
     */
    int getCount();

    /**
     * 查询一条数据为map集合
     */
    Map<String, Object> selectByIdMap(@Param("id") Integer id);

    /**
     * 动态设置表名，查询表的所有数据
     */
    List<Object> selectAllo(@Param("tableName") String tableName);

    /**
     * 查询员工信息以及对应的部门信息
     */
    List<Emp> selectAllEmp(@Param("empno") Integer empno);

    /**
     * 分布查询
     */
    Emp getEmpByStep(@Param("empno") Integer empno);

    Dept getEmpDeptByStep(@Param("deptno") Integer deptno);

    /**
     * 根据部门id
     */
    Dept getDeptEmpByDeptno(@Param("deptno") Integer deptno);

    /**
     * 分布查询
     */
    Dept getDeptByStep(@Param("deptno") Integer deptno);

    List<Emp> getEmpListByD(@Param("deptno") Integer deptno);
}
