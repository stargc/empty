package com.example.empty.infrastructure.persistence.mapper;

import com.example.empty.infrastructure.persistence.po.User;
import com.example.empty.infrastructure.persistence.po.UserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dl_user
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    long countByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dl_user
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    int deleteByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dl_user
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    int deleteByPrimaryKey(String userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dl_user
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    int insert(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dl_user
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    int insertSelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dl_user
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    List<User> selectByExample(UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dl_user
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    User selectByPrimaryKey(String userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dl_user
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dl_user
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dl_user
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_dl_user
     *
     * @mbg.generated Fri Sep 20 16:19:56 CST 2019
     */
    int updateByPrimaryKey(User record);
}