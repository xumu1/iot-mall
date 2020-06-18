package edu.ustc.iot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.ustc.iot.dao.ComponentMapper;
import edu.ustc.iot.dao.GatewayMapper;
import edu.ustc.iot.dao.SensorMapper;
import edu.ustc.iot.pojo.component.Component;
import edu.ustc.iot.pojo.vo.reponse.ComponentResponse;
import edu.ustc.iot.pojo.vo.reponse.GatewayResponse;
import edu.ustc.iot.pojo.vo.reponse.SensorResponse;
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
      // TODO
      //传感器
      components = sensorMapper.selectByType();
      component = new SensorResponse();
    }else {
      // TODO
      //网关
      components = gatewayMapper.selectByType();
      component = new GatewayResponse();
    }
    log.info("component={}",components);
    List<ComponentResponse> componentList = new ArrayList<>();
    for(Component element : components){
      BeanUtils.copyProperties(element, component);
      componentList.add(component);
    }
    PageInfo pageInfo = new PageInfo<>(components);
    pageInfo.setList(components);
    return ResponseVo.success(pageInfo,"列表查询成功");
  }

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
}
