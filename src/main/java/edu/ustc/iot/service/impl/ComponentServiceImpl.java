package edu.ustc.iot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.ustc.iot.dao.ComponentMapper;
import edu.ustc.iot.pojo.Component;
import edu.ustc.iot.service.IComponentService;
import edu.ustc.iot.vo.ComponentVo;
import edu.ustc.iot.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 功能描述：
 *
 * @Author: xumu
 * @Date: 2020-5-18 14:05
 */
@Service
@Slf4j
public class ComponentServiceImpl implements IComponentService {

  @Autowired
  @SuppressWarnings("all")
  private ComponentMapper componentMapper;

  //根据类型查找组件
  @Override
  public ResponseVo<PageInfo> list(Integer type, Integer pageNum, Integer pageSize) {

    PageHelper.startPage(pageNum,pageSize);
    List<Component> components = componentMapper.selectByType(type);
    log.info("component={}",components);

    List<ComponentVo> componentVoList = new ArrayList<>();
    for(Component component : components){
      ComponentVo componentVo = new ComponentVo();
      BeanUtils.copyProperties(component, componentVo);
      componentVoList.add(componentVo);
    }
    PageInfo pageInfo = new PageInfo<>(components);
    pageInfo.setList(componentVoList);
    return ResponseVo.success(pageInfo);
  }

  @Override
  public ResponseVo<ComponentVo> selectByComponentId(Integer componentId) {
    Component component = componentMapper.selectByPrimaryKey(componentId);
    ComponentVo componentVo = new ComponentVo();
    BeanUtils.copyProperties(component,componentVo);
    return ResponseVo.success(componentVo);
  }
}
