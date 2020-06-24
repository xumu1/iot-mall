package edu.ustc.iot.dao;

import edu.ustc.iot.pojo.component.Component;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 功能描述：
 *
 * @Author: xumu
 * @Date: 2020-5-18 14:11
 */
@Mapper
public interface ComponentMapper {

  int deleteByPrimaryKey(Integer id);

  int insert(Component record);

  int insertSelective(Component record);

  //根据主键查找
  Component selectByPrimaryKey(Integer id);

  int updateByPrimaryKeySelective(Component record);

  int updateByPrimaryKey(Component record);

  //根据类型查找
  List<Component> selectByType();

  List<Component> selectByExample(Component component);
}
