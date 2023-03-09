package com.mazhiwei.mybatis.pojo;

/**
 * @author 马治伟
 * @version 1.0
 */
public class Brand {
   // id 主键
   private Integer id;
   // 品牌名称
   private String brandName;
   // 企业名称
   private String companyName;
   // 排序字段
   private Integer ordered;
   // 描述信息
   private String description;
   // 状态：0：禁用  1：启用
   private Integer status;

   //省略 setter and getter。自己写时要补全这部分代码

   @Override
   public String toString() {
      return "Brand{" +
              "id=" + id +
              ", brandName='" + brandName + '\'' +
              ", companyName='" + companyName + '\'' +
              ", ordered=" + ordered +
              ", description='" + description + '\'' +
              ", status=" + status +
              '}';
   }

   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getBrandName() {
      return brandName;
   }

   public void setBrandName(String brandName) {
      this.brandName = brandName;
   }

   public String getCompanyName() {
      return companyName;
   }

   public void setCompanyName(String companyName) {
      this.companyName = companyName;
   }

   public Integer getOrdered() {
      return ordered;
   }

   public void setOrdered(Integer ordered) {
      this.ordered = ordered;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Integer getStatus() {
      return status;
   }

   public void setStatus(Integer status) {
      this.status = status;
   }
}