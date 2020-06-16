package edu.ustc.iot.service;

import com.github.pagehelper.PageInfo;
import edu.ustc.iot.pojo.vo.ResponseVo;
import edu.ustc.iot.pojo.vo.reponse.ComponentResponse;

/**
 * 功能描述：
 *
 * @Author: xumu
 * @Date: 2020-5-18 14:03
 */
public interface IComponentService {
  ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

  ResponseVo<ComponentResponse> selectByComponentId(Integer componentId,Integer componentType);
}
