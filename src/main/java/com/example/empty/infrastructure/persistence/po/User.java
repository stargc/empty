package com.example.empty.infrastructure.persistence.po;

import java.util.Date;

public class User {
    /**
     * 用户编号
     */
    private String userId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别,0:男 1:女
     */
    private Integer sex;

    /**
     * 证件类型,0：身份证
     */
    private Integer idType;

    /**
     * 证件号码
     */
    private String idNo;

    /**
     * 省份
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 地区
     */
    private String region;

    /**
     * 地址
     */
    private String address;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 手机
     */
    private String mobilePhone;

    /**
     * 办公室电话
     */
    private String officePhone;

    /**
     * 备注
     */
    private String remark;

    /**
     * 单位名称
     */
    private String unitName;

    /**
     * 行业ID
     */
    private String industryId;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dl_user.USER_ID
     *
     * @return the value of t_dl_user.USER_ID
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dl_user.USER_ID
     *
     * @param userId the value for t_dl_user.USER_ID
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dl_user.NAME
     *
     * @return the value of t_dl_user.NAME
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dl_user.NAME
     *
     * @param name the value for t_dl_user.NAME
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dl_user.SEX
     *
     * @return the value of t_dl_user.SEX
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dl_user.SEX
     *
     * @param sex the value for t_dl_user.SEX
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dl_user.ID_TYPE
     *
     * @return the value of t_dl_user.ID_TYPE
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public Integer getIdType() {
        return idType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dl_user.ID_TYPE
     *
     * @param idType the value for t_dl_user.ID_TYPE
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dl_user.ID_NO
     *
     * @return the value of t_dl_user.ID_NO
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public String getIdNo() {
        return idNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dl_user.ID_NO
     *
     * @param idNo the value for t_dl_user.ID_NO
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dl_user.PROVINCE
     *
     * @return the value of t_dl_user.PROVINCE
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dl_user.PROVINCE
     *
     * @param province the value for t_dl_user.PROVINCE
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dl_user.CITY
     *
     * @return the value of t_dl_user.CITY
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dl_user.CITY
     *
     * @param city the value for t_dl_user.CITY
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dl_user.REGION
     *
     * @return the value of t_dl_user.REGION
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public String getRegion() {
        return region;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dl_user.REGION
     *
     * @param region the value for t_dl_user.REGION
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dl_user.ADDRESS
     *
     * @return the value of t_dl_user.ADDRESS
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dl_user.ADDRESS
     *
     * @param address the value for t_dl_user.ADDRESS
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dl_user.EMAIL
     *
     * @return the value of t_dl_user.EMAIL
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dl_user.EMAIL
     *
     * @param email the value for t_dl_user.EMAIL
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dl_user.PHONE
     *
     * @return the value of t_dl_user.PHONE
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dl_user.PHONE
     *
     * @param phone the value for t_dl_user.PHONE
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dl_user.MOBILE_PHONE
     *
     * @return the value of t_dl_user.MOBILE_PHONE
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dl_user.MOBILE_PHONE
     *
     * @param mobilePhone the value for t_dl_user.MOBILE_PHONE
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dl_user.OFFICE_PHONE
     *
     * @return the value of t_dl_user.OFFICE_PHONE
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public String getOfficePhone() {
        return officePhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dl_user.OFFICE_PHONE
     *
     * @param officePhone the value for t_dl_user.OFFICE_PHONE
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone == null ? null : officePhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dl_user.REMARK
     *
     * @return the value of t_dl_user.REMARK
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dl_user.REMARK
     *
     * @param remark the value for t_dl_user.REMARK
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dl_user.UNIT_NAME
     *
     * @return the value of t_dl_user.UNIT_NAME
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dl_user.UNIT_NAME
     *
     * @param unitName the value for t_dl_user.UNIT_NAME
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dl_user.INDUSTRY_ID
     *
     * @return the value of t_dl_user.INDUSTRY_ID
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public String getIndustryId() {
        return industryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dl_user.INDUSTRY_ID
     *
     * @param industryId the value for t_dl_user.INDUSTRY_ID
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public void setIndustryId(String industryId) {
        this.industryId = industryId == null ? null : industryId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dl_user.BIRTHDAY
     *
     * @return the value of t_dl_user.BIRTHDAY
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dl_user.BIRTHDAY
     *
     * @param birthday the value for t_dl_user.BIRTHDAY
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}