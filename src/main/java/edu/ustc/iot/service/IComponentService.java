package edu.ustc.iot.service;

import com.github.pagehelper.PageInfo;
import edu.ustc.iot.vo.ComponentVo;
import edu.ustc.iot.vo.ResponseVo;

/**
 * 功能描述：
 *
 * @Author: xumu
 * @Date: 2020-5-18 14:03
 */
public interface IComponentService {
  ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize);

  ResponseVo<ComponentVo> selectByComponentId(Integer componentId);
}
