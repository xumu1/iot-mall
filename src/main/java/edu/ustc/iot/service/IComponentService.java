package edu.ustc.iot.service;

import com.github.pagehelper.PageInfo;
import edu.ustc.iot.pojo.component.Component;
import edu.ustc.iot.pojo.vo.ResponseVo;
import edu.ustc.iot.pojo.vo.reponse.ComponentResponse;
import edu.ustc.iot.pojo.vo.request.form.ComponentForm;

/**
 * 功能描述：
 *
 * @Author: xumu
 * @Date: 2020-5-18 14:03
 */
public interface IComponentService {
  ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

  ResponseVo<ComponentResponse> selectByComponentId(Integer componentId,Integer componentType);

  ResponseVo<ComponentResponse> insertComponent(Integer componentType, Component component);

    ResponseVo<PageInfo> selectByExample(ComponentForm componentForm);
}
