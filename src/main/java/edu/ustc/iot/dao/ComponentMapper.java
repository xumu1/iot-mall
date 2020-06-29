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


  int deleteComponentById(Integer id);

  int insert(Component record);

  int updateByPrimaryKey(Component record);

  List<Component> selectByType();

  List<Component> selectByExample(Component component);

  Component selectByPrimaryKey(Integer id);
}
