package edu.ustc.iot.controller;

import com.github.pagehelper.PageInfo;
import edu.ustc.iot.pojo.Component;
import edu.ustc.iot.pojo.vo.reponse.ComponentResponse;
import edu.ustc.iot.service.impl.ComponentServiceImpl;
import edu.ustc.iot.pojo.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述：
 *
 * @Author: xumu
 * @Date: 2020-5-18 14:06
 */
@RestController
public class ComponentController {
  @Autowired
  @SuppressWarnings("all")
  private ComponentServiceImpl componentService;

  @GetMapping("/components") //返回商品列表（引入pagehelper达到分页效果），参数通过get请求中携带的参数传递
  public ResponseVo<PageInfo> list(@RequestParam(value = "type", required = false) Integer type,
                                   @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
    return componentService.list(type, pageNum, pageSize);
  }

  @GetMapping("/components/{componentId}") //查询某一商品，参数在url中传递
  public ResponseVo<ComponentResponse> showProductDetail(@PathVariable(value = "componentId") Integer componentId){
    return componentService.selectByComponentId(componentId);
  }
}
