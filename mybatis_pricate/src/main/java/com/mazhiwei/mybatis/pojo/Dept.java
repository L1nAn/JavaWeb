package com.mazhiwei.mybatis.pojo;

import java.util.List;

/**
 * @author 马治伟
 * @version 1.0
 */
public class Dept {
   Integer deptno;
   String dname;
   String loc;
   List<Emp> emp;

   @Override
   public String toString() {
      return "Dept{" +
              "deptno=" + deptno +
              ", dname='" + dname + '\'' +
              ", loc='" + loc + '\'' +
              ", emp=" + emp +
              '}';
   }

   public List<Emp> getEmp() {
      return emp;
   }

   public void setEmp(List<Emp> emp) {
      this.emp = emp;
   }

   public Integer getDeptno() {
      return deptno;
   }

   public void setDeptno(Integer deptno) {
      this.deptno = deptno;
   }

   public String getDname() {
      return dname;
   }

   public void setDname(String dname) {
      this.dname = dname;
   }

   public String getLoc() {
      return loc;
   }

   public void setLoc(String loc) {
      this.loc = loc;
   }
}
