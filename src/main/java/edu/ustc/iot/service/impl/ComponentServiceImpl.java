package edu.ustc.iot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.ustc.iot.dao.ComponentMapper;
import edu.ustc.iot.dao.GatewayMapper;
import edu.ustc.iot.dao.SensorMapper;
import edu.ustc.iot.pojo.component.Component;
import edu.ustc.iot.pojo.vo.reponse.ComponentResponse;
import edu.ustc.iot.pojo.vo.request.form.ComponentForm;
import edu.ustc.iot.service.IComponentService;
import edu.ustc.iot.pojo.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
  private GatewayMapper gatewayMapper;

  @Autowired
  private SensorMapper sensorMapper;

  //根据类型查找组件
  @Override
  public ResponseVo<PageInfo> list(Integer type, Integer pageNum, Integer pageSize) {

    PageHelper.startPage(pageNum,pageSize);
    List<Component> components = null;
    if(type == 0){
      //传感器
      components = sensorMapper.selectByType(type);
    }else {
      //网关
      components = gatewayMapper.selectByType(type);
    }
    log.info("component={}",components);
    List<ComponentResponse> componentList = new ArrayList<>();
    for(Component element : components){
      ComponentResponse component = new ComponentResponse();
      BeanUtils.copyProperties(element, component);
      componentList.add(component);
    }
    PageInfo pageInfo = new PageInfo<>(components);
    pageInfo.setList(componentList);
    return ResponseVo.success(pageInfo);
  }

  // 根据类型和id查询
  @Override
  public ResponseVo<ComponentResponse> selectByComponentId(Integer componentId,Integer componentType) {
    // 根据type的不同，来对不同数据库进行查询
    Component component = null;
    if(componentType == 0){
      //传感器
      component = sensorMapper.selectByPrimaryKey(componentId);
    }else{
      //网关
      component = gatewayMapper.selectByPrimaryKey(componentId);
    }
    ComponentResponse componentVo = new ComponentResponse();
    BeanUtils.copyProperties(component,componentVo);
    return ResponseVo.success(componentVo);
  }

  // 根据类型添加
  @Override
  public ResponseVo<ComponentResponse> insertComponent(Integer componentType, Component component) {
    return null;
  }

  // 根据component传过来的数据来进行分析进行那些查找操作
  @Override
  public ResponseVo<PageInfo> selectByExample(ComponentForm componentForm) {
    Integer pageNum = componentForm.getPageNum();
    Integer pageSize = componentForm.getPageSize();
    PageHelper.startPage(pageNum,pageSize);
    List<Component> components = null;
    if(componentForm.getType() == 0){
      //传感器
      components = sensorMapper.selectByExample(componentForm.getComponent());
    }else {
      //网关
      components = gatewayMapper.selectByExample(componentForm.getComponent());
    }
    log.info("component={}",components);
    List<ComponentResponse> componentList = new ArrayList<>();
    for(Component element : components){
      ComponentResponse component = new ComponentResponse();
      BeanUtils.copyProperties(element, component);
      componentList.add(component);
    }
    PageInfo pageInfo = new PageInfo<>(components);
    pageInfo.setList(componentList);
    return ResponseVo.success(pageInfo);
  }
}
