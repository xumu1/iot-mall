package edu.ustc.iot.dao;

import edu.ustc.iot.pojo.User;

/**
 * 功能描述：
 *
 * @Author: xumu
 * @Date: 2020-5-17 16:21
 */
public interface UserMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(User record);

  int insertSelective(User record);

  User selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(User record);

  int updateByPrimaryKey(User record);

  User selectByUsername(String username);
}
