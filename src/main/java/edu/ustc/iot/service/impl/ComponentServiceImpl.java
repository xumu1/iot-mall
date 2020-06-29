package edu.ustc.iot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.ustc.iot.dao.ComponentMapper;
import edu.ustc.iot.dao.GatewayMapper;
import edu.ustc.iot.dao.SensorMapper;
import edu.ustc.iot.pojo.component.Component;
import edu.ustc.iot.pojo.enums.ResponseEnum;
import edu.ustc.iot.pojo.vo.reponse.ComponentResponse;
import edu.ustc.iot.pojo.vo.reponse.GatewayResponse;
import edu.ustc.iot.pojo.vo.reponse.SensorResponse;
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
  @SuppressWarnings("all")
  private GatewayMapper gatewayMapper;

  @Autowired
  @SuppressWarnings("all")
  private SensorMapper sensorMapper;

  //根据类型查找组件
  @Override
  public ResponseVo<PageInfo> list(Integer type, Integer pageNum, Integer pageSize) {

    PageHelper.startPage(pageNum,pageSize);
    List<Component> components = null;
    ComponentResponse component = null;
    if(type == 0){
      //传感器
      components = sensorMapper.selectByType();
    }else {
      //网关
      components = gatewayMapper.selectByType();
    }
    log.info("component={}",components);
    List<ComponentResponse> componentList = new ArrayList<>();
    for(Component element : components){
      if(type == 0){
        component = new SensorResponse();
      }else {
        component = new GatewayResponse();
      }
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
    ComponentResponse componentVo = null;
    if(componentType == 0){
      //传感器
      component = sensorMapper.selectByPrimaryKey(componentId);
      componentVo = new SensorResponse();
    }else{
      //网关
      component = gatewayMapper.selectByPrimaryKey(componentId);
      componentVo = new GatewayResponse();
    }
    BeanUtils.copyProperties(component,componentVo);
    return ResponseVo.success(componentVo);
  }

  // 根据类型添加
  @Override
  public ResponseVo<ComponentResponse> insertComponent(Integer componentType, Component component) {
    int insert;
    ComponentResponse componentResponse = null;
    if(componentType == 0){
      // sensor
      insert = sensorMapper.insert(component);
      componentResponse = new SensorResponse();
      BeanUtils.copyProperties(component,componentResponse);
      return ResponseVo.success(componentResponse);
    }else{
      // gateway
      insert = gatewayMapper.insert(component);
      componentResponse = new GatewayResponse();
      BeanUtils.copyProperties(component,componentResponse);
      return ResponseVo.success(componentResponse);
    }
//    return ResponseVo.error(ResponseEnum.INSERT_ERROR);
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

  //根据类型和id删除
  @Override
  public ResponseVo<ComponentResponse> deleteComponentById(Integer type,Integer componentId) {
    int i;
    if(type == 0){
      // 传感器
      i = sensorMapper.deleteComponentById(componentId);
    }else{
      // 网关
      i = gatewayMapper.deleteComponentById(componentId);
    }
    if(i == 1){
      return ResponseVo.success(new ComponentResponse(componentId));
    }else{
      return ResponseVo.error(ResponseEnum.DELETE_ERROR);
    }
  }

  //根据类型更新数据
  @Override
  public ResponseVo<ComponentResponse> updateComponent(Integer type, Component component) {
    int i;
    ComponentResponse componentResponse = null;
    if(type == 0){
      // sensor
      i = sensorMapper.updateByPrimaryKey(component);
      componentResponse = new SensorResponse();
      BeanUtils.copyProperties(component,componentResponse);
    }else{
      // gateway
      i = gatewayMapper.updateByPrimaryKey(component);
      componentResponse = new GatewayResponse();
      BeanUtils.copyProperties(component,componentResponse);
    }
    if(i == 1){
      return ResponseVo.success(componentResponse);
    }else{
      return ResponseVo.error(ResponseEnum.UPDATE_ERROR);
    }
  }
}
