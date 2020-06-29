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

  //根据id删除
  int deleteComponentById(Integer id);

  int insert(Component record);

  //根据主键查找
  Component selectByPrimaryKey(Integer id);

  int updateByPrimaryKey(Component record);

  //根据类型查找
  List<Component> selectByType();

  //条件查询
  List<Component> selectByExample(Component component);
}
